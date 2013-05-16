package antlr.srcfiles;// $ANTLR 3.4 Z:\\AI4\\CI\\p1\\miniP.g 2013-04-30 12:41:40

import org.antlr.runtime.*;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class miniPParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNING_OP", "BEGIN", "BODY", "BOOLEAN_TYP", "CLOSEING_BRACKET", "DANN", "DIGIT", "DIV", "EGNALOS", "END", "FLOAT_CONST", "FLOAT_TYP", "ID", "INIT", "INTEGER_TYP", "INT_CONST", "LETTER", "MINUS", "MUL", "MULTILINE_COMMENT", "NNEW", "OPENING_BRACKET", "PLUS", "PRINTLN", "PROGRAMM", "READ", "RELOP", "SEPERATOR", "SOLANGE", "SONST", "SPECIALCHARACTER", "STATEMENT_END", "STRING_CONST", "STRING_TYP", "TUE", "WENN", "WHITESPACE", "'false'", "'true'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "possible_assignments", "statement", "solange_statement", 
    "comparison", "body", "constants", "term", "assignment", "arithmetic_expression", 
    "start", "declaration", "dann_statement", "wenn_statement", "init", 
    "var_typ", "println", "tue_statement", "read", "sonst_statement", "factor"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public miniPParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public miniPParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
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

