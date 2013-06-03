package antlr.srcfiles;// $ANTLR 3.4 Z:\\BAI-4\\CI\\SymbolraetselEmitter.g 2013-06-03 19:10:21

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
import antlr.srcfiles.Number;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class SymbolraetselEmitter extends TreeParser {
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


    public SymbolraetselEmitter(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public SymbolraetselEmitter(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected StringTemplateGroup templateLib =
  new StringTemplateGroup("SymbolraetselEmitterTemplates", AngleBracketTemplateLexer.class);

public void setTemplateLib(StringTemplateGroup templateLib) {
  this.templateLib = templateLib;
}
public StringTemplateGroup getTemplateLib() {
  return templateLib;
}
/** allows convenient multi-value initialization:
 *  "new STAttrMap().put(...).put(...)"
 */
public static class STAttrMap extends HashMap {
  public STAttrMap put(String attrName, Object value) {
    super.put(attrName, value);
    return this;
  }
  public STAttrMap put(String attrName, int value) {
    super.put(attrName, new Integer(value));
    return this;
  }
}
    public String[] getTokenNames() { return SymbolraetselEmitter.tokenNames; }
    public String getGrammarFileName() { return "Z:\\BAI-4\\CI\\SymbolraetselEmitter.g"; }


    public static class puzzle_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "puzzle"
    // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:9:1: puzzle : ^( RAETSEL (constraints+= constraint )* ) -> sums(sums=$constraints);
    public final puzzle_return puzzle() throws RecognitionException {
        puzzle_return retval = new puzzle_return();
        retval.start = input.LT(1);


        List list_constraints=null;
        RuleReturnScope constraints = null;
        try {
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:10:3: ( ^( RAETSEL (constraints+= constraint )* ) -> sums(sums=$constraints))
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:11:3: ^( RAETSEL (constraints+= constraint )* )
            {
            match(input,RAETSEL,FOLLOW_RAETSEL_in_puzzle57); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:11:24: (constraints+= constraint )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==PLUS) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:11:24: constraints+= constraint
                	    {
                	    pushFollow(FOLLOW_constraint_in_puzzle61);
                	    constraints=constraint();

                	    state._fsp--;

                	    if (list_constraints==null) list_constraints=new ArrayList();
                	    list_constraints.add(constraints.getTemplate());


                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            // TEMPLATE REWRITE
            // 12:3: -> sums(sums=$constraints)
            {
                retval.st = templateLib.getInstanceOf("sums",new STAttrMap().put("sums", list_constraints));
            }



            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "puzzle"


    public static class constraint_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "constraint"
    // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:15:1: constraint : ^( PLUS n1= number n2= number n3= number ) -> sum(number1=$n1.numbernumber2=$n2.numbernumber3=$n3.number);
    public final constraint_return constraint() throws RecognitionException {
        constraint_return retval = new constraint_return();
        retval.start = input.LT(1);


        number_return n1 =null;

        number_return n2 =null;

        number_return n3 =null;


        try {
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:23:3: ( ^( PLUS n1= number n2= number n3= number ) -> sum(number1=$n1.numbernumber2=$n2.numbernumber3=$n3.number))
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:23:6: ^( PLUS n1= number n2= number n3= number )
            {
            match(input,PLUS,FOLLOW_PLUS_in_constraint94); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_number_in_constraint98);
            n1=number();

            state._fsp--;


            pushFollow(FOLLOW_number_in_constraint102);
            n2=number();

            state._fsp--;


            pushFollow(FOLLOW_number_in_constraint106);
            n3=number();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 23:44: -> sum(number1=$n1.numbernumber2=$n2.numbernumber3=$n3.number)
            {
                retval.st = templateLib.getInstanceOf("sum",new STAttrMap().put("number1", (n1!=null?n1.number:null)).put("number2", (n2!=null?n2.number:null)).put("number3", (n3!=null?n3.number:null)));
            }



            }


            Constraint constraint = new Constraint();
            constraint.numbers.add((n1!=null?n1.number:null));
            constraint.numbers.add((n2!=null?n2.number:null));
            constraint.numbers.add((n3!=null?n3.number:null));
            constraint.prepare();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constraint"


    public static class number_return extends TreeRuleReturnScope {
        public Number number;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "number"
    // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:25:1: number returns [Number number] : ^( ZAHL (syms+= LETTER )+ ) ;
    public final number_return number() throws RecognitionException {
        number_return retval = new number_return();
        retval.start = input.LT(1);


        CommonTree syms=null;
        List list_syms=null;

        try {
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:30:3: ( ^( ZAHL (syms+= LETTER )+ ) )
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:31:3: ^( ZAHL (syms+= LETTER )+ )
            {
            match(input,ZAHL,FOLLOW_ZAHL_in_number149); 

            match(input, Token.DOWN, null); 
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:31:14: (syms+= LETTER )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==LETTER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Z:\\BAI-4\\CI\\SymbolraetselEmitter.g:31:14: syms+= LETTER
            	    {
            	    syms=(CommonTree)match(input,LETTER,FOLLOW_LETTER_in_number153); 
            	    if (list_syms==null) list_syms=new ArrayList();
            	    list_syms.add(syms);


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            match(input, Token.UP, null); 


            }


            retval.number = new Number();
            retval.number.setDigits(list_syms);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "number"

    // Delegated rules


 

    public static final BitSet FOLLOW_RAETSEL_in_puzzle57 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_in_puzzle61 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_PLUS_in_constraint94 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_number_in_constraint98 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_number_in_constraint102 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_number_in_constraint106 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ZAHL_in_number149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LETTER_in_number153 = new BitSet(new long[]{0x0000000000000108L});

}