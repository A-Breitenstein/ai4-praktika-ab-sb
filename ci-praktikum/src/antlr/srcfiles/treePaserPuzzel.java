package antlr.srcfiles;// $ANTLR 3.4 Z:\\AI4\\CI\\p1\\treePaserPuzzel.g 2013-05-30 10:42:47

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class treePaserPuzzel extends DebugTreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ERGEBNIS", "GLEICH", "HORIZONTAL", "HVOPERATIONS", "LETTER", "MINUS", "OPERAND1", "OPERAND2", "PLUS", "RAETSEL", "START", "VERTIKAL", "ZAHL", "','", "'['", "'].'", "']H['", "']V['"
    };

    public static final int EOF=-1;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "starta", "minusoperation", "zahl", "plusoperation", 
    "operation", "plus"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public treePaserPuzzel(TreeNodeStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public treePaserPuzzel(TreeNodeStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,input.getTreeAdaptor());
        setDebugListener(proxy);
        setTreeNodeStream(new DebugTreeNodeStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public treePaserPuzzel(TreeNodeStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}

    public String[] getTokenNames() { return treePaserPuzzel.tokenNames; }
    public String getGrammarFileName() { return "Z:\\AI4\\CI\\p1\\treePaserPuzzel.g"; }


    public static class starta_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "starta"
    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:9:1: starta : ^( RAETSEL ( operation )+ ) ;
    public final starta_return starta() throws RecognitionException {
        starta_return retval = new starta_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RAETSEL1=null;
        operation_return operation2 =null;


        CommonTree RAETSEL1_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "starta");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(9, 0);

        try {
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:9:8: ( ^( RAETSEL ( operation )+ ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:9:9: ^( RAETSEL ( operation )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(9,9);
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            dbg.location(9,11);
            _last = (CommonTree)input.LT(1);
            RAETSEL1=(CommonTree)match(input,RAETSEL,FOLLOW_RAETSEL_in_starta44); 
            RAETSEL1_tree = (CommonTree)adaptor.dupNode(RAETSEL1);


            root_1 = (CommonTree)adaptor.becomeRoot(RAETSEL1_tree, root_1);


            match(input, Token.DOWN, null); 
            dbg.location(9,19);
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:9:19: ( operation )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==MINUS||LA1_0==PLUS) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:9:19: operation
            	    {
            	    dbg.location(9,19);
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_operation_in_starta46);
            	    operation2=operation();

            	    state._fsp--;

            	    adaptor.addChild(root_1, operation2.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}


            match(input, Token.UP, null); 
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(9, 30);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "starta");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "starta"


    public static class operation_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "operation"
    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:10:1: operation : ( plusoperation | minusoperation );
    public final operation_return operation() throws RecognitionException {
        operation_return retval = new operation_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        plusoperation_return plusoperation3 =null;

        minusoperation_return minusoperation4 =null;



        try { dbg.enterRule(getGrammarFileName(), "operation");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(10, 0);

        try {
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:10:11: ( plusoperation | minusoperation )
            int alt2=2;
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

            int LA2_0 = input.LA(1);

            if ( (LA2_0==PLUS) ) {
                alt2=1;
            }
            else if ( (LA2_0==MINUS) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:10:13: plusoperation
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(10,13);
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_plusoperation_in_operation56);
                    plusoperation3=plusoperation();

                    state._fsp--;

                    adaptor.addChild(root_0, plusoperation3.getTree());


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:10:27: minusoperation
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(10,27);
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_minusoperation_in_operation58);
                    minusoperation4=minusoperation();

                    state._fsp--;

                    adaptor.addChild(root_0, minusoperation4.getTree());


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(10, 40);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "operation");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "operation"


    public static class plusoperation_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "plusoperation"
    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:11:1: plusoperation : ^( PLUS zahl zahl zahl ) ;
    public final plusoperation_return plusoperation() throws RecognitionException {
        plusoperation_return retval = new plusoperation_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS5=null;
        zahl_return zahl6 =null;

        zahl_return zahl7 =null;

        zahl_return zahl8 =null;


        CommonTree PLUS5_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "plusoperation");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(11, 0);

        try {
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:12:2: ( ^( PLUS zahl zahl zahl ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:12:3: ^( PLUS zahl zahl zahl )
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(12,3);
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            dbg.location(12,5);
            _last = (CommonTree)input.LT(1);
            PLUS5=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_plusoperation66); 
            PLUS5_tree = (CommonTree)adaptor.dupNode(PLUS5);


            root_1 = (CommonTree)adaptor.becomeRoot(PLUS5_tree, root_1);


            match(input, Token.DOWN, null); 
            dbg.location(12,10);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_zahl_in_plusoperation68);
            zahl6=zahl();

            state._fsp--;

            adaptor.addChild(root_1, zahl6.getTree());

            dbg.location(12,15);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_zahl_in_plusoperation70);
            zahl7=zahl();

            state._fsp--;

            adaptor.addChild(root_1, zahl7.getTree());

            dbg.location(12,20);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_zahl_in_plusoperation72);
            zahl8=zahl();

            state._fsp--;

            adaptor.addChild(root_1, zahl8.getTree());


            match(input, Token.UP, null); 
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(12, 24);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "plusoperation");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "plusoperation"


    public static class minusoperation_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "minusoperation"
    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:13:1: minusoperation : ^( MINUS o1= zahl o2= zahl r= zahl ) -> ^( plus $r $o2 $o1) ;
    public final minusoperation_return minusoperation() throws RecognitionException {
        minusoperation_return retval = new minusoperation_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS9=null;
        zahl_return o1 =null;

        zahl_return o2 =null;

        zahl_return r =null;


        CommonTree MINUS9_tree=null;
        RewriteRuleNodeStream stream_MINUS=new RewriteRuleNodeStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_zahl=new RewriteRuleSubtreeStream(adaptor,"rule zahl");
        try { dbg.enterRule(getGrammarFileName(), "minusoperation");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(13, 0);

        try {
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:14:2: ( ^( MINUS o1= zahl o2= zahl r= zahl ) -> ^( plus $r $o2 $o1) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:14:3: ^( MINUS o1= zahl o2= zahl r= zahl )
            {
            dbg.location(14,3);
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            dbg.location(14,5);
            _last = (CommonTree)input.LT(1);
            MINUS9=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_minusoperation81);  
            stream_MINUS.add(MINUS9);


            match(input, Token.DOWN, null); 
            dbg.location(14,13);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_zahl_in_minusoperation85);
            o1=zahl();

            state._fsp--;

            stream_zahl.add(o1.getTree());
            dbg.location(14,21);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_zahl_in_minusoperation89);
            o2=zahl();

            state._fsp--;

            stream_zahl.add(o2.getTree());
            dbg.location(14,28);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_zahl_in_minusoperation93);
            r=zahl();

            state._fsp--;

            stream_zahl.add(r.getTree());

            match(input, Token.UP, null); 
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            // AST REWRITE
            // elements: o2, plus, o1, r
            // token labels: 
            // rule labels: retval, o2, o1, r
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_o2=new RewriteRuleSubtreeStream(adaptor,"rule o2",o2!=null?o2.tree:null);
            RewriteRuleSubtreeStream stream_o1=new RewriteRuleSubtreeStream(adaptor,"rule o1",o1!=null?o1.tree:null);
            RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 14:35: -> ^( plus $r $o2 $o1)
            {
                dbg.location(14,38);
                // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:14:38: ^( plus $r $o2 $o1)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(14,40);

                dbg.location(14,46);
                adaptor.addChild(root_1, stream_r.nextTree());
                dbg.location(14,49);
                adaptor.addChild(root_1, stream_o2.nextTree());
                dbg.location(14,53);
                adaptor.addChild(root_1, stream_o1.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(14, 56);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "minusoperation");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "minusoperation"


    public static class zahl_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "zahl"
    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:15:1: zahl : ^( ZAHL ( LETTER )+ ) ;
    public final zahl_return zahl() throws RecognitionException {
        zahl_return retval = new zahl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ZAHL10=null;
        CommonTree LETTER11=null;

        CommonTree ZAHL10_tree=null;
        CommonTree LETTER11_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "zahl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(15, 0);

        try {
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:15:6: ( ^( ZAHL ( LETTER )+ ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:15:8: ^( ZAHL ( LETTER )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(15,8);
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            dbg.location(15,10);
            _last = (CommonTree)input.LT(1);
            ZAHL10=(CommonTree)match(input,ZAHL,FOLLOW_ZAHL_in_zahl118); 
            ZAHL10_tree = (CommonTree)adaptor.dupNode(ZAHL10);


            root_1 = (CommonTree)adaptor.becomeRoot(ZAHL10_tree, root_1);


            match(input, Token.DOWN, null); 
            dbg.location(15,15);
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:15:15: ( LETTER )+
            int cnt3=0;
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==LETTER) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:15:15: LETTER
            	    {
            	    dbg.location(15,15);
            	    _last = (CommonTree)input.LT(1);
            	    LETTER11=(CommonTree)match(input,LETTER,FOLLOW_LETTER_in_zahl120); 
            	    LETTER11_tree = (CommonTree)adaptor.dupNode(LETTER11);


            	    adaptor.addChild(root_1, LETTER11_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt3++;
            } while (true);
            } finally {dbg.exitSubRule(3);}


            match(input, Token.UP, null); 
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(15, 22);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "zahl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "zahl"


    public static class plus_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "plus"
    // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:16:1: plus : PLUS ;
    public final plus_return plus() throws RecognitionException {
        plus_return retval = new plus_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS12=null;

        CommonTree PLUS12_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "plus");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(16, 0);

        try {
            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:16:6: ( PLUS )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\treePaserPuzzel.g:16:7: PLUS
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(16,7);
            _last = (CommonTree)input.LT(1);
            PLUS12=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_plus128); 
            PLUS12_tree = (CommonTree)adaptor.dupNode(PLUS12);


            adaptor.addChild(root_0, PLUS12_tree);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(16, 10);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "plus");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "plus"

    // Delegated rules


 

    public static final BitSet FOLLOW_RAETSEL_in_starta44 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_operation_in_starta46 = new BitSet(new long[]{0x0000000000001208L});
    public static final BitSet FOLLOW_plusoperation_in_operation56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minusoperation_in_operation58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_plusoperation66 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_zahl_in_plusoperation68 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_zahl_in_plusoperation70 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_zahl_in_plusoperation72 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_minusoperation81 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_zahl_in_minusoperation85 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_zahl_in_minusoperation89 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_zahl_in_minusoperation93 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ZAHL_in_zahl118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LETTER_in_zahl120 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_PLUS_in_plus128 = new BitSet(new long[]{0x0000000000000002L});

}