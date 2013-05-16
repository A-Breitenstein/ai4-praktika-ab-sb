package antlr.srcfiles;

import org.antlr.runtime.*;

// $ANTLR 3.5 E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g 2013-05-16 01:19:32

@SuppressWarnings("all")
public class artihmetic_puzzleLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int ERGEBNIS=4;
	public static final int GLEICH=5;
	public static final int HORIZONTAL=6;
	public static final int HVOPERATIONS=7;
	public static final int LETTER=8;
	public static final int OPERAND1=9;
	public static final int OPERAND2=10;
	public static final int OPERATOR=11;
	public static final int RAETSEL=12;
	public static final int START=13;
	public static final int VERTIKAL=14;
	public static final int ZAHL=15;

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
	@Override public String getGrammarFileName() { return "E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g"; }

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:2:7: ( ',' )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:2:9: ','
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:3:7: ( '[' )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:3:9: '['
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:4:7: ( '].' )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:4:9: '].'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:5:7: ( ']H[' )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:5:9: ']H['
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:6:7: ( ']V[' )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:6:9: ']V['
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
	// $ANTLR end "T__20"

	// $ANTLR start "OPERATOR"
	public final void mOPERATOR() throws RecognitionException {
		try {
			int _type = OPERATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:29:9: ( '+' | '-' )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:
			{
			if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
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
	// $ANTLR end "OPERATOR"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			int _type = LETTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:30:8: ( 'A' .. 'Z' )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:
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

	@Override
	public void mTokens() throws RecognitionException {
		// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | OPERATOR | LETTER )
		int alt1=7;
		switch ( input.LA(1) ) {
		case ',':
			{
			alt1=1;
			}
			break;
		case '[':
			{
			alt1=2;
			}
			break;
		case ']':
			{
			switch ( input.LA(2) ) {
			case '.':
				{
				alt1=3;
				}
				break;
			case 'H':
				{
				alt1=4;
				}
				break;
			case 'V':
				{
				alt1=5;
				}
				break;
			default:
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 1, 3, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}
			}
			break;
		case '+':
		case '-':
			{
			alt1=6;
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
			alt1=7;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 1, 0, input);
			throw nvae;
		}
		switch (alt1) {
			case 1 :
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:10: T__16
				{
				mT__16(); 

				}
				break;
			case 2 :
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:16: T__17
				{
				mT__17(); 

				}
				break;
			case 3 :
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:22: T__18
				{
				mT__18(); 

				}
				break;
			case 4 :
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:28: T__19
				{
				mT__19(); 

				}
				break;
			case 5 :
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:34: T__20
				{
				mT__20(); 

				}
				break;
			case 6 :
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:40: OPERATOR
				{
				mOPERATOR(); 

				}
				break;
			case 7 :
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:1:49: LETTER
				{
				mLETTER(); 

				}
				break;

		}
	}



}
