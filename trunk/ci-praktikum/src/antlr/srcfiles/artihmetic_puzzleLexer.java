package antlr.srcfiles;// $ANTLR 3.4 Z:\\BAI-4\\CI\\artihmetic_puzzle.g 2013-06-04 13:35:38

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class artihmetic_puzzleLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int ERGEBNIS=4;
    public static final int GLEICH=5;
    public static final int HORIZONTAL=6;
    public static final int HVOPERATIONS=7;
    public static final int LETTER=8;
    public static final int MINUS=9;
    public static final int OPERAND1=10;
    public static final int OPERAND2=11;
    public static final int PLUS=12;
    public static final int RAETSEL=13;
    public static final int START=14;
    public static final int VERTIKAL=15;
    public static final int ZAHL=16;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public artihmetic_puzzleLexer() {} 
    public artihmetic_puzzleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public artihmetic_puzzleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Z:\\BAI-4\\CI\\artihmetic_puzzle.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:2:7: ( '+' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:2:9: '+'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:3:7: ( ',' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:3:9: ','
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:4:7: ( '-' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:4:9: '-'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:5:7: ( '[' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:5:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:6:7: ( '].' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:6:9: '].'
            {
            match("]."); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:7:7: ( ']H[' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:7:9: ']H['
            {
            match("]H["); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:8:7: ( ']V[' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:8:9: ']V['
            {
            match("]V["); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            int _type = LETTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:33:8: ( 'A' .. 'Z' )
            // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
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
    // $ANTLR end "LETTER"

    public void mTokens() throws RecognitionException {
        // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | LETTER )
        int alt1=8;
        switch ( input.LA(1) ) {
        case '+':
            {
            alt1=1;
            }
            break;
        case ',':
            {
            alt1=2;
            }
            break;
        case '-':
            {
            alt1=3;
            }
            break;
        case '[':
            {
            alt1=4;
            }
            break;
        case ']':
            {
            switch ( input.LA(2) ) {
            case '.':
                {
                alt1=5;
                }
                break;
            case 'H':
                {
                alt1=6;
                }
                break;
            case 'V':
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 5, input);

                throw nvae;

            }

            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt1=8;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 1, 0, input);

            throw nvae;

        }

        switch (alt1) {
            case 1 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:10: T__17
                {
                mT__17(); 


                }
                break;
            case 2 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:16: T__18
                {
                mT__18(); 


                }
                break;
            case 3 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:22: T__19
                {
                mT__19(); 


                }
                break;
            case 4 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:28: T__20
                {
                mT__20(); 


                }
                break;
            case 5 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:34: T__21
                {
                mT__21(); 


                }
                break;
            case 6 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:40: T__22
                {
                mT__22(); 


                }
                break;
            case 7 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:46: T__23
                {
                mT__23(); 


                }
                break;
            case 8 :
                // Z:\\BAI-4\\CI\\artihmetic_puzzle.g:1:52: LETTER
                {
                mLETTER(); 


                }
                break;

        }

    }


 

}