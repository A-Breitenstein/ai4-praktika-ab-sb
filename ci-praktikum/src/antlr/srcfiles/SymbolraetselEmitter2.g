tree grammar SymbolraetselEmitter2;

options {
  tokenVocab   = artihmetic_puzzle;
  output       = template;
  ASTLabelType = CommonTree;
}

@header {
	import java.math.BigInteger;
	import antlr.srcfiles.Number;
	
	import choco.Choco;
	import choco.Options;
	import choco.cp.model.CPModel;
	import choco.cp.solver.CPSolver;
	import choco.kernel.model.Model;
	import choco.kernel.model.variables.integer.IntegerExpressionVariable;
	import choco.kernel.model.variables.integer.IntegerVariable;
	import choco.kernel.solver.Solver;

	import java.util.*;
}

@members {
    Map<String,IntegerVariable>  integerVariableMap = new HashMapt<String,IntegerVariable>();
    List<List<Number>> numbersBaum = new ArrayList<List<Number>>();
    int operationCounter = 0;
	
	void putIntegerVariablesInMap(Number number){
		for (Character c : number.getCharacters()) {
	            if (c != null) {
	            	if(integerVariableMap.get(String.valueOf(c) == null)
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
		return numbersBaum;
	}
	
	
    private  int operationCounter = 0;
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
            codeString.add("IntegerVariable "+name+" = Choco.makeIntVar("+name+", 0, 1);");
//            uebertraege.add(Choco.makeIntVar("c" + operationCounter + "uebertrag" + i, 0, 1));
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
	

}

puzzle
@after
  {
  	System.out.println(integerVars);
  	System.out.println(numbersBaum);
  }
  :
  ^(RAETSEL constraints+=constraint*)
  -> sums(sums={$constraints},vars={getVars()},allDifferentString={getAllDifferentString()},constraintNetzListe={createConstraintNetz()})
  ;

constraint
@after {
Constraint constraint = new Constraint();
constraint.numbers.add($n1.number);
constraint.numbers.add($n2.number);
constraint.numbers.add($n3.number);
constraint.prepare();
sammelAllesAuf($n1.number,$n2.number,$n3.number);
}
  :  ^(PLUS n1=number n2=number n3=number) -> sum(number1={$n1.number}, number2={$n2.number}, number3={$n3.number}) ;

number returns [Number number]
@after {
$number = new Number();
$number.setDigits($syms);
}
  :
  ^(ZAHL syms+=LETTER+)
  ;
