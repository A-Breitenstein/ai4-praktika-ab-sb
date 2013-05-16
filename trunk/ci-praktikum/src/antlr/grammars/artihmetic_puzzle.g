grammar artihmetic_puzzle;
options{
output=AST;
ASTLabelType=CommonTree;
}
/*
########## TOKENS #########
*/
// KEYWORDS
tokens{
HVOPERATIONS;
START;
RAETSEL;
HORIZONTAL;
VERTIKAL;
OPERAND1;
OPERAND2;
ERGEBNIS;
GLEICH;
ZAHL;
}

start	:	'['r0=zahl','r1=zahl','r2=zahl','r3=zahl','r4=zahl','r5=zahl','r6=zahl','r7=zahl','r8=zahl']V['v1=op','v2=op','v3=op']H['h1=op','h2=op','h3=op'].' 
		-> ^(RAETSEL ^($v1 $r0 $r1  $r2)   ^( $v1 $r3 $r4  $r5)   ^($v3 $r6 $r7  $r8)   ^( $h1 $r0 $r3  $r6)    ^($h2 $r1 $r4  $r7)    ^($h3 $r2 $r5  $r8));

zahl	:	LETTER* -> ^(ZAHL LETTER*);
op	:	OPERATOR;

OPERATOR:	'+'|'-';
LETTER	:	'A'..'Z';

/*
start2	:	hor ver -> ^(RAETSEL hor ver);
hor	:	hauptausdruck -> ^(HORIZONTAL hauptausdruck);
ver 	:	hauptausdruck -> ^(VERTIKAL hauptausdruck);
hauptausdruck:	ausdruck';'!ausdruck';'!ausdruck';'!;
ausdruck
	:	   operation '=' loesung -> ^('=' operation loesung);
loesung	:	LETTER* -> ^(ERGEBNIS LETTER*);
operation
	: operand1 OPERATOR operand2 -> ^(OPERATOR operand1 operand2);
operand1: LETTER* -> ^(OPERAND1 LETTER*);
operand2: LETTER* -> ^(OPERAND2 LETTER*);
*/