public miniPParser(TokenStream input, DebugEventListener dbg) {
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

    public String[] getTokenNames() { return miniPParser.tokenNames; }
    public String getGrammarFileName() { return "Z:\\AI4\\CI\\p1\\miniP.g"; }


    public static class constants_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constants"
    // Z:\\AI4\\CI\\p1\\miniP.g:56:1: constants : ( INT_CONST | STRING_CONST | ( 'true' | 'false' ) | FLOAT_CONST ) ;
    public final miniPParser.constants_return constants() throws RecognitionException {
        miniPParser.constants_return retval = new miniPParser.constants_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set1=null;

        CommonTree set1_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "constants");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:56:12: ( ( INT_CONST | STRING_CONST | ( 'true' | 'false' ) | FLOAT_CONST ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(56,12);
            set1=(Token)input.LT(1);

            if ( input.LA(1)==FLOAT_CONST||input.LA(1)==INT_CONST||input.LA(1)==STRING_CONST||(input.LA(1) >= 41 && input.LA(1) <= 42) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set1)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


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
        dbg.location(56, 67);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "constants");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "constants"


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "start"
    // Z:\\AI4\\CI\\p1\\miniP.g:65:1: start : PROGRAMM init BEGIN body END -> ^( PROGRAMM init body ) ;
    public final miniPParser.start_return start() throws RecognitionException {
        miniPParser.start_return retval = new miniPParser.start_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PROGRAMM2=null;
        Token BEGIN4=null;
        Token END6=null;
        miniPParser.init_return init3 =null;

        miniPParser.body_return body5 =null;


        CommonTree PROGRAMM2_tree=null;
        CommonTree BEGIN4_tree=null;
        CommonTree END6_tree=null;
        RewriteRuleTokenStream stream_PROGRAMM=new RewriteRuleTokenStream(adaptor,"token PROGRAMM");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
        RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"rule body");
        RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init");
        try { dbg.enterRule(getGrammarFileName(), "start");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(65, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:65:7: ( PROGRAMM init BEGIN body END -> ^( PROGRAMM init body ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:65:9: PROGRAMM init BEGIN body END
            {
            dbg.location(65,9);
            PROGRAMM2=(Token)match(input,PROGRAMM,FOLLOW_PROGRAMM_in_start465);  
            stream_PROGRAMM.add(PROGRAMM2);

            dbg.location(65,18);
            pushFollow(FOLLOW_init_in_start467);
            init3=init();

            state._fsp--;

            stream_init.add(init3.getTree());
            dbg.location(65,23);
            BEGIN4=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_start469);  
            stream_BEGIN.add(BEGIN4);

            dbg.location(65,29);
            pushFollow(FOLLOW_body_in_start471);
            body5=body();

            state._fsp--;

            stream_body.add(body5.getTree());
            dbg.location(65,34);
            END6=(Token)match(input,END,FOLLOW_END_in_start473);  
            stream_END.add(END6);


            // AST REWRITE
            // elements: init, PROGRAMM, body
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 65:38: -> ^( PROGRAMM init body )
            {
                dbg.location(65,40);
                // Z:\\AI4\\CI\\p1\\miniP.g:65:40: ^( PROGRAMM init body )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(65,42);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_PROGRAMM.nextNode()
                , root_1);

                dbg.location(65,51);
                adaptor.addChild(root_1, stream_init.nextTree());
                dbg.location(65,56);
                adaptor.addChild(root_1, stream_body.nextTree());

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
        dbg.location(65, 60);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "start");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "start"


    public static class init_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "init"
    // Z:\\AI4\\CI\\p1\\miniP.g:66:1: init : ( declaration )* -> ^( INIT ( declaration )* ) ;
    public final miniPParser.init_return init() throws RecognitionException {
        miniPParser.init_return retval = new miniPParser.init_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        miniPParser.declaration_return declaration7 =null;


        RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");
        try { dbg.enterRule(getGrammarFileName(), "init");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:66:6: ( ( declaration )* -> ^( INIT ( declaration )* ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:66:8: ( declaration )*
            {
            dbg.location(66,8);
            // Z:\\AI4\\CI\\p1\\miniP.g:66:8: ( declaration )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==BOOLEAN_TYP||LA1_0==FLOAT_TYP||LA1_0==INTEGER_TYP||LA1_0==STRING_TYP) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\miniP.g:66:8: declaration
            	    {
            	    dbg.location(66,8);
            	    pushFollow(FOLLOW_declaration_in_init489);
            	    declaration7=declaration();

            	    state._fsp--;

            	    stream_declaration.add(declaration7.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}


            // AST REWRITE
            // elements: declaration
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 66:21: -> ^( INIT ( declaration )* )
            {
                dbg.location(66,24);
                // Z:\\AI4\\CI\\p1\\miniP.g:66:24: ^( INIT ( declaration )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(66,26);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(INIT, "INIT")
                , root_1);

                dbg.location(66,31);
                // Z:\\AI4\\CI\\p1\\miniP.g:66:31: ( declaration )*
                while ( stream_declaration.hasNext() ) {
                    dbg.location(66,31);
                    adaptor.addChild(root_1, stream_declaration.nextTree());

                }
                stream_declaration.reset();

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
        dbg.location(66, 43);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "init");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "init"


    public static class body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "body"
    // Z:\\AI4\\CI\\p1\\miniP.g:67:1: body : ( statement )+ -> ^( BODY ( statement )+ ) ;
    public final miniPParser.body_return body() throws RecognitionException {
        miniPParser.body_return retval = new miniPParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        miniPParser.statement_return statement8 =null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try { dbg.enterRule(getGrammarFileName(), "body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(67, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:67:6: ( ( statement )+ -> ^( BODY ( statement )+ ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:67:8: ( statement )+
            {
            dbg.location(67,8);
            // Z:\\AI4\\CI\\p1\\miniP.g:67:8: ( statement )+
            int cnt2=0;
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||LA2_0==MULTILINE_COMMENT||LA2_0==PRINTLN||LA2_0==READ||LA2_0==SOLANGE||LA2_0==WENN) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\miniP.g:67:8: statement
            	    {
            	    dbg.location(67,8);
            	    pushFollow(FOLLOW_statement_in_body506);
            	    statement8=statement();

            	    state._fsp--;

            	    stream_statement.add(statement8.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt2++;
            } while (true);
            } finally {dbg.exitSubRule(2);}


            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 67:19: -> ^( BODY ( statement )+ )
            {
                dbg.location(67,22);
                // Z:\\AI4\\CI\\p1\\miniP.g:67:22: ^( BODY ( statement )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(67,24);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BODY, "BODY")
                , root_1);

                dbg.location(67,29);
                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    dbg.location(67,29);
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

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
        dbg.location(67, 39);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "body"


    public static class declaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declaration"
    // Z:\\AI4\\CI\\p1\\miniP.g:69:1: declaration : var_typ ^ ID ( SEPERATOR ! ID )* STATEMENT_END !;
    public final miniPParser.declaration_return declaration() throws RecognitionException {
        miniPParser.declaration_return retval = new miniPParser.declaration_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID10=null;
        Token SEPERATOR11=null;
        Token ID12=null;
        Token STATEMENT_END13=null;
        miniPParser.var_typ_return var_typ9 =null;


        CommonTree ID10_tree=null;
        CommonTree SEPERATOR11_tree=null;
        CommonTree ID12_tree=null;
        CommonTree STATEMENT_END13_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(69, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:69:13: ( var_typ ^ ID ( SEPERATOR ! ID )* STATEMENT_END !)
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:69:15: var_typ ^ ID ( SEPERATOR ! ID )* STATEMENT_END !
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(69,22);
            pushFollow(FOLLOW_var_typ_in_declaration524);
            var_typ9=var_typ();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(var_typ9.getTree(), root_0);
            dbg.location(69,24);
            ID10=(Token)match(input,ID,FOLLOW_ID_in_declaration527); 
            ID10_tree = 
            (CommonTree)adaptor.create(ID10)
            ;
            adaptor.addChild(root_0, ID10_tree);

            dbg.location(69,27);
            // Z:\\AI4\\CI\\p1\\miniP.g:69:27: ( SEPERATOR ! ID )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==SEPERATOR) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\miniP.g:69:28: SEPERATOR ! ID
            	    {
            	    dbg.location(69,37);
            	    SEPERATOR11=(Token)match(input,SEPERATOR,FOLLOW_SEPERATOR_in_declaration530); 
            	    dbg.location(69,39);
            	    ID12=(Token)match(input,ID,FOLLOW_ID_in_declaration533); 
            	    ID12_tree = 
            	    (CommonTree)adaptor.create(ID12)
            	    ;
            	    adaptor.addChild(root_0, ID12_tree);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}

            dbg.location(69,57);
            STATEMENT_END13=(Token)match(input,STATEMENT_END,FOLLOW_STATEMENT_END_in_declaration537); 

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
        dbg.location(69, 57);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "declaration"


    public static class var_typ_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_typ"
    // Z:\\AI4\\CI\\p1\\miniP.g:70:1: var_typ : ( INTEGER_TYP | FLOAT_TYP | BOOLEAN_TYP | STRING_TYP ) ;
    public final miniPParser.var_typ_return var_typ() throws RecognitionException {
        miniPParser.var_typ_return retval = new miniPParser.var_typ_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set14=null;

        CommonTree set14_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "var_typ");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(70, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:70:9: ( ( INTEGER_TYP | FLOAT_TYP | BOOLEAN_TYP | STRING_TYP ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(70,9);
            set14=(Token)input.LT(1);

            if ( input.LA(1)==BOOLEAN_TYP||input.LA(1)==FLOAT_TYP||input.LA(1)==INTEGER_TYP||input.LA(1)==STRING_TYP ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set14)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


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
        dbg.location(70, 64);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "var_typ");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "var_typ"


    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // Z:\\AI4\\CI\\p1\\miniP.g:72:1: statement : ( assignment | wenn_statement | solange_statement | read | println | MULTILINE_COMMENT !) ;
    public final miniPParser.statement_return statement() throws RecognitionException {
        miniPParser.statement_return retval = new miniPParser.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token MULTILINE_COMMENT20=null;
        miniPParser.assignment_return assignment15 =null;

        miniPParser.wenn_statement_return wenn_statement16 =null;

        miniPParser.solange_statement_return solange_statement17 =null;

        miniPParser.read_return read18 =null;

        miniPParser.println_return println19 =null;


        CommonTree MULTILINE_COMMENT20_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(72, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:72:12: ( ( assignment | wenn_statement | solange_statement | read | println | MULTILINE_COMMENT !) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:72:13: ( assignment | wenn_statement | solange_statement | read | println | MULTILINE_COMMENT !)
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(72,13);
            // Z:\\AI4\\CI\\p1\\miniP.g:72:13: ( assignment | wenn_statement | solange_statement | read | println | MULTILINE_COMMENT !)
            int alt4=6;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            switch ( input.LA(1) ) {
            case ID:
                {
                alt4=1;
                }
                break;
            case WENN:
                {
                alt4=2;
                }
                break;
            case SOLANGE:
                {
                alt4=3;
                }
                break;
            case READ:
                {
                alt4=4;
                }
                break;
            case PRINTLN:
                {
                alt4=5;
                }
                break;
            case MULTILINE_COMMENT:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:72:14: assignment
                    {
                    dbg.location(72,14);
                    pushFollow(FOLLOW_assignment_in_statement570);
                    assignment15=assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, assignment15.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // Z:\\AI4\\CI\\p1\\miniP.g:72:26: wenn_statement
                    {
                    dbg.location(72,26);
                    pushFollow(FOLLOW_wenn_statement_in_statement573);
                    wenn_statement16=wenn_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, wenn_statement16.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // Z:\\AI4\\CI\\p1\\miniP.g:72:42: solange_statement
                    {
                    dbg.location(72,42);
                    pushFollow(FOLLOW_solange_statement_in_statement576);
                    solange_statement17=solange_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, solange_statement17.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // Z:\\AI4\\CI\\p1\\miniP.g:72:62: read
                    {
                    dbg.location(72,62);
                    pushFollow(FOLLOW_read_in_statement580);
                    read18=read();

                    state._fsp--;

                    adaptor.addChild(root_0, read18.getTree());

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // Z:\\AI4\\CI\\p1\\miniP.g:72:69: println
                    {
                    dbg.location(72,69);
                    pushFollow(FOLLOW_println_in_statement584);
                    println19=println();

                    state._fsp--;

                    adaptor.addChild(root_0, println19.getTree());

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // Z:\\AI4\\CI\\p1\\miniP.g:72:80: MULTILINE_COMMENT !
                    {
                    dbg.location(72,97);
                    MULTILINE_COMMENT20=(Token)match(input,MULTILINE_COMMENT,FOLLOW_MULTILINE_COMMENT_in_statement589); 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}


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
        dbg.location(72, 99);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "statement"


    public static class assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignment"
    // Z:\\AI4\\CI\\p1\\miniP.g:73:1: assignment : ID ASSIGNING_OP possible_assignments STATEMENT_END -> ^( ASSIGNING_OP ID possible_assignments ) ;
    public final miniPParser.assignment_return assignment() throws RecognitionException {
        miniPParser.assignment_return retval = new miniPParser.assignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID21=null;
        Token ASSIGNING_OP22=null;
        Token STATEMENT_END24=null;
        miniPParser.possible_assignments_return possible_assignments23 =null;


        CommonTree ID21_tree=null;
        CommonTree ASSIGNING_OP22_tree=null;
        CommonTree STATEMENT_END24_tree=null;
        RewriteRuleTokenStream stream_ASSIGNING_OP=new RewriteRuleTokenStream(adaptor,"token ASSIGNING_OP");
        RewriteRuleTokenStream stream_STATEMENT_END=new RewriteRuleTokenStream(adaptor,"token STATEMENT_END");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_possible_assignments=new RewriteRuleSubtreeStream(adaptor,"rule possible_assignments");
        try { dbg.enterRule(getGrammarFileName(), "assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(73, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:73:12: ( ID ASSIGNING_OP possible_assignments STATEMENT_END -> ^( ASSIGNING_OP ID possible_assignments ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:73:14: ID ASSIGNING_OP possible_assignments STATEMENT_END
            {
            dbg.location(73,14);
            ID21=(Token)match(input,ID,FOLLOW_ID_in_assignment599);  
            stream_ID.add(ID21);

            dbg.location(73,17);
            ASSIGNING_OP22=(Token)match(input,ASSIGNING_OP,FOLLOW_ASSIGNING_OP_in_assignment601);  
            stream_ASSIGNING_OP.add(ASSIGNING_OP22);

            dbg.location(73,30);
            pushFollow(FOLLOW_possible_assignments_in_assignment603);
            possible_assignments23=possible_assignments();

            state._fsp--;

            stream_possible_assignments.add(possible_assignments23.getTree());
            dbg.location(73,51);
            STATEMENT_END24=(Token)match(input,STATEMENT_END,FOLLOW_STATEMENT_END_in_assignment605);  
            stream_STATEMENT_END.add(STATEMENT_END24);


            // AST REWRITE
            // elements: ASSIGNING_OP, possible_assignments, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 73:65: -> ^( ASSIGNING_OP ID possible_assignments )
            {
                dbg.location(73,68);
                // Z:\\AI4\\CI\\p1\\miniP.g:73:68: ^( ASSIGNING_OP ID possible_assignments )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(73,70);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_ASSIGNING_OP.nextNode()
                , root_1);

                dbg.location(73,83);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(73,86);
                adaptor.addChild(root_1, stream_possible_assignments.nextTree());

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
        dbg.location(73, 106);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "assignment"


    public static class possible_assignments_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "possible_assignments"
    // Z:\\AI4\\CI\\p1\\miniP.g:74:1: possible_assignments : ( arithmetic_expression | comparison | STRING_CONST ) ;
    public final miniPParser.possible_assignments_return possible_assignments() throws RecognitionException {
        miniPParser.possible_assignments_return retval = new miniPParser.possible_assignments_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token STRING_CONST27=null;
        miniPParser.arithmetic_expression_return arithmetic_expression25 =null;

        miniPParser.comparison_return comparison26 =null;


        CommonTree STRING_CONST27_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "possible_assignments");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(74, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:74:21: ( ( arithmetic_expression | comparison | STRING_CONST ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:74:23: ( arithmetic_expression | comparison | STRING_CONST )
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(74,23);
            // Z:\\AI4\\CI\\p1\\miniP.g:74:23: ( arithmetic_expression | comparison | STRING_CONST )
            int alt5=3;
            try { dbg.enterSubRule(5);
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            switch ( input.LA(1) ) {
            case ID:
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==DIV||(LA5_1 >= MINUS && LA5_1 <= MUL)||LA5_1==PLUS||LA5_1==STATEMENT_END) ) {
                    alt5=1;
                }
                else if ( (LA5_1==RELOP) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case OPENING_BRACKET:
                {
                alt5=1;
                }
                break;
            case FLOAT_CONST:
            case INT_CONST:
                {
                int LA5_3 = input.LA(2);

                if ( (LA5_3==DIV||(LA5_3 >= MINUS && LA5_3 <= MUL)||LA5_3==PLUS||LA5_3==STATEMENT_END) ) {
                    alt5=1;
                }
                else if ( (LA5_3==RELOP) ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 3, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case STRING_CONST:
                {
                int LA5_4 = input.LA(2);

                if ( (LA5_4==RELOP) ) {
                    alt5=2;
                }
                else if ( (LA5_4==STATEMENT_END) ) {
                    alt5=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 4, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case 41:
            case 42:
                {
                alt5=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:74:24: arithmetic_expression
                    {
                    dbg.location(74,24);
                    pushFollow(FOLLOW_arithmetic_expression_in_possible_assignments622);
                    arithmetic_expression25=arithmetic_expression();

                    state._fsp--;

                    adaptor.addChild(root_0, arithmetic_expression25.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // Z:\\AI4\\CI\\p1\\miniP.g:74:46: comparison
                    {
                    dbg.location(74,46);
                    pushFollow(FOLLOW_comparison_in_possible_assignments624);
                    comparison26=comparison();

                    state._fsp--;

                    adaptor.addChild(root_0, comparison26.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // Z:\\AI4\\CI\\p1\\miniP.g:74:57: STRING_CONST
                    {
                    dbg.location(74,57);
                    STRING_CONST27=(Token)match(input,STRING_CONST,FOLLOW_STRING_CONST_in_possible_assignments626); 
                    STRING_CONST27_tree = 
                    (CommonTree)adaptor.create(STRING_CONST27)
                    ;
                    adaptor.addChild(root_0, STRING_CONST27_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(5);}


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
        dbg.location(74, 69);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "possible_assignments");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "possible_assignments"


    public static class arithmetic_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arithmetic_expression"
    // Z:\\AI4\\CI\\p1\\miniP.g:76:1: arithmetic_expression : term ( ( PLUS ^| MINUS ^) term )* ;
    public final miniPParser.arithmetic_expression_return arithmetic_expression() throws RecognitionException {
        miniPParser.arithmetic_expression_return retval = new miniPParser.arithmetic_expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PLUS29=null;
        Token MINUS30=null;
        miniPParser.term_return term28 =null;

        miniPParser.term_return term31 =null;


        CommonTree PLUS29_tree=null;
        CommonTree MINUS30_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "arithmetic_expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(76, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:76:23: ( term ( ( PLUS ^| MINUS ^) term )* )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:76:26: term ( ( PLUS ^| MINUS ^) term )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(76,26);
            pushFollow(FOLLOW_term_in_arithmetic_expression636);
            term28=term();

            state._fsp--;

            adaptor.addChild(root_0, term28.getTree());
            dbg.location(76,31);
            // Z:\\AI4\\CI\\p1\\miniP.g:76:31: ( ( PLUS ^| MINUS ^) term )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==MINUS||LA7_0==PLUS) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\miniP.g:76:32: ( PLUS ^| MINUS ^) term
            	    {
            	    dbg.location(76,32);
            	    // Z:\\AI4\\CI\\p1\\miniP.g:76:32: ( PLUS ^| MINUS ^)
            	    int alt6=2;
            	    try { dbg.enterSubRule(6);
            	    try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==PLUS) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==MINUS) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }
            	    } finally {dbg.exitDecision(6);}

            	    switch (alt6) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // Z:\\AI4\\CI\\p1\\miniP.g:76:34: PLUS ^
            	            {
            	            dbg.location(76,38);
            	            PLUS29=(Token)match(input,PLUS,FOLLOW_PLUS_in_arithmetic_expression641); 
            	            PLUS29_tree = 
            	            (CommonTree)adaptor.create(PLUS29)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(PLUS29_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // Z:\\AI4\\CI\\p1\\miniP.g:76:42: MINUS ^
            	            {
            	            dbg.location(76,47);
            	            MINUS30=(Token)match(input,MINUS,FOLLOW_MINUS_in_arithmetic_expression646); 
            	            MINUS30_tree = 
            	            (CommonTree)adaptor.create(MINUS30)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MINUS30_tree, root_0);


            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(6);}

            	    dbg.location(76,51);
            	    pushFollow(FOLLOW_term_in_arithmetic_expression651);
            	    term31=term();

            	    state._fsp--;

            	    adaptor.addChild(root_0, term31.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}


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
        dbg.location(76, 57);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "arithmetic_expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "arithmetic_expression"


    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // Z:\\AI4\\CI\\p1\\miniP.g:77:1: term : factor ( ( DIV ^| MUL ^) factor )* ;
    public final miniPParser.term_return term() throws RecognitionException {
        miniPParser.term_return retval = new miniPParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DIV33=null;
        Token MUL34=null;
        miniPParser.factor_return factor32 =null;

        miniPParser.factor_return factor35 =null;


        CommonTree DIV33_tree=null;
        CommonTree MUL34_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "term");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(77, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:77:6: ( factor ( ( DIV ^| MUL ^) factor )* )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:77:8: factor ( ( DIV ^| MUL ^) factor )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(77,8);
            pushFollow(FOLLOW_factor_in_term661);
            factor32=factor();

            state._fsp--;

            adaptor.addChild(root_0, factor32.getTree());
            dbg.location(77,15);
            // Z:\\AI4\\CI\\p1\\miniP.g:77:15: ( ( DIV ^| MUL ^) factor )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==DIV||LA9_0==MUL) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\miniP.g:77:16: ( DIV ^| MUL ^) factor
            	    {
            	    dbg.location(77,16);
            	    // Z:\\AI4\\CI\\p1\\miniP.g:77:16: ( DIV ^| MUL ^)
            	    int alt8=2;
            	    try { dbg.enterSubRule(8);
            	    try { dbg.enterDecision(8, decisionCanBacktrack[8]);

            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==DIV) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==MUL) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }
            	    } finally {dbg.exitDecision(8);}

            	    switch (alt8) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // Z:\\AI4\\CI\\p1\\miniP.g:77:18: DIV ^
            	            {
            	            dbg.location(77,21);
            	            DIV33=(Token)match(input,DIV,FOLLOW_DIV_in_term666); 
            	            DIV33_tree = 
            	            (CommonTree)adaptor.create(DIV33)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(DIV33_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // Z:\\AI4\\CI\\p1\\miniP.g:77:25: MUL ^
            	            {
            	            dbg.location(77,28);
            	            MUL34=(Token)match(input,MUL,FOLLOW_MUL_in_term671); 
            	            MUL34_tree = 
            	            (CommonTree)adaptor.create(MUL34)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(MUL34_tree, root_0);


            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(8);}

            	    dbg.location(77,32);
            	    pushFollow(FOLLOW_factor_in_term676);
            	    factor35=factor();

            	    state._fsp--;

            	    adaptor.addChild(root_0, factor35.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}


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
        dbg.location(77, 41);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "term");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "term"


    public static class factor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "factor"
    // Z:\\AI4\\CI\\p1\\miniP.g:78:1: factor : ( ( INT_CONST | FLOAT_CONST | ID ) | ( OPENING_BRACKET ! arithmetic_expression CLOSEING_BRACKET !) ) ;
    public final miniPParser.factor_return factor() throws RecognitionException {
        miniPParser.factor_return retval = new miniPParser.factor_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set36=null;
        Token OPENING_BRACKET37=null;
        Token CLOSEING_BRACKET39=null;
        miniPParser.arithmetic_expression_return arithmetic_expression38 =null;


        CommonTree set36_tree=null;
        CommonTree OPENING_BRACKET37_tree=null;
        CommonTree CLOSEING_BRACKET39_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "factor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(78, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:78:9: ( ( ( INT_CONST | FLOAT_CONST | ID ) | ( OPENING_BRACKET ! arithmetic_expression CLOSEING_BRACKET !) ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:78:10: ( ( INT_CONST | FLOAT_CONST | ID ) | ( OPENING_BRACKET ! arithmetic_expression CLOSEING_BRACKET !) )
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(78,10);
            // Z:\\AI4\\CI\\p1\\miniP.g:78:10: ( ( INT_CONST | FLOAT_CONST | ID ) | ( OPENING_BRACKET ! arithmetic_expression CLOSEING_BRACKET !) )
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==FLOAT_CONST||LA10_0==ID||LA10_0==INT_CONST) ) {
                alt10=1;
            }
            else if ( (LA10_0==OPENING_BRACKET) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:78:12: ( INT_CONST | FLOAT_CONST | ID )
                    {
                    dbg.location(78,12);
                    set36=(Token)input.LT(1);

                    if ( input.LA(1)==FLOAT_CONST||input.LA(1)==ID||input.LA(1)==INT_CONST ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(set36)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        dbg.recognitionException(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // Z:\\AI4\\CI\\p1\\miniP.g:78:41: ( OPENING_BRACKET ! arithmetic_expression CLOSEING_BRACKET !)
                    {
                    dbg.location(78,41);
                    // Z:\\AI4\\CI\\p1\\miniP.g:78:41: ( OPENING_BRACKET ! arithmetic_expression CLOSEING_BRACKET !)
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:78:43: OPENING_BRACKET ! arithmetic_expression CLOSEING_BRACKET !
                    {
                    dbg.location(78,58);
                    OPENING_BRACKET37=(Token)match(input,OPENING_BRACKET,FOLLOW_OPENING_BRACKET_in_factor701); 
                    dbg.location(78,60);
                    pushFollow(FOLLOW_arithmetic_expression_in_factor704);
                    arithmetic_expression38=arithmetic_expression();

                    state._fsp--;

                    adaptor.addChild(root_0, arithmetic_expression38.getTree());
                    dbg.location(78,98);
                    CLOSEING_BRACKET39=(Token)match(input,CLOSEING_BRACKET,FOLLOW_CLOSEING_BRACKET_in_factor706); 

                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}


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
        dbg.location(78, 101);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "factor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "factor"


    public static class comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comparison"
    // Z:\\AI4\\CI\\p1\\miniP.g:80:1: comparison : ( ID | constants ) RELOP ^ ( ID | constants ) ;
    public final miniPParser.comparison_return comparison() throws RecognitionException {
        miniPParser.comparison_return retval = new miniPParser.comparison_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID40=null;
        Token RELOP42=null;
        Token ID43=null;
        miniPParser.constants_return constants41 =null;

        miniPParser.constants_return constants44 =null;


        CommonTree ID40_tree=null;
        CommonTree RELOP42_tree=null;
        CommonTree ID43_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "comparison");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(80, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:80:13: ( ( ID | constants ) RELOP ^ ( ID | constants ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:80:15: ( ID | constants ) RELOP ^ ( ID | constants )
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(80,15);
            // Z:\\AI4\\CI\\p1\\miniP.g:80:15: ( ID | constants )
            int alt11=2;
            try { dbg.enterSubRule(11);
            try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==FLOAT_CONST||LA11_0==INT_CONST||LA11_0==STRING_CONST||(LA11_0 >= 41 && LA11_0 <= 42)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:80:16: ID
                    {
                    dbg.location(80,16);
                    ID40=(Token)match(input,ID,FOLLOW_ID_in_comparison720); 
                    ID40_tree = 
                    (CommonTree)adaptor.create(ID40)
                    ;
                    adaptor.addChild(root_0, ID40_tree);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // Z:\\AI4\\CI\\p1\\miniP.g:80:19: constants
                    {
                    dbg.location(80,19);
                    pushFollow(FOLLOW_constants_in_comparison722);
                    constants41=constants();

                    state._fsp--;

                    adaptor.addChild(root_0, constants41.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(11);}

            dbg.location(80,35);
            RELOP42=(Token)match(input,RELOP,FOLLOW_RELOP_in_comparison725); 
            RELOP42_tree = 
            (CommonTree)adaptor.create(RELOP42)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(RELOP42_tree, root_0);

            dbg.location(80,37);
            // Z:\\AI4\\CI\\p1\\miniP.g:80:37: ( ID | constants )
            int alt12=2;
            try { dbg.enterSubRule(12);
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==FLOAT_CONST||LA12_0==INT_CONST||LA12_0==STRING_CONST||(LA12_0 >= 41 && LA12_0 <= 42)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:80:38: ID
                    {
                    dbg.location(80,38);
                    ID43=(Token)match(input,ID,FOLLOW_ID_in_comparison729); 
                    ID43_tree = 
                    (CommonTree)adaptor.create(ID43)
                    ;
                    adaptor.addChild(root_0, ID43_tree);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // Z:\\AI4\\CI\\p1\\miniP.g:80:41: constants
                    {
                    dbg.location(80,41);
                    pushFollow(FOLLOW_constants_in_comparison731);
                    constants44=constants();

                    state._fsp--;

                    adaptor.addChild(root_0, constants44.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(12);}


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
        dbg.location(80, 50);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "comparison");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "comparison"


    public static class wenn_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "wenn_statement"
    // Z:\\AI4\\CI\\p1\\miniP.g:81:1: wenn_statement : WENN comparison dann_statement sonst_statement NNEW -> ^( WENN comparison dann_statement sonst_statement ) ;
    public final miniPParser.wenn_statement_return wenn_statement() throws RecognitionException {
        miniPParser.wenn_statement_return retval = new miniPParser.wenn_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token WENN45=null;
        Token NNEW49=null;
        miniPParser.comparison_return comparison46 =null;

        miniPParser.dann_statement_return dann_statement47 =null;

        miniPParser.sonst_statement_return sonst_statement48 =null;


        CommonTree WENN45_tree=null;
        CommonTree NNEW49_tree=null;
        RewriteRuleTokenStream stream_NNEW=new RewriteRuleTokenStream(adaptor,"token NNEW");
        RewriteRuleTokenStream stream_WENN=new RewriteRuleTokenStream(adaptor,"token WENN");
        RewriteRuleSubtreeStream stream_dann_statement=new RewriteRuleSubtreeStream(adaptor,"rule dann_statement");
        RewriteRuleSubtreeStream stream_sonst_statement=new RewriteRuleSubtreeStream(adaptor,"rule sonst_statement");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try { dbg.enterRule(getGrammarFileName(), "wenn_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(81, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:81:17: ( WENN comparison dann_statement sonst_statement NNEW -> ^( WENN comparison dann_statement sonst_statement ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:81:19: WENN comparison dann_statement sonst_statement NNEW
            {
            dbg.location(81,19);
            WENN45=(Token)match(input,WENN,FOLLOW_WENN_in_wenn_statement740);  
            stream_WENN.add(WENN45);

            dbg.location(81,24);
            pushFollow(FOLLOW_comparison_in_wenn_statement742);
            comparison46=comparison();

            state._fsp--;

            stream_comparison.add(comparison46.getTree());
            dbg.location(81,35);
            pushFollow(FOLLOW_dann_statement_in_wenn_statement744);
            dann_statement47=dann_statement();

            state._fsp--;

            stream_dann_statement.add(dann_statement47.getTree());
            dbg.location(81,50);
            pushFollow(FOLLOW_sonst_statement_in_wenn_statement746);
            sonst_statement48=sonst_statement();

            state._fsp--;

            stream_sonst_statement.add(sonst_statement48.getTree());
            dbg.location(81,66);
            NNEW49=(Token)match(input,NNEW,FOLLOW_NNEW_in_wenn_statement748);  
            stream_NNEW.add(NNEW49);


            // AST REWRITE
            // elements: comparison, sonst_statement, WENN, dann_statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 81:71: -> ^( WENN comparison dann_statement sonst_statement )
            {
                dbg.location(81,73);
                // Z:\\AI4\\CI\\p1\\miniP.g:81:73: ^( WENN comparison dann_statement sonst_statement )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(81,75);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_WENN.nextNode()
                , root_1);

                dbg.location(81,80);
                adaptor.addChild(root_1, stream_comparison.nextTree());
                dbg.location(81,91);
                adaptor.addChild(root_1, stream_dann_statement.nextTree());
                dbg.location(81,106);
                adaptor.addChild(root_1, stream_sonst_statement.nextTree());

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
        dbg.location(81, 121);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "wenn_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "wenn_statement"


    public static class dann_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dann_statement"
    // Z:\\AI4\\CI\\p1\\miniP.g:82:1: dann_statement : DANN ^ ( statement )* ;
    public final miniPParser.dann_statement_return dann_statement() throws RecognitionException {
        miniPParser.dann_statement_return retval = new miniPParser.dann_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DANN50=null;
        miniPParser.statement_return statement51 =null;


        CommonTree DANN50_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "dann_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(82, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:82:17: ( DANN ^ ( statement )* )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:82:19: DANN ^ ( statement )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(82,23);
            DANN50=(Token)match(input,DANN,FOLLOW_DANN_in_dann_statement767); 
            DANN50_tree = 
            (CommonTree)adaptor.create(DANN50)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(DANN50_tree, root_0);

            dbg.location(82,25);
            // Z:\\AI4\\CI\\p1\\miniP.g:82:25: ( statement )*
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=2;
                try { dbg.enterDecision(13, decisionCanBacktrack[13]);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==ID||LA13_0==MULTILINE_COMMENT||LA13_0==PRINTLN||LA13_0==READ||LA13_0==SOLANGE||LA13_0==WENN) ) {
                    alt13=1;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\miniP.g:82:25: statement
            	    {
            	    dbg.location(82,25);
            	    pushFollow(FOLLOW_statement_in_dann_statement770);
            	    statement51=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement51.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);
            } finally {dbg.exitSubRule(13);}


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
        dbg.location(82, 34);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "dann_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "dann_statement"


    public static class sonst_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sonst_statement"
    // Z:\\AI4\\CI\\p1\\miniP.g:83:1: sonst_statement : ( SONST ^ ( statement )* )? ;
    public final miniPParser.sonst_statement_return sonst_statement() throws RecognitionException {
        miniPParser.sonst_statement_return retval = new miniPParser.sonst_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SONST52=null;
        miniPParser.statement_return statement53 =null;


        CommonTree SONST52_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "sonst_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(83, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:83:17: ( ( SONST ^ ( statement )* )? )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:83:18: ( SONST ^ ( statement )* )?
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(83,18);
            // Z:\\AI4\\CI\\p1\\miniP.g:83:18: ( SONST ^ ( statement )* )?
            int alt15=2;
            try { dbg.enterSubRule(15);
            try { dbg.enterDecision(15, decisionCanBacktrack[15]);

            int LA15_0 = input.LA(1);

            if ( (LA15_0==SONST) ) {
                alt15=1;
            }
            } finally {dbg.exitDecision(15);}

            switch (alt15) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:83:19: SONST ^ ( statement )*
                    {
                    dbg.location(83,24);
                    SONST52=(Token)match(input,SONST,FOLLOW_SONST_in_sonst_statement778); 
                    SONST52_tree = 
                    (CommonTree)adaptor.create(SONST52)
                    ;
                    root_0 = (CommonTree)adaptor.becomeRoot(SONST52_tree, root_0);

                    dbg.location(83,26);
                    // Z:\\AI4\\CI\\p1\\miniP.g:83:26: ( statement )*
                    try { dbg.enterSubRule(14);

                    loop14:
                    do {
                        int alt14=2;
                        try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==ID||LA14_0==MULTILINE_COMMENT||LA14_0==PRINTLN||LA14_0==READ||LA14_0==SOLANGE||LA14_0==WENN) ) {
                            alt14=1;
                        }


                        } finally {dbg.exitDecision(14);}

                        switch (alt14) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // Z:\\AI4\\CI\\p1\\miniP.g:83:26: statement
                    	    {
                    	    dbg.location(83,26);
                    	    pushFollow(FOLLOW_statement_in_sonst_statement781);
                    	    statement53=statement();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, statement53.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(14);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(15);}


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
        dbg.location(83, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sonst_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "sonst_statement"


    public static class solange_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "solange_statement"
    // Z:\\AI4\\CI\\p1\\miniP.g:85:1: solange_statement : SOLANGE ^ comparison tue_statement EGNALOS !;
    public final miniPParser.solange_statement_return solange_statement() throws RecognitionException {
        miniPParser.solange_statement_return retval = new miniPParser.solange_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SOLANGE54=null;
        Token EGNALOS57=null;
        miniPParser.comparison_return comparison55 =null;

        miniPParser.tue_statement_return tue_statement56 =null;


        CommonTree SOLANGE54_tree=null;
        CommonTree EGNALOS57_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "solange_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(85, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:85:20: ( SOLANGE ^ comparison tue_statement EGNALOS !)
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:85:22: SOLANGE ^ comparison tue_statement EGNALOS !
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(85,29);
            SOLANGE54=(Token)match(input,SOLANGE,FOLLOW_SOLANGE_in_solange_statement793); 
            SOLANGE54_tree = 
            (CommonTree)adaptor.create(SOLANGE54)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(SOLANGE54_tree, root_0);

            dbg.location(85,31);
            pushFollow(FOLLOW_comparison_in_solange_statement796);
            comparison55=comparison();

            state._fsp--;

            adaptor.addChild(root_0, comparison55.getTree());
            dbg.location(85,42);
            pushFollow(FOLLOW_tue_statement_in_solange_statement798);
            tue_statement56=tue_statement();

            state._fsp--;

            adaptor.addChild(root_0, tue_statement56.getTree());
            dbg.location(85,63);
            EGNALOS57=(Token)match(input,EGNALOS,FOLLOW_EGNALOS_in_solange_statement800); 

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
        dbg.location(85, 63);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "solange_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "solange_statement"


    public static class tue_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tue_statement"
    // Z:\\AI4\\CI\\p1\\miniP.g:86:1: tue_statement : TUE ^ ( statement )* ;
    public final miniPParser.tue_statement_return tue_statement() throws RecognitionException {
        miniPParser.tue_statement_return retval = new miniPParser.tue_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token TUE58=null;
        miniPParser.statement_return statement59 =null;


        CommonTree TUE58_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "tue_statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(86, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:87:2: ( TUE ^ ( statement )* )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:87:4: TUE ^ ( statement )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(87,7);
            TUE58=(Token)match(input,TUE,FOLLOW_TUE_in_tue_statement809); 
            TUE58_tree = 
            (CommonTree)adaptor.create(TUE58)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(TUE58_tree, root_0);

            dbg.location(87,9);
            // Z:\\AI4\\CI\\p1\\miniP.g:87:9: ( statement )*
            try { dbg.enterSubRule(16);

            loop16:
            do {
                int alt16=2;
                try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                int LA16_0 = input.LA(1);

                if ( (LA16_0==ID||LA16_0==MULTILINE_COMMENT||LA16_0==PRINTLN||LA16_0==READ||LA16_0==SOLANGE||LA16_0==WENN) ) {
                    alt16=1;
                }


                } finally {dbg.exitDecision(16);}

                switch (alt16) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // Z:\\AI4\\CI\\p1\\miniP.g:87:9: statement
            	    {
            	    dbg.location(87,9);
            	    pushFollow(FOLLOW_statement_in_tue_statement812);
            	    statement59=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement59.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);
            } finally {dbg.exitSubRule(16);}


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
        dbg.location(87, 18);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "tue_statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "tue_statement"


    public static class read_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "read"
    // Z:\\AI4\\CI\\p1\\miniP.g:88:1: read : READ OPENING_BRACKET ( ID ) CLOSEING_BRACKET STATEMENT_END -> ^( READ ID ) ;
    public final miniPParser.read_return read() throws RecognitionException {
        miniPParser.read_return retval = new miniPParser.read_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token READ60=null;
        Token OPENING_BRACKET61=null;
        Token ID62=null;
        Token CLOSEING_BRACKET63=null;
        Token STATEMENT_END64=null;

        CommonTree READ60_tree=null;
        CommonTree OPENING_BRACKET61_tree=null;
        CommonTree ID62_tree=null;
        CommonTree CLOSEING_BRACKET63_tree=null;
        CommonTree STATEMENT_END64_tree=null;
        RewriteRuleTokenStream stream_OPENING_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPENING_BRACKET");
        RewriteRuleTokenStream stream_STATEMENT_END=new RewriteRuleTokenStream(adaptor,"token STATEMENT_END");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_CLOSEING_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSEING_BRACKET");
        RewriteRuleTokenStream stream_READ=new RewriteRuleTokenStream(adaptor,"token READ");

        try { dbg.enterRule(getGrammarFileName(), "read");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(88, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:88:6: ( READ OPENING_BRACKET ( ID ) CLOSEING_BRACKET STATEMENT_END -> ^( READ ID ) )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:88:8: READ OPENING_BRACKET ( ID ) CLOSEING_BRACKET STATEMENT_END
            {
            dbg.location(88,8);
            READ60=(Token)match(input,READ,FOLLOW_READ_in_read820);  
            stream_READ.add(READ60);

            dbg.location(88,13);
            OPENING_BRACKET61=(Token)match(input,OPENING_BRACKET,FOLLOW_OPENING_BRACKET_in_read822);  
            stream_OPENING_BRACKET.add(OPENING_BRACKET61);

            dbg.location(88,29);
            // Z:\\AI4\\CI\\p1\\miniP.g:88:29: ( ID )
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:88:30: ID
            {
            dbg.location(88,30);
            ID62=(Token)match(input,ID,FOLLOW_ID_in_read825);  
            stream_ID.add(ID62);


            }

            dbg.location(88,34);
            CLOSEING_BRACKET63=(Token)match(input,CLOSEING_BRACKET,FOLLOW_CLOSEING_BRACKET_in_read828);  
            stream_CLOSEING_BRACKET.add(CLOSEING_BRACKET63);

            dbg.location(88,51);
            STATEMENT_END64=(Token)match(input,STATEMENT_END,FOLLOW_STATEMENT_END_in_read830);  
            stream_STATEMENT_END.add(STATEMENT_END64);


            // AST REWRITE
            // elements: READ, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 88:65: -> ^( READ ID )
            {
                dbg.location(88,68);
                // Z:\\AI4\\CI\\p1\\miniP.g:88:68: ^( READ ID )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(88,70);
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_READ.nextNode()
                , root_1);

                dbg.location(88,75);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

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
        dbg.location(88, 78);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "read");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "read"


    public static class println_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "println"
    // Z:\\AI4\\CI\\p1\\miniP.g:89:1: println : PRINTLN ^ OPENING_BRACKET ! ( ID | constants ) CLOSEING_BRACKET ! STATEMENT_END !;
    public final miniPParser.println_return println() throws RecognitionException {
        miniPParser.println_return retval = new miniPParser.println_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PRINTLN65=null;
        Token OPENING_BRACKET66=null;
        Token ID67=null;
        Token CLOSEING_BRACKET69=null;
        Token STATEMENT_END70=null;
        miniPParser.constants_return constants68 =null;


        CommonTree PRINTLN65_tree=null;
        CommonTree OPENING_BRACKET66_tree=null;
        CommonTree ID67_tree=null;
        CommonTree CLOSEING_BRACKET69_tree=null;
        CommonTree STATEMENT_END70_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "println");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(89, 0);

        try {
            // Z:\\AI4\\CI\\p1\\miniP.g:89:9: ( PRINTLN ^ OPENING_BRACKET ! ( ID | constants ) CLOSEING_BRACKET ! STATEMENT_END !)
            dbg.enterAlt(1);

            // Z:\\AI4\\CI\\p1\\miniP.g:89:11: PRINTLN ^ OPENING_BRACKET ! ( ID | constants ) CLOSEING_BRACKET ! STATEMENT_END !
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(89,18);
            PRINTLN65=(Token)match(input,PRINTLN,FOLLOW_PRINTLN_in_println846); 
            PRINTLN65_tree = 
            (CommonTree)adaptor.create(PRINTLN65)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(PRINTLN65_tree, root_0);

            dbg.location(89,35);
            OPENING_BRACKET66=(Token)match(input,OPENING_BRACKET,FOLLOW_OPENING_BRACKET_in_println849); 
            dbg.location(89,37);
            // Z:\\AI4\\CI\\p1\\miniP.g:89:37: ( ID | constants )
            int alt17=2;
            try { dbg.enterSubRule(17);
            try { dbg.enterDecision(17, decisionCanBacktrack[17]);

            int LA17_0 = input.LA(1);

            if ( (LA17_0==ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==FLOAT_CONST||LA17_0==INT_CONST||LA17_0==STRING_CONST||(LA17_0 >= 41 && LA17_0 <= 42)) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(17);}

            switch (alt17) {
                case 1 :
                    dbg.enterAlt(1);

                    // Z:\\AI4\\CI\\p1\\miniP.g:89:38: ID
                    {
                    dbg.location(89,38);
                    ID67=(Token)match(input,ID,FOLLOW_ID_in_println853); 
                    ID67_tree = 
                    (CommonTree)adaptor.create(ID67)
                    ;
                    adaptor.addChild(root_0, ID67_tree);


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // Z:\\AI4\\CI\\p1\\miniP.g:89:41: constants
                    {
                    dbg.location(89,41);
                    pushFollow(FOLLOW_constants_in_println855);
                    constants68=constants();

                    state._fsp--;

                    adaptor.addChild(root_0, constants68.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(17);}

            dbg.location(89,68);
            CLOSEING_BRACKET69=(Token)match(input,CLOSEING_BRACKET,FOLLOW_CLOSEING_BRACKET_in_println858); 
            dbg.location(89,83);
            STATEMENT_END70=(Token)match(input,STATEMENT_END,FOLLOW_STATEMENT_END_in_println861); 

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
        dbg.location(89, 84);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "println");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "println"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAMM_in_start465 = new BitSet(new long[]{0x00000020000480A0L});
    public static final BitSet FOLLOW_init_in_start467 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_BEGIN_in_start469 = new BitSet(new long[]{0x0000008128810000L});
    public static final BitSet FOLLOW_body_in_start471 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_END_in_start473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_init489 = new BitSet(new long[]{0x0000002000048082L});
    public static final BitSet FOLLOW_statement_in_body506 = new BitSet(new long[]{0x0000008128810002L});
    public static final BitSet FOLLOW_var_typ_in_declaration524 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_declaration527 = new BitSet(new long[]{0x0000000880000000L});
    public static final BitSet FOLLOW_SEPERATOR_in_declaration530 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_declaration533 = new BitSet(new long[]{0x0000000880000000L});
    public static final BitSet FOLLOW_STATEMENT_END_in_declaration537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wenn_statement_in_statement573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_solange_statement_in_statement576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_statement580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_println_in_statement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTILINE_COMMENT_in_statement589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignment599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ASSIGNING_OP_in_assignment601 = new BitSet(new long[]{0x0000061002094000L});
    public static final BitSet FOLLOW_possible_assignments_in_assignment603 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_STATEMENT_END_in_assignment605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arithmetic_expression_in_possible_assignments622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_possible_assignments624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_CONST_in_possible_assignments626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_arithmetic_expression636 = new BitSet(new long[]{0x0000000004200002L});
    public static final BitSet FOLLOW_PLUS_in_arithmetic_expression641 = new BitSet(new long[]{0x0000000002094000L});
    public static final BitSet FOLLOW_MINUS_in_arithmetic_expression646 = new BitSet(new long[]{0x0000000002094000L});
    public static final BitSet FOLLOW_term_in_arithmetic_expression651 = new BitSet(new long[]{0x0000000004200002L});
    public static final BitSet FOLLOW_factor_in_term661 = new BitSet(new long[]{0x0000000000400802L});
    public static final BitSet FOLLOW_DIV_in_term666 = new BitSet(new long[]{0x0000000002094000L});
    public static final BitSet FOLLOW_MUL_in_term671 = new BitSet(new long[]{0x0000000002094000L});
    public static final BitSet FOLLOW_factor_in_term676 = new BitSet(new long[]{0x0000000000400802L});
    public static final BitSet FOLLOW_set_in_factor689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPENING_BRACKET_in_factor701 = new BitSet(new long[]{0x0000000002094000L});
    public static final BitSet FOLLOW_arithmetic_expression_in_factor704 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSEING_BRACKET_in_factor706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_comparison720 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_constants_in_comparison722 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RELOP_in_comparison725 = new BitSet(new long[]{0x0000061000094000L});
    public static final BitSet FOLLOW_ID_in_comparison729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constants_in_comparison731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WENN_in_wenn_statement740 = new BitSet(new long[]{0x0000061000094000L});
    public static final BitSet FOLLOW_comparison_in_wenn_statement742 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dann_statement_in_wenn_statement744 = new BitSet(new long[]{0x0000000201000000L});
    public static final BitSet FOLLOW_sonst_statement_in_wenn_statement746 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_NNEW_in_wenn_statement748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DANN_in_dann_statement767 = new BitSet(new long[]{0x0000008128810002L});
    public static final BitSet FOLLOW_statement_in_dann_statement770 = new BitSet(new long[]{0x0000008128810002L});
    public static final BitSet FOLLOW_SONST_in_sonst_statement778 = new BitSet(new long[]{0x0000008128810002L});
    public static final BitSet FOLLOW_statement_in_sonst_statement781 = new BitSet(new long[]{0x0000008128810002L});
    public static final BitSet FOLLOW_SOLANGE_in_solange_statement793 = new BitSet(new long[]{0x0000061000094000L});
    public static final BitSet FOLLOW_comparison_in_solange_statement796 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_tue_statement_in_solange_statement798 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_EGNALOS_in_solange_statement800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUE_in_tue_statement809 = new BitSet(new long[]{0x0000008128810002L});
    public static final BitSet FOLLOW_statement_in_tue_statement812 = new BitSet(new long[]{0x0000008128810002L});
    public static final BitSet FOLLOW_READ_in_read820 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_OPENING_BRACKET_in_read822 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_read825 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSEING_BRACKET_in_read828 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_STATEMENT_END_in_read830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINTLN_in_println846 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_OPENING_BRACKET_in_println849 = new BitSet(new long[]{0x0000061000094000L});
    public static final BitSet FOLLOW_ID_in_println853 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_constants_in_println855 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_CLOSEING_BRACKET_in_println858 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_STATEMENT_END_in_println861 = new BitSet(new long[]{0x0000000000000002L});

}