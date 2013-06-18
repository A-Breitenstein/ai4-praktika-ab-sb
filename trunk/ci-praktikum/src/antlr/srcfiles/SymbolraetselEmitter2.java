package antlr.srcfiles;// $ANTLR 3.4 Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g 2013-06-18 13:24:22


	import choco.Choco;
	import choco.Options;
	import choco.cp.model.CPModel;
	import choco.cp.solver.CPSolver;
	import choco.kernel.model.Model;
	import choco.kernel.model.variables.integer.IntegerExpressionVariable;
	import choco.kernel.model.variables.integer.IntegerVariable;
	import choco.kernel.solver.Solver;
	import antlr.srcfiles.Number;
	import java.util.*;
	import org.antlr.runtime.BitSet;
   	import org.antlr.runtime.tree.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class SymbolraetselEmitter2 extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ERGEBNIS", "GLEICH", "HORIZONTAL", "HVOPERATIONS", "LETTER", "MINUS", "OPERAND1", "OPERAND2", "PLUS", "RAETSEL", "START", "VERTIKAL", "ZAHL", "'+'", "','", "'-'", "'['", "'].'", "']H['", "']V['"
    };

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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public SymbolraetselEmitter2(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public SymbolraetselEmitter2(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected StringTemplateGroup templateLib =
  new StringTemplateGroup("SymbolraetselEmitter2Templates", AngleBracketTemplateLexer.class);

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
    public String[] getTokenNames() { return SymbolraetselEmitter2.tokenNames; }
    public String getGrammarFileName() { return "Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g"; }


        Map<String,IntegerVariable>  integerVariableMap = new HashMap<String,IntegerVariable>();
        List<List<Number>> numbersBaum = new ArrayList<List<Number>>();
        int operationCounter = 0;
    	
    	void putIntegerVariablesInMap(Number number){
    		for (Character c : number.getCharacters()) {
    	            if (c != null) {
    	            	if(integerVariableMap.get(String.valueOf(c)) == null)
    		                integerVariableMap.put(String.valueOf(c),Choco.makeIntVar(String.valueOf(c), 0, 9, String.valueOf(Options.V_ENUM)));
    	            }
    	        }
    	}
    	void sammelAllesAuf(Number number1,Number number2,Number number3){
    	
    		putIntegerVariablesInMap(number1);
    		putIntegerVariablesInMap(number2);
    		putIntegerVariablesInMap(number3);
    	        
    	        numbersBaum.add(new ArrayList<Number>(Arrays.asList(number1,number2,number3)));
            }
    	List<String> getVars(){
    		return new ArrayList<String>(integerVariableMap.keySet());
    	}
    	String getAllDifferentString(){
    		
    		String tmp ="";
    	        for (String c : getVars()) {
            	    tmp+=c+",";            
    	        }
            	return tmp.substring(0,tmp.length()-1);
    	}
        	List<String> createConstraintNetz(){
                List<String> codeStringListe = new ArrayList<String>();
                for (List<Number> numbers : numbersBaum) {
                    codeStringListe.addAll(addOperationSpaltenweise(numbers.get(0).toString(),numbers.get(1).toString(),numbers.get(2).toString()));
                }
        		return codeStringListe;
        	}
    	
        public List<String> addOperationSpaltenweise(String op1, String op2, String result) {
            List<String> codeString = new ArrayList<String>();

            operationCounter++;

            List<IntegerVariable> iv_op1_List = new ArrayList<IntegerVariable>();
            List<IntegerVariable> iv_op2_List = new ArrayList<IntegerVariable>();
            List<IntegerVariable> iv_result_List = new ArrayList<IntegerVariable>();

            for (char c : op1.toCharArray()) {
                iv_op1_List.add(integerVariableMap.get(String.valueOf(c)));
            }

            for (char c : op2.toCharArray()) {
                iv_op2_List.add(integerVariableMap.get(String.valueOf(c)));
            }

            for (char c : result.toCharArray()) {
                iv_result_List.add(integerVariableMap.get(String.valueOf(c)));
            }

            ListIterator<IntegerVariable> op1IT = iv_op1_List.listIterator(iv_op1_List.size());
            ListIterator<IntegerVariable> op2IT = iv_op2_List.listIterator(iv_op2_List.size());
            ListIterator<IntegerVariable> resultIT = iv_result_List.listIterator(iv_result_List.size());

            List<IntegerVariable> uebertraege = new ArrayList<IntegerVariable>();

            String name;
            for (int i = 0; i < iv_result_List.size(); i++) {
                name = "c" + operationCounter + "uebertrag" + i;
                codeString.add("IntegerVariable "+name+" = Choco.makeIntVar(\""+name+"\", 0, 1);");
                uebertraege.add(Choco.makeIntVar(name, 0, 1));
            }

            int indexOfUbertrag = 0;

    //        model.addConstraint(Choco.eq(Choco.plus(op1IT.previous(), op2IT.previous()), Choco.plus(resultIT.previous(), Choco.mult(uebertraege.get(indexOfUbertrag), 10))));
            codeString.add("model.addConstraint(Choco.eq(Choco.plus("+op1IT.previous().getName()+","+op2IT.previous().getName()+"), Choco.plus("+resultIT.previous().getName()+", Choco.mult("+uebertraege.get(indexOfUbertrag).getName()+", 10))));");

            indexOfUbertrag++;
            IntegerVariable resultVar, op1Var = null, op2Var = null;
            boolean op1HasPrevious, op2HasPrevious;
            while (resultIT.hasPrevious()) {

                resultVar = resultIT.previous();

                if (op1IT.hasPrevious()) {
                    op1Var = op1IT.previous();
                    op1HasPrevious = true;
                } else {
                    op1HasPrevious = false;
                }

                if (op2IT.hasPrevious()) {
                    op2Var = op2IT.previous();
                    op2HasPrevious = true;
                } else {
                    op2HasPrevious = false;
                }


                if (op1HasPrevious && op2HasPrevious) {
                    if (resultIT.hasPrevious()) {
    //                    model.addConstraint(Choco.eq(Choco.plus(Choco.plus(op1Var, op2Var), uebertraege.get(indexOfUbertrag - 1)), Choco.plus(resultVar, Choco.mult(uebertraege.get(indexOfUbertrag), 10))));
                        codeString.add("model.addConstraint(Choco.eq(Choco.plus(Choco.plus("+op1Var.getName()+","+ op2Var.getName()+"), "+uebertraege.get(indexOfUbertrag - 1).getName()+"), Choco.plus("+resultVar.getName()+", Choco.mult("+uebertraege.get(indexOfUbertrag).getName()+", 10))));");
                    } else {
    //                    model.addConstraint(Choco.eq(Choco.plus(Choco.plus(op1Var, op2Var), uebertraege.get(indexOfUbertrag - 1)), resultVar));
                        codeString.add("model.addConstraint(Choco.eq(Choco.plus(Choco.plus("+op1Var.getName()+","+ op2Var.getName()+"),"+ uebertraege.get(indexOfUbertrag - 1).getName()+"),"+ resultVar.getName()+"));");
                    }
                } else if (op1HasPrevious && !op2HasPrevious) {
    //                model.addConstraint(Choco.eq(Choco.plus(op1Var, uebertraege.get(indexOfUbertrag - 1)), Choco.plus(resultVar, Choco.mult(uebertraege.get(indexOfUbertrag), 10))));
                    codeString.add("model.addConstraint(Choco.eq(Choco.plus("+op1Var.getName()+", "+uebertraege.get(indexOfUbertrag - 1).getName()+"), Choco.plus("+resultVar.getName()+", Choco.mult("+uebertraege.get(indexOfUbertrag).getName()+", 10))));");
                } else if (!op1HasPrevious && op2HasPrevious) {
    //                model.addConstraint(Choco.eq(Choco.plus(op2Var, uebertraege.get(indexOfUbertrag - 1)), Choco.plus(resultVar, Choco.mult(uebertraege.get(indexOfUbertrag), 10))));
                    codeString.add("model.addConstraint(Choco.eq(Choco.plus("+op2Var.getName()+", "+uebertraege.get(indexOfUbertrag - 1).getName()+"), Choco.plus("+resultVar.getName()+", Choco.mult("+uebertraege.get(indexOfUbertrag).getName()+", 10))));");
                } else {
                    codeString.add("model.addConstraint(Choco.eq("+resultVar.getName()+", "+uebertraege.get(indexOfUbertrag - 1).getName()+"));");
                }

                indexOfUbertrag++;
            }
            return codeString; 
        }
        List<String> getOutputString(){
        	List<String> output = new ArrayList<String>();
                for (List<Number> numbers : numbersBaum) {
                   output.add("System.out.println("+wort(numbers.get(0).toString()) + " \" + \"+"+wort(numbers.get(1).toString())  + "\" = \"+"+ wort(numbers.get(2).toString())+"\"\");"); 
                }
            return output;
        }
        String wort(String s) {
            String out= "";
            for (Character c : s.toCharArray()) {
                out+= "String.valueOf(solver.getVar("+c+").getVal())+";
            }
            return out;
        }



    public static class puzzle_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "puzzle"
    // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:165:1: puzzle : ^( RAETSEL (constraints+= constraint )* ) -> createTemplate(vars=getVars()allDifferentString=getAllDifferentString()constraintNetzListe=createConstraintNetz()outputString=getOutputString());
    public final puzzle_return puzzle() throws RecognitionException {
        puzzle_return retval = new puzzle_return();
        retval.start = input.LT(1);


        List list_constraints=null;
        RuleReturnScope constraints = null;
        try {
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:171:3: ( ^( RAETSEL (constraints+= constraint )* ) -> createTemplate(vars=getVars()allDifferentString=getAllDifferentString()constraintNetzListe=createConstraintNetz()outputString=getOutputString()))
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:172:3: ^( RAETSEL (constraints+= constraint )* )
            {
            match(input,RAETSEL,FOLLOW_RAETSEL_in_puzzle76); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:172:24: (constraints+= constraint )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==PLUS) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:172:24: constraints+= constraint
                	    {
                	    pushFollow(FOLLOW_constraint_in_puzzle80);
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
            // 173:3: -> createTemplate(vars=getVars()allDifferentString=getAllDifferentString()constraintNetzListe=createConstraintNetz()outputString=getOutputString())
            {
                retval.st = templateLib.getInstanceOf("createTemplate",new STAttrMap().put("vars", getVars()).put("allDifferentString", getAllDifferentString()).put("constraintNetzListe", createConstraintNetz()).put("outputString", getOutputString()));
            }



            }


              	System.out.println(integerVariableMap);
              	System.out.println(numbersBaum);
              
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
    // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:176:1: constraint : ^( PLUS n1= number n2= number n3= number ) ;
    public final constraint_return constraint() throws RecognitionException {
        constraint_return retval = new constraint_return();
        retval.start = input.LT(1);


        number_return n1 =null;

        number_return n2 =null;

        number_return n3 =null;


        try {
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:180:3: ( ^( PLUS n1= number n2= number n3= number ) )
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:180:6: ^( PLUS n1= number n2= number n3= number )
            {
            match(input,PLUS,FOLLOW_PLUS_in_constraint125); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_number_in_constraint129);
            n1=number();

            state._fsp--;


            pushFollow(FOLLOW_number_in_constraint133);
            n2=number();

            state._fsp--;


            pushFollow(FOLLOW_number_in_constraint137);
            n3=number();

            state._fsp--;


            match(input, Token.UP, null); 


            }


            sammelAllesAuf((n1!=null?n1.number:null),(n2!=null?n2.number:null),(n3!=null?n3.number:null));

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
    // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:182:1: number returns [Number number] : ^( ZAHL (syms+= LETTER )+ ) ;
    public final number_return number() throws RecognitionException {
        number_return retval = new number_return();
        retval.start = input.LT(1);


        CommonTree syms=null;
        List list_syms=null;

        try {
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:187:3: ( ^( ZAHL (syms+= LETTER )+ ) )
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:188:3: ^( ZAHL (syms+= LETTER )+ )
            {
            match(input,ZAHL,FOLLOW_ZAHL_in_number160); 

            match(input, Token.DOWN, null); 
            // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:188:14: (syms+= LETTER )+
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
            	    // Z:\\BAI-4\\CI\\SymbolraetselEmitter2.g:188:14: syms+= LETTER
            	    {
            	    syms=(CommonTree)match(input,LETTER,FOLLOW_LETTER_in_number164); 
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


 

    public static final BitSet FOLLOW_RAETSEL_in_puzzle76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_constraint_in_puzzle80 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_PLUS_in_constraint125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_number_in_constraint129 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_number_in_constraint133 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_number_in_constraint137 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ZAHL_in_number160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LETTER_in_number164 = new BitSet(new long[]{0x0000000000000108L});

}