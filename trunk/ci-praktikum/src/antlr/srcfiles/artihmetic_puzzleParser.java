package antlr.srcfiles;// $ANTLR 3.5 E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g 2013-05-16 01:19:32

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class artihmetic_puzzleParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ERGEBNIS", "GLEICH", "HORIZONTAL", 
		"HVOPERATIONS", "LETTER", "OPERAND1", "OPERAND2", "OPERATOR", "RAETSEL", 
		"START", "VERTIKAL", "ZAHL", "','", "'['", "'].'", "']H['", "']V['"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public artihmetic_puzzleParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public artihmetic_puzzleParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return artihmetic_puzzleParser.tokenNames; }
	@Override public String getGrammarFileName() { return "E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g"; }


	public static class start_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "start"
	// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:23:1: start : '[' r0= zahl ',' r1= zahl ',' r2= zahl ',' r3= zahl ',' r4= zahl ',' r5= zahl ',' r6= zahl ',' r7= zahl ',' r8= zahl ']V[' v1= op ',' v2= op ',' v3= op ']H[' h1= op ',' h2= op ',' h3= op '].' -> ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) ) ;
	public final artihmetic_puzzleParser.start_return start() throws RecognitionException {
		artihmetic_puzzleParser.start_return retval = new artihmetic_puzzleParser.start_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal1=null;
		Token char_literal2=null;
		Token char_literal3=null;
		Token char_literal4=null;
		Token char_literal5=null;
		Token char_literal6=null;
		Token char_literal7=null;
		Token char_literal8=null;
		Token char_literal9=null;
		Token string_literal10=null;
		Token char_literal11=null;
		Token char_literal12=null;
		Token string_literal13=null;
		Token char_literal14=null;
		Token char_literal15=null;
		Token string_literal16=null;
		ParserRuleReturnScope r0 =null;
		ParserRuleReturnScope r1 =null;
		ParserRuleReturnScope r2 =null;
		ParserRuleReturnScope r3 =null;
		ParserRuleReturnScope r4 =null;
		ParserRuleReturnScope r5 =null;
		ParserRuleReturnScope r6 =null;
		ParserRuleReturnScope r7 =null;
		ParserRuleReturnScope r8 =null;
		ParserRuleReturnScope v1 =null;
		ParserRuleReturnScope v2 =null;
		ParserRuleReturnScope v3 =null;
		ParserRuleReturnScope h1 =null;
		ParserRuleReturnScope h2 =null;
		ParserRuleReturnScope h3 =null;

		CommonTree char_literal1_tree=null;
		CommonTree char_literal2_tree=null;
		CommonTree char_literal3_tree=null;
		CommonTree char_literal4_tree=null;
		CommonTree char_literal5_tree=null;
		CommonTree char_literal6_tree=null;
		CommonTree char_literal7_tree=null;
		CommonTree char_literal8_tree=null;
		CommonTree char_literal9_tree=null;
		CommonTree string_literal10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree char_literal12_tree=null;
		CommonTree string_literal13_tree=null;
		CommonTree char_literal14_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree string_literal16_tree=null;
		RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
		RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
		RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
		RewriteRuleTokenStream stream_18=new RewriteRuleTokenStream(adaptor,"token 18");
		RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
		RewriteRuleSubtreeStream stream_zahl=new RewriteRuleSubtreeStream(adaptor,"rule zahl");
		RewriteRuleSubtreeStream stream_op=new RewriteRuleSubtreeStream(adaptor,"rule op");

		try {
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:23:7: ( '[' r0= zahl ',' r1= zahl ',' r2= zahl ',' r3= zahl ',' r4= zahl ',' r5= zahl ',' r6= zahl ',' r7= zahl ',' r8= zahl ']V[' v1= op ',' v2= op ',' v3= op ']H[' h1= op ',' h2= op ',' h3= op '].' -> ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) ) )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:23:9: '[' r0= zahl ',' r1= zahl ',' r2= zahl ',' r3= zahl ',' r4= zahl ',' r5= zahl ',' r6= zahl ',' r7= zahl ',' r8= zahl ']V[' v1= op ',' v2= op ',' v3= op ']H[' h1= op ',' h2= op ',' h3= op '].'
			{
			char_literal1=(Token)match(input,17,FOLLOW_17_in_start61);  
			stream_17.add(char_literal1);

			pushFollow(FOLLOW_zahl_in_start64);
			r0=zahl();
			state._fsp--;

			stream_zahl.add(r0.getTree());
			char_literal2=(Token)match(input,16,FOLLOW_16_in_start65);  
			stream_16.add(char_literal2);

			pushFollow(FOLLOW_zahl_in_start68);
			r1=zahl();
			state._fsp--;

			stream_zahl.add(r1.getTree());
			char_literal3=(Token)match(input,16,FOLLOW_16_in_start69);  
			stream_16.add(char_literal3);

			pushFollow(FOLLOW_zahl_in_start72);
			r2=zahl();
			state._fsp--;

			stream_zahl.add(r2.getTree());
			char_literal4=(Token)match(input,16,FOLLOW_16_in_start73);  
			stream_16.add(char_literal4);

			pushFollow(FOLLOW_zahl_in_start76);
			r3=zahl();
			state._fsp--;

			stream_zahl.add(r3.getTree());
			char_literal5=(Token)match(input,16,FOLLOW_16_in_start77);  
			stream_16.add(char_literal5);

			pushFollow(FOLLOW_zahl_in_start80);
			r4=zahl();
			state._fsp--;

			stream_zahl.add(r4.getTree());
			char_literal6=(Token)match(input,16,FOLLOW_16_in_start81);  
			stream_16.add(char_literal6);

			pushFollow(FOLLOW_zahl_in_start84);
			r5=zahl();
			state._fsp--;

			stream_zahl.add(r5.getTree());
			char_literal7=(Token)match(input,16,FOLLOW_16_in_start85);  
			stream_16.add(char_literal7);

			pushFollow(FOLLOW_zahl_in_start88);
			r6=zahl();
			state._fsp--;

			stream_zahl.add(r6.getTree());
			char_literal8=(Token)match(input,16,FOLLOW_16_in_start89);  
			stream_16.add(char_literal8);

			pushFollow(FOLLOW_zahl_in_start92);
			r7=zahl();
			state._fsp--;

			stream_zahl.add(r7.getTree());
			char_literal9=(Token)match(input,16,FOLLOW_16_in_start93);  
			stream_16.add(char_literal9);

			pushFollow(FOLLOW_zahl_in_start96);
			r8=zahl();
			state._fsp--;

			stream_zahl.add(r8.getTree());
			string_literal10=(Token)match(input,20,FOLLOW_20_in_start97);  
			stream_20.add(string_literal10);

			pushFollow(FOLLOW_op_in_start100);
			v1=op();
			state._fsp--;

			stream_op.add(v1.getTree());
			char_literal11=(Token)match(input,16,FOLLOW_16_in_start101);  
			stream_16.add(char_literal11);

			pushFollow(FOLLOW_op_in_start104);
			v2=op();
			state._fsp--;

			stream_op.add(v2.getTree());
			char_literal12=(Token)match(input,16,FOLLOW_16_in_start105);  
			stream_16.add(char_literal12);

			pushFollow(FOLLOW_op_in_start108);
			v3=op();
			state._fsp--;

			stream_op.add(v3.getTree());
			string_literal13=(Token)match(input,19,FOLLOW_19_in_start109);  
			stream_19.add(string_literal13);

			pushFollow(FOLLOW_op_in_start112);
			h1=op();
			state._fsp--;

			stream_op.add(h1.getTree());
			char_literal14=(Token)match(input,16,FOLLOW_16_in_start113);  
			stream_16.add(char_literal14);

			pushFollow(FOLLOW_op_in_start116);
			h2=op();
			state._fsp--;

			stream_op.add(h2.getTree());
			char_literal15=(Token)match(input,16,FOLLOW_16_in_start117);  
			stream_16.add(char_literal15);

			pushFollow(FOLLOW_op_in_start120);
			h3=op();
			state._fsp--;

			stream_op.add(h3.getTree());
			string_literal16=(Token)match(input,18,FOLLOW_18_in_start121);  
			stream_18.add(string_literal16);

			// AST REWRITE
			// elements: r8, r8, r1, r4, v1, r5, r3, r2, v1, r6, r0, r7, r2, r5, h1, r6, h2, r1, h3, r0, v3, r3, r4, r7
			// token labels: 
			// rule labels: v1, retval, v3, r6, r7, r8, r0, r1, r2, h1, r3, r4, h3, r5, h2
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_v1=new RewriteRuleSubtreeStream(adaptor,"rule v1",v1!=null?v1.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_v3=new RewriteRuleSubtreeStream(adaptor,"rule v3",v3!=null?v3.getTree():null);
			RewriteRuleSubtreeStream stream_r6=new RewriteRuleSubtreeStream(adaptor,"rule r6",r6!=null?r6.getTree():null);
			RewriteRuleSubtreeStream stream_r7=new RewriteRuleSubtreeStream(adaptor,"rule r7",r7!=null?r7.getTree():null);
			RewriteRuleSubtreeStream stream_r8=new RewriteRuleSubtreeStream(adaptor,"rule r8",r8!=null?r8.getTree():null);
			RewriteRuleSubtreeStream stream_r0=new RewriteRuleSubtreeStream(adaptor,"rule r0",r0!=null?r0.getTree():null);
			RewriteRuleSubtreeStream stream_r1=new RewriteRuleSubtreeStream(adaptor,"rule r1",r1!=null?r1.getTree():null);
			RewriteRuleSubtreeStream stream_r2=new RewriteRuleSubtreeStream(adaptor,"rule r2",r2!=null?r2.getTree():null);
			RewriteRuleSubtreeStream stream_h1=new RewriteRuleSubtreeStream(adaptor,"rule h1",h1!=null?h1.getTree():null);
			RewriteRuleSubtreeStream stream_r3=new RewriteRuleSubtreeStream(adaptor,"rule r3",r3!=null?r3.getTree():null);
			RewriteRuleSubtreeStream stream_r4=new RewriteRuleSubtreeStream(adaptor,"rule r4",r4!=null?r4.getTree():null);
			RewriteRuleSubtreeStream stream_h3=new RewriteRuleSubtreeStream(adaptor,"rule h3",h3!=null?h3.getTree():null);
			RewriteRuleSubtreeStream stream_r5=new RewriteRuleSubtreeStream(adaptor,"rule r5",r5!=null?r5.getTree():null);
			RewriteRuleSubtreeStream stream_h2=new RewriteRuleSubtreeStream(adaptor,"rule h2",h2!=null?h2.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 24:3: -> ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) )
			{
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:24:6: ^( RAETSEL ^( $v1 $r0 $r1 $r2) ^( $v1 $r3 $r4 $r5) ^( $v3 $r6 $r7 $r8) ^( $h1 $r0 $r3 $r6) ^( $h2 $r1 $r4 $r7) ^( $h3 $r2 $r5 $r8) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RAETSEL, "RAETSEL"), root_1);
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:24:16: ^( $v1 $r0 $r1 $r2)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_v1.nextNode(), root_2);
				adaptor.addChild(root_2, stream_r0.nextTree());
				adaptor.addChild(root_2, stream_r1.nextTree());
				adaptor.addChild(root_2, stream_r2.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:24:38: ^( $v1 $r3 $r4 $r5)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_v1.nextNode(), root_2);
				adaptor.addChild(root_2, stream_r3.nextTree());
				adaptor.addChild(root_2, stream_r4.nextTree());
				adaptor.addChild(root_2, stream_r5.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:24:61: ^( $v3 $r6 $r7 $r8)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_v3.nextNode(), root_2);
				adaptor.addChild(root_2, stream_r6.nextTree());
				adaptor.addChild(root_2, stream_r7.nextTree());
				adaptor.addChild(root_2, stream_r8.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:24:83: ^( $h1 $r0 $r3 $r6)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_h1.nextNode(), root_2);
				adaptor.addChild(root_2, stream_r0.nextTree());
				adaptor.addChild(root_2, stream_r3.nextTree());
				adaptor.addChild(root_2, stream_r6.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:24:107: ^( $h2 $r1 $r4 $r7)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_h2.nextNode(), root_2);
				adaptor.addChild(root_2, stream_r1.nextTree());
				adaptor.addChild(root_2, stream_r4.nextTree());
				adaptor.addChild(root_2, stream_r7.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:24:130: ^( $h3 $r2 $r5 $r8)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_h3.nextNode(), root_2);
				adaptor.addChild(root_2, stream_r2.nextTree());
				adaptor.addChild(root_2, stream_r5.nextTree());
				adaptor.addChild(root_2, stream_r8.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "start"


	public static class zahl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "zahl"
	// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:26:1: zahl : ( LETTER )* -> ^( ZAHL ( LETTER )* ) ;
	public final artihmetic_puzzleParser.zahl_return zahl() throws RecognitionException  {
		artihmetic_puzzleParser.zahl_return retval = new artihmetic_puzzleParser.zahl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LETTER17=null;

		CommonTree LETTER17_tree=null;
		RewriteRuleTokenStream stream_LETTER=new RewriteRuleTokenStream(adaptor,"token LETTER");

		try {
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:26:6: ( ( LETTER )* -> ^( ZAHL ( LETTER )* ) )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:26:8: ( LETTER )*
			{
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:26:8: ( LETTER )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==LETTER) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:26:8: LETTER
					{
					LETTER17=(Token)match(input,LETTER,FOLLOW_LETTER_in_zahl242);  
					stream_LETTER.add(LETTER17);

					}
					break;

				default :
					break loop1;
				}
			}

			// AST REWRITE
			// elements: LETTER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 26:16: -> ^( ZAHL ( LETTER )* )
			{
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:26:19: ^( ZAHL ( LETTER )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ZAHL, "ZAHL"), root_1);
				// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:26:26: ( LETTER )*
				while ( stream_LETTER.hasNext() ) {
					adaptor.addChild(root_1, stream_LETTER.nextNode());
				}
				stream_LETTER.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "zahl"


	public static class op_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "op"
	// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:27:1: op : OPERATOR ;
	public final artihmetic_puzzleParser.op_return op() throws RecognitionException  {
		artihmetic_puzzleParser.op_return retval = new artihmetic_puzzleParser.op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OPERATOR18=null;

		CommonTree OPERATOR18_tree=null;

		try {
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:27:4: ( OPERATOR )
			// E:\\#Alex\\#HAW\\BAI-4\\CI\\Praktikum\\aufgaben\\p1\\artihmetic_puzzle.g:27:6: OPERATOR
			{
			root_0 = (CommonTree)adaptor.nil();


			OPERATOR18=(Token)match(input,OPERATOR,FOLLOW_OPERATOR_in_op259); 
			OPERATOR18_tree = (CommonTree)adaptor.create(OPERATOR18);
			adaptor.addChild(root_0, OPERATOR18_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "op"

	// Delegated rules



	public static final BitSet FOLLOW_17_in_start61 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start64 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start65 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start68 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start69 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start72 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start73 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start76 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start77 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start80 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start81 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start84 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start85 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start88 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start89 = new BitSet(new long[]{0x0000000000010100L});
	public static final BitSet FOLLOW_zahl_in_start92 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start93 = new BitSet(new long[]{0x0000000000100100L});
	public static final BitSet FOLLOW_zahl_in_start96 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_start97 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_op_in_start100 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start101 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_op_in_start104 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start105 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_op_in_start108 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_start109 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_op_in_start112 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start113 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_op_in_start116 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_start117 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_op_in_start120 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_start121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LETTER_in_zahl242 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_OPERATOR_in_op259 = new BitSet(new long[]{0x0000000000000002L});
}
