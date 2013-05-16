grammar miniP;
options{
output=AST;
ASTLabelType=CommonTree;
}
/*
########## TOKENS #########
*/
// KEYWORDS
tokens{
	PROGRAMM='programm';
	BEGIN='begin';
	END='end';
	INTEGER_TYP='integer';
	FLOAT_TYP='float';
	STRING_TYP='string';
	BOOLEAN_TYP='boolean';
	STATEMENT_END=';';
	SEPERATOR = ',';
	WENN =	'wenn';
	DANN = 'dann';
	SONST = 'sonst';
	NNEW = 'nnew';
	SOLANGE = 'solange';
	TUE 	= 'tue';
	EGNALOS = 'egnalos';
	READ 	= 'read';
	PRINTLN = 'println';
	
	PROGRAMM;
	INIT;BODY;
}

// whitespaces für den Parser verstecken
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;

fragment DIGIT 	:	('0'..'9');
fragment LETTER 	:	('A'..'Z'|'a'..'z');
PLUS 	:	'+';
MINUS	:	'-';
MUL	:	'*';
DIV	:	'/';



/*
####### SCANNER RULES #######
*/
SPECIALCHARACTER 	: ('_'|'$'|'#'|'*'|' '|PLUS|MINUS|MUL|DIV);
ID	:	LETTER ( LETTER | '_' | DIGIT )*;


INT_CONST 	: 	DIGIT+;
FLOAT_CONST	: 	DIGIT+ '.' DIGIT+;
STRING_CONST	: 	'\'' ( LETTER | DIGIT | SPECIALCHARACTER )* '\'';
constants 	:	(INT_CONST |STRING_CONST|('true'|'false')|FLOAT_CONST);
RELOP		:	('='|'<>'|'<'|'<='|'>'|'>=');
ASSIGNING_OP	:	':=';
OPENING_BRACKET	:	('(');
CLOSEING_BRACKET	:	(')');
MULTILINE_COMMENT	: '/*' ( LETTER | DIGIT | SPECIALCHARACTER )* '*/';
/*
####### PARSER RULES ########
*/
start	:	PROGRAMM init BEGIN body END ->^(PROGRAMM init body);
init	:	declaration* -> ^(INIT declaration*);
body	:	statement+ -> ^(BODY statement+);

declaration	:	var_typ^ ID (SEPERATOR! ID)* STATEMENT_END!;
var_typ	:( INTEGER_TYP | FLOAT_TYP | BOOLEAN_TYP | STRING_TYP )	;

statement	 :(assignment| wenn_statement |solange_statement | read | println |  MULTILINE_COMMENT!) ;
assignment	: ID ASSIGNING_OP possible_assignments STATEMENT_END -> ^(ASSIGNING_OP ID possible_assignments);
possible_assignments:	(arithmetic_expression|comparison|STRING_CONST);

arithmetic_expression	:  term (( PLUS^ | MINUS^ ) term )*;
term	:	factor (( DIV^ | MUL^ ) factor )*	;
factor  :( (INT_CONST|FLOAT_CONST|ID) | ( OPENING_BRACKET! arithmetic_expression CLOSEING_BRACKET!) );

comparison 	: (ID|constants) RELOP^ (ID|constants);
wenn_statement 	:	WENN comparison dann_statement sonst_statement NNEW ->^(WENN comparison dann_statement sonst_statement);
dann_statement 	:	DANN^ statement*;
sonst_statement :(SONST^ statement*)?;

solange_statement	 : SOLANGE^ comparison tue_statement EGNALOS!;
tue_statement
	:	TUE^ statement*;
read	:	READ OPENING_BRACKET (ID) CLOSEING_BRACKET STATEMENT_END -> ^(READ ID) ;
println	:	PRINTLN^ OPENING_BRACKET! (ID|constants) CLOSEING_BRACKET! STATEMENT_END! ;


