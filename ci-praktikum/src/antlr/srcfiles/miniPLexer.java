package antlr.srcfiles;// $ANTLR 3.4 Z:\\AI4\\CI\\p1\\miniP.g 2013-04-30 12:41:40

import org.antlr.runtime.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class miniPLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int ASSIGNING_OP=4;
    public static final int BEGIN=5;
    public static final int BODY=6;
    public static final int BOOLEAN_TYP=7;
    public static final int CLOSEING_BRACKET=8;
    public static final int DANN=9;
    public static final int DIGIT=10;
    public static final int DIV=11;
    public static final int EGNALOS=12;
    public static final int END=13;
    public static final int FLOAT_CONST=14;
    public static final int FLOAT_TYP=15;
    public static final int ID=16;
    public static final int INIT=17;
    public static final int INTEGER_TYP=18;
    public static final int INT_CONST=19;
    public static final int LETTER=20;
    public static final int MINUS=21;
    public static final int MUL=22;
    public static final int MULTILINE_COMMENT=23;
    public static final int NNEW=24;
    public static final int OPENING_BRACKET=25;
    public static final int PLUS=26;
    public static final int PRINTLN=27;
    public static final int PROGRAMM=28;
    public static final int READ=29;
    public static final int RELOP=30;
    public static final int SEPERATOR=31;
    public static final int SOLANGE=32;
    public static final int SONST=33;
    public static final int SPECIALCHARACTER=34;
    public static final int STATEMENT_END=35;
    public static final int STRING_CONST=36;
    public static final int STRING_TYP=37;
    public static final int TUE=38;
    public static final int WENN=39;
    public static final int WHITESPACE=40;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public miniPLexer() {} 
    public miniPLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public miniPLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Z:\\AI4\\CI\\p1\\miniP.g"; }

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:2:7: ( 'begin' )
            // Z:\\AI4\\CI\\p1\\miniP.g:2:9: 'begin'
            {
            match("begin"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "BOOLEAN_TYP"
    public final void mBOOLEAN_TYP() throws RecognitionException {
        try {
            int _type = BOOLEAN_TYP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:3:13: ( 'boolean' )
            // Z:\\AI4\\CI\\p1\\miniP.g:3:15: 'boolean'
            {
            match("boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN_TYP"

    // $ANTLR start "DANN"
    public final void mDANN() throws RecognitionException {
        try {
            int _type = DANN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:4:6: ( 'dann' )
            // Z:\\AI4\\CI\\p1\\miniP.g:4:8: 'dann'
            {
            match("dann"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DANN"

    // $ANTLR start "EGNALOS"
    public final void mEGNALOS() throws RecognitionException {
        try {
            int _type = EGNALOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:5:9: ( 'egnalos' )
            // Z:\\AI4\\CI\\p1\\miniP.g:5:11: 'egnalos'
            {
            match("egnalos"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EGNALOS"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:6:5: ( 'end' )
            // Z:\\AI4\\CI\\p1\\miniP.g:6:7: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "FLOAT_TYP"
    public final void mFLOAT_TYP() throws RecognitionException {
        try {
            int _type = FLOAT_TYP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:7:11: ( 'float' )
            // Z:\\AI4\\CI\\p1\\miniP.g:7:13: 'float'
            {
            match("float"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT_TYP"

    // $ANTLR start "INTEGER_TYP"
    public final void mINTEGER_TYP() throws RecognitionException {
        try {
            int _type = INTEGER_TYP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:8:13: ( 'integer' )
            // Z:\\AI4\\CI\\p1\\miniP.g:8:15: 'integer'
            {
            match("integer"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER_TYP"

    // $ANTLR start "NNEW"
    public final void mNNEW() throws RecognitionException {
        try {
            int _type = NNEW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:9:6: ( 'nnew' )
            // Z:\\AI4\\CI\\p1\\miniP.g:9:8: 'nnew'
            {
            match("nnew"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NNEW"

    // $ANTLR start "PRINTLN"
    public final void mPRINTLN() throws RecognitionException {
        try {
            int _type = PRINTLN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:10:9: ( 'println' )
            // Z:\\AI4\\CI\\p1\\miniP.g:10:11: 'println'
            {
            match("println"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PRINTLN"

    // $ANTLR start "PROGRAMM"
    public final void mPROGRAMM() throws RecognitionException {
        try {
            int _type = PROGRAMM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:11:10: ( 'programm' )
            // Z:\\AI4\\CI\\p1\\miniP.g:11:12: 'programm'
            {
            match("programm"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROGRAMM"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:12:6: ( 'read' )
            // Z:\\AI4\\CI\\p1\\miniP.g:12:8: 'read'
            {
            match("read"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "SEPERATOR"
    public final void mSEPERATOR() throws RecognitionException {
        try {
            int _type = SEPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:13:11: ( ',' )
            // Z:\\AI4\\CI\\p1\\miniP.g:13:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEPERATOR"

    // $ANTLR start "SOLANGE"
    public final void mSOLANGE() throws RecognitionException {
        try {
            int _type = SOLANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:14:9: ( 'solange' )
            // Z:\\AI4\\CI\\p1\\miniP.g:14:11: 'solange'
            {
            match("solange"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SOLANGE"

    // $ANTLR start "SONST"
    public final void mSONST() throws RecognitionException {
        try {
            int _type = SONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:15:7: ( 'sonst' )
            // Z:\\AI4\\CI\\p1\\miniP.g:15:9: 'sonst'
            {
            match("sonst"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SONST"

    // $ANTLR start "STATEMENT_END"
    public final void mSTATEMENT_END() throws RecognitionException {
        try {
            int _type = STATEMENT_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:16:15: ( ';' )
            // Z:\\AI4\\CI\\p1\\miniP.g:16:17: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATEMENT_END"

    // $ANTLR start "STRING_TYP"
    public final void mSTRING_TYP() throws RecognitionException {
        try {
            int _type = STRING_TYP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:17:12: ( 'string' )
            // Z:\\AI4\\CI\\p1\\miniP.g:17:14: 'string'
            {
            match("string"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_TYP"

    // $ANTLR start "TUE"
    public final void mTUE() throws RecognitionException {
        try {
            int _type = TUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:18:5: ( 'tue' )
            // Z:\\AI4\\CI\\p1\\miniP.g:18:7: 'tue'
            {
            match("tue"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TUE"

    // $ANTLR start "WENN"
    public final void mWENN() throws RecognitionException {
        try {
            int _type = WENN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:19:6: ( 'wenn' )
            // Z:\\AI4\\CI\\p1\\miniP.g:19:8: 'wenn'
            {
            match("wenn"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WENN"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:20:7: ( 'false' )
            // Z:\\AI4\\CI\\p1\\miniP.g:20:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:21:7: ( 'true' )
            // Z:\\AI4\\CI\\p1\\miniP.g:21:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:35:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // Z:\\AI4\\CI\\p1\\miniP.g:35:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // Z:\\AI4\\CI\\p1\\miniP.g:35:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Z:\\AI4\\CI\\p1\\miniP.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:37:17: ( ( '0' .. '9' ) )
            // Z:\\AI4\\CI\\p1\\miniP.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:38:18: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // Z:\\AI4\\CI\\p1\\miniP.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:39:7: ( '+' )
            // Z:\\AI4\\CI\\p1\\miniP.g:39:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:40:7: ( '-' )
            // Z:\\AI4\\CI\\p1\\miniP.g:40:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MUL"
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:41:5: ( '*' )
            // Z:\\AI4\\CI\\p1\\miniP.g:41:7: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MUL"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:42:5: ( '/' )
            // Z:\\AI4\\CI\\p1\\miniP.g:42:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "SPECIALCHARACTER"
    public final void mSPECIALCHARACTER() throws RecognitionException {
        try {
            int _type = SPECIALCHARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:49:19: ( ( '_' | '$' | '#' | '*' | ' ' | PLUS | MINUS | MUL | DIV ) )
            // Z:\\AI4\\CI\\p1\\miniP.g:
            {
            if ( input.LA(1)==' '||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||input.LA(1)=='/'||input.LA(1)=='_' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPECIALCHARACTER"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:50:4: ( LETTER ( LETTER | '_' | DIGIT )* )
            // Z:\\AI4\\CI\\p1\\miniP.g:50:6: LETTER ( LETTER | '_' | DIGIT )*
            {
            mLETTER(); 


            // Z:\\AI4\\CI\\p1\\miniP.g:50:13: ( LETTER | '_' | DIGIT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Z:\\AI4\\CI\\p1\\miniP.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT_CONST"
    public final void mINT_CONST() throws RecognitionException {
        try {
            int _type = INT_CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:53:12: ( ( DIGIT )+ )
            // Z:\\AI4\\CI\\p1\\miniP.g:53:15: ( DIGIT )+
            {
            // Z:\\AI4\\CI\\p1\\miniP.g:53:15: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Z:\\AI4\\CI\\p1\\miniP.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT_CONST"

    // $ANTLR start "FLOAT_CONST"
    public final void mFLOAT_CONST() throws RecognitionException {
        try {
            int _type = FLOAT_CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:54:13: ( ( DIGIT )+ '.' ( DIGIT )+ )
            // Z:\\AI4\\CI\\p1\\miniP.g:54:16: ( DIGIT )+ '.' ( DIGIT )+
            {
            // Z:\\AI4\\CI\\p1\\miniP.g:54:16: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Z:\\AI4\\CI\\p1\\miniP.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match('.'); 

            // Z:\\AI4\\CI\\p1\\miniP.g:54:27: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Z:\\AI4\\CI\\p1\\miniP.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT_CONST"

    // $ANTLR start "STRING_CONST"
    public final void mSTRING_CONST() throws RecognitionException {
        try {
            int _type = STRING_CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:55:14: ( '\\'' ( LETTER | DIGIT | SPECIALCHARACTER )* '\\'' )
            // Z:\\AI4\\CI\\p1\\miniP.g:55:17: '\\'' ( LETTER | DIGIT | SPECIALCHARACTER )* '\\''
            {
            match('\''); 

            // Z:\\AI4\\CI\\p1\\miniP.g:55:22: ( LETTER | DIGIT | SPECIALCHARACTER )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==' '||(LA6_0 >= '#' && LA6_0 <= '$')||(LA6_0 >= '*' && LA6_0 <= '+')||LA6_0=='-'||(LA6_0 >= '/' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Z:\\AI4\\CI\\p1\\miniP.g:
            	    {
            	    if ( input.LA(1)==' '||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||(input.LA(1) >= '/' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_CONST"

    // $ANTLR start "RELOP"
    public final void mRELOP() throws RecognitionException {
        try {
            int _type = RELOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:57:8: ( ( '=' | '<>' | '<' | '<=' | '>' | '>=' ) )
            // Z:\\AI4\\CI\\p1\\miniP.g:57:10: ( '=' | '<>' | '<' | '<=' | '>' | '>=' )
            {
            // Z:\\AI4\\CI\\p1\\miniP.g:57:10: ( '=' | '<>' | '<' | '<=' | '>' | '>=' )
            int alt7=6;
            switch ( input.LA(1) ) {
            case '=':
                {
                alt7=1;
                }
                break;
            case '<':
                {
                switch ( input.LA(2) ) {
                case '>':
                    {
                    alt7=2;
                    }
                    break;
                case '=':
                    {
                    alt7=4;
                    }
                    break;
                default:
                    alt7=3;
                }

                }
                break;
            case '>':
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3=='=') ) {
                    alt7=6;
                }
                else {
                    alt7=5;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // Z:\\AI4\\CI\\p1\\miniP.g:57:11: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // Z:\\AI4\\CI\\p1\\miniP.g:57:15: '<>'
                    {
                    match("<>"); 



                    }
                    break;
                case 3 :
                    // Z:\\AI4\\CI\\p1\\miniP.g:57:20: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 4 :
                    // Z:\\AI4\\CI\\p1\\miniP.g:57:24: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 5 :
                    // Z:\\AI4\\CI\\p1\\miniP.g:57:29: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 6 :
                    // Z:\\AI4\\CI\\p1\\miniP.g:57:33: '>='
                    {
                    match(">="); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP"

    // $ANTLR start "ASSIGNING_OP"
    public final void mASSIGNING_OP() throws RecognitionException {
        try {
            int _type = ASSIGNING_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:58:14: ( ':=' )
            // Z:\\AI4\\CI\\p1\\miniP.g:58:16: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGNING_OP"

    // $ANTLR start "OPENING_BRACKET"
    public final void mOPENING_BRACKET() throws RecognitionException {
        try {
            int _type = OPENING_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:59:17: ( ( '(' ) )
            // Z:\\AI4\\CI\\p1\\miniP.g:59:19: ( '(' )
            {
            // Z:\\AI4\\CI\\p1\\miniP.g:59:19: ( '(' )
            // Z:\\AI4\\CI\\p1\\miniP.g:59:20: '('
            {
            match('('); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPENING_BRACKET"

    // $ANTLR start "CLOSEING_BRACKET"
    public final void mCLOSEING_BRACKET() throws RecognitionException {
        try {
            int _type = CLOSEING_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:60:18: ( ( ')' ) )
            // Z:\\AI4\\CI\\p1\\miniP.g:60:20: ( ')' )
            {
            // Z:\\AI4\\CI\\p1\\miniP.g:60:20: ( ')' )
            // Z:\\AI4\\CI\\p1\\miniP.g:60:21: ')'
            {
            match(')'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLOSEING_BRACKET"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\AI4\\CI\\p1\\miniP.g:61:19: ( '/*' ( LETTER | DIGIT | SPECIALCHARACTER )* '*/' )
            // Z:\\AI4\\CI\\p1\\miniP.g:61:21: '/*' ( LETTER | DIGIT | SPECIALCHARACTER )* '*/'
            {
            match("/*"); 



            // Z:\\AI4\\CI\\p1\\miniP.g:61:26: ( LETTER | DIGIT | SPECIALCHARACTER )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        int LA8_3 = input.LA(3);

                        if ( (LA8_3==' '||(LA8_3 >= '#' && LA8_3 <= '$')||(LA8_3 >= '*' && LA8_3 <= '+')||LA8_3=='-'||(LA8_3 >= '/' && LA8_3 <= '9')||(LA8_3 >= 'A' && LA8_3 <= 'Z')||LA8_3=='_'||(LA8_3 >= 'a' && LA8_3 <= 'z')) ) {
                            alt8=1;
                        }


                    }
                    else if ( (LA8_1==' '||(LA8_1 >= '#' && LA8_1 <= '$')||(LA8_1 >= '*' && LA8_1 <= '+')||LA8_1=='-'||(LA8_1 >= '0' && LA8_1 <= '9')||(LA8_1 >= 'A' && LA8_1 <= 'Z')||LA8_1=='_'||(LA8_1 >= 'a' && LA8_1 <= 'z')) ) {
                        alt8=1;
                    }


                }
                else if ( (LA8_0==' '||(LA8_0 >= '#' && LA8_0 <= '$')||LA8_0=='+'||LA8_0=='-'||(LA8_0 >= '/' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Z:\\AI4\\CI\\p1\\miniP.g:
            	    {
            	    if ( input.LA(1)==' '||(input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||(input.LA(1) >= '/' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match("*/"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // Z:\\AI4\\CI\\p1\\miniP.g:1:8: ( BEGIN | BOOLEAN_TYP | DANN | EGNALOS | END | FLOAT_TYP | INTEGER_TYP | NNEW | PRINTLN | PROGRAMM | READ | SEPERATOR | SOLANGE | SONST | STATEMENT_END | STRING_TYP | TUE | WENN | T__41 | T__42 | WHITESPACE | PLUS | MINUS | MUL | DIV | SPECIALCHARACTER | ID | INT_CONST | FLOAT_CONST | STRING_CONST | RELOP | ASSIGNING_OP | OPENING_BRACKET | CLOSEING_BRACKET | MULTILINE_COMMENT )
        int alt9=35;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:10: BEGIN
                {
                mBEGIN(); 


                }
                break;
            case 2 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:16: BOOLEAN_TYP
                {
                mBOOLEAN_TYP(); 


                }
                break;
            case 3 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:28: DANN
                {
                mDANN(); 


                }
                break;
            case 4 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:33: EGNALOS
                {
                mEGNALOS(); 


                }
                break;
            case 5 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:41: END
                {
                mEND(); 


                }
                break;
            case 6 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:45: FLOAT_TYP
                {
                mFLOAT_TYP(); 


                }
                break;
            case 7 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:55: INTEGER_TYP
                {
                mINTEGER_TYP(); 


                }
                break;
            case 8 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:67: NNEW
                {
                mNNEW(); 


                }
                break;
            case 9 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:72: PRINTLN
                {
                mPRINTLN(); 


                }
                break;
            case 10 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:80: PROGRAMM
                {
                mPROGRAMM(); 


                }
                break;
            case 11 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:89: READ
                {
                mREAD(); 


                }
                break;
            case 12 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:94: SEPERATOR
                {
                mSEPERATOR(); 


                }
                break;
            case 13 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:104: SOLANGE
                {
                mSOLANGE(); 


                }
                break;
            case 14 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:112: SONST
                {
                mSONST(); 


                }
                break;
            case 15 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:118: STATEMENT_END
                {
                mSTATEMENT_END(); 


                }
                break;
            case 16 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:132: STRING_TYP
                {
                mSTRING_TYP(); 


                }
                break;
            case 17 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:143: TUE
                {
                mTUE(); 


                }
                break;
            case 18 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:147: WENN
                {
                mWENN(); 


                }
                break;
            case 19 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:152: T__41
                {
                mT__41(); 


                }
                break;
            case 20 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:158: T__42
                {
                mT__42(); 


                }
                break;
            case 21 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:164: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 22 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:175: PLUS
                {
                mPLUS(); 


                }
                break;
            case 23 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:180: MINUS
                {
                mMINUS(); 


                }
                break;
            case 24 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:186: MUL
                {
                mMUL(); 


                }
                break;
            case 25 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:190: DIV
                {
                mDIV(); 


                }
                break;
            case 26 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:194: SPECIALCHARACTER
                {
                mSPECIALCHARACTER(); 


                }
                break;
            case 27 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:211: ID
                {
                mID(); 


                }
                break;
            case 28 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:214: INT_CONST
                {
                mINT_CONST(); 


                }
                break;
            case 29 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:224: FLOAT_CONST
                {
                mFLOAT_CONST(); 


                }
                break;
            case 30 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:236: STRING_CONST
                {
                mSTRING_CONST(); 


                }
                break;
            case 31 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:249: RELOP
                {
                mRELOP(); 


                }
                break;
            case 32 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:255: ASSIGNING_OP
                {
                mASSIGNING_OP(); 


                }
                break;
            case 33 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:268: OPENING_BRACKET
                {
                mOPENING_BRACKET(); 


                }
                break;
            case 34 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:284: CLOSEING_BRACKET
                {
                mCLOSEING_BRACKET(); 


                }
                break;
            case 35 :
                // Z:\\AI4\\CI\\p1\\miniP.g:1:301: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 


                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\10\25\1\uffff\1\25\1\uffff\2\25\4\uffff\1\60\3\uffff\1"+
        "\61\5\uffff\20\25\7\uffff\4\25\1\111\12\25\1\124\4\25\1\131\1\25"+
        "\1\uffff\3\25\1\136\2\25\1\141\3\25\1\uffff\1\145\1\146\1\147\1"+
        "\25\1\uffff\1\25\1\152\1\153\1\25\1\uffff\2\25\1\uffff\1\25\1\160"+
        "\1\25\3\uffff\2\25\2\uffff\4\25\1\uffff\1\170\1\171\1\172\1\173"+
        "\1\174\1\25\1\176\5\uffff\1\177\2\uffff";
    static final String DFA9_eofS =
        "\u0080\uffff";
    static final String DFA9_minS =
        "\1\11\1\145\1\141\1\147\1\141\2\156\1\162\1\145\1\uffff\1\157\1"+
        "\uffff\1\162\1\145\4\uffff\1\52\3\uffff\1\56\5\uffff\1\147\1\157"+
        "\2\156\1\144\1\157\1\154\1\164\1\145\1\151\1\141\1\154\1\162\1\145"+
        "\1\165\1\156\7\uffff\1\151\1\154\1\156\1\141\1\60\1\141\1\163\1"+
        "\145\1\167\1\156\1\147\1\144\1\141\1\163\1\151\1\60\1\145\2\156"+
        "\1\145\1\60\1\154\1\uffff\1\164\1\145\1\147\1\60\1\164\1\162\1\60"+
        "\1\156\1\164\1\156\1\uffff\3\60\1\141\1\uffff\1\157\2\60\1\145\1"+
        "\uffff\1\154\1\141\1\uffff\1\147\1\60\1\147\3\uffff\1\156\1\163"+
        "\2\uffff\1\162\1\156\1\155\1\145\1\uffff\5\60\1\155\1\60\5\uffff"+
        "\1\60\2\uffff";
    static final String DFA9_maxS =
        "\1\172\1\157\1\141\1\156\1\154\2\156\1\162\1\145\1\uffff\1\164\1"+
        "\uffff\1\165\1\145\4\uffff\1\52\3\uffff\1\71\5\uffff\1\147\1\157"+
        "\2\156\1\144\1\157\1\154\1\164\1\145\1\157\1\141\1\156\1\162\1\145"+
        "\1\165\1\156\7\uffff\1\151\1\154\1\156\1\141\1\172\1\141\1\163\1"+
        "\145\1\167\1\156\1\147\1\144\1\141\1\163\1\151\1\172\1\145\2\156"+
        "\1\145\1\172\1\154\1\uffff\1\164\1\145\1\147\1\172\1\164\1\162\1"+
        "\172\1\156\1\164\1\156\1\uffff\3\172\1\141\1\uffff\1\157\2\172\1"+
        "\145\1\uffff\1\154\1\141\1\uffff\1\147\1\172\1\147\3\uffff\1\156"+
        "\1\163\2\uffff\1\162\1\156\1\155\1\145\1\uffff\5\172\1\155\1\172"+
        "\5\uffff\1\172\2\uffff";
    static final String DFA9_acceptS =
        "\11\uffff\1\14\1\uffff\1\17\2\uffff\1\25\1\26\1\27\1\30\1\uffff"+
        "\1\25\1\32\1\33\1\uffff\1\36\1\37\1\40\1\41\1\42\20\uffff\1\26\1"+
        "\27\1\30\1\43\1\31\1\34\1\35\26\uffff\1\5\12\uffff\1\21\4\uffff"+
        "\1\3\4\uffff\1\10\2\uffff\1\13\3\uffff\1\24\1\22\1\1\2\uffff\1\6"+
        "\1\23\4\uffff\1\16\7\uffff\1\20\1\2\1\4\1\7\1\11\1\uffff\1\15\1"+
        "\12";
    static final String DFA9_specialS =
        "\u0080\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\23\1\uffff\2\23\22\uffff\1\16\2\uffff\2\24\2\uffff\1\27\1"+
            "\32\1\33\1\21\1\17\1\11\1\20\1\uffff\1\22\12\26\1\31\1\13\3"+
            "\30\2\uffff\32\25\4\uffff\1\24\1\uffff\1\25\1\1\1\25\1\2\1\3"+
            "\1\4\2\25\1\5\4\25\1\6\1\25\1\7\1\25\1\10\1\12\1\14\2\25\1\15"+
            "\3\25",
            "\1\34\11\uffff\1\35",
            "\1\36",
            "\1\37\6\uffff\1\40",
            "\1\42\12\uffff\1\41",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "",
            "\1\47\4\uffff\1\50",
            "",
            "\1\52\2\uffff\1\51",
            "\1\53",
            "",
            "",
            "",
            "",
            "\1\57",
            "",
            "",
            "",
            "\1\62\1\uffff\12\26",
            "",
            "",
            "",
            "",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74\5\uffff\1\75",
            "\1\76",
            "\1\77\1\uffff\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\132",
            "",
            "\1\133",
            "\1\134",
            "\1\135",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\137",
            "\1\140",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\150",
            "",
            "\1\151",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\154",
            "",
            "\1\155",
            "\1\156",
            "",
            "\1\157",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\161",
            "",
            "",
            "",
            "\1\162",
            "\1\163",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\175",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( BEGIN | BOOLEAN_TYP | DANN | EGNALOS | END | FLOAT_TYP | INTEGER_TYP | NNEW | PRINTLN | PROGRAMM | READ | SEPERATOR | SOLANGE | SONST | STATEMENT_END | STRING_TYP | TUE | WENN | T__41 | T__42 | WHITESPACE | PLUS | MINUS | MUL | DIV | SPECIALCHARACTER | ID | INT_CONST | FLOAT_CONST | STRING_CONST | RELOP | ASSIGNING_OP | OPENING_BRACKET | CLOSEING_BRACKET | MULTILINE_COMMENT );";
        }
    }
 

}