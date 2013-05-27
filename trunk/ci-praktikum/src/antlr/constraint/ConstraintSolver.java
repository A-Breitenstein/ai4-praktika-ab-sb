package antlr.constraint;

import antlr.srcfiles.__Test__;
import choco.Choco;
import choco.Options;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.Solver;

import java.util.*;

import static choco.Choco.neq;

/**
 * User: Alex
 * Date: 25.05.13
 * Time: 06:38
 */
public class ConstraintSolver {

    static IntegerVariable A = Choco.makeIntVar("A", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable B = Choco.makeIntVar("B", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable C = Choco.makeIntVar("C", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable D = Choco.makeIntVar("D", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable E = Choco.makeIntVar("E", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable F = Choco.makeIntVar("F", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable G = Choco.makeIntVar("G", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable H = Choco.makeIntVar("H", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable I = Choco.makeIntVar("I", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable J = Choco.makeIntVar("J", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable K = Choco.makeIntVar("K", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable L = Choco.makeIntVar("L", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable M = Choco.makeIntVar("M", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable N = Choco.makeIntVar("N", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable O = Choco.makeIntVar("O", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable P = Choco.makeIntVar("P", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable Q = Choco.makeIntVar("Q", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable R = Choco.makeIntVar("R", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable S = Choco.makeIntVar("S", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable T = Choco.makeIntVar("T", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable U = Choco.makeIntVar("U", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable V = Choco.makeIntVar("V", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable W = Choco.makeIntVar("W", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable X = Choco.makeIntVar("X", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable Y = Choco.makeIntVar("Y", 0, 9, String.valueOf(Options.V_ENUM));
    static IntegerVariable Z = Choco.makeIntVar("Z", 0, 9, String.valueOf(Options.V_ENUM));


    static Map<String, IntegerVariable> integerVariableMap;

    static {
        integerVariableMap = new HashMap<String, IntegerVariable>();
        integerVariableMap.put("A", A);
        integerVariableMap.put("B", B);
        integerVariableMap.put("C", C);
        integerVariableMap.put("D", D);
        integerVariableMap.put("E", E);
        integerVariableMap.put("F", F);
        integerVariableMap.put("G", G);
        integerVariableMap.put("H", H);
        integerVariableMap.put("I", I);
        integerVariableMap.put("J", J);
        integerVariableMap.put("K", K);
        integerVariableMap.put("L", L);
        integerVariableMap.put("M", M);
        integerVariableMap.put("N", N);
        integerVariableMap.put("O", O);
        integerVariableMap.put("P", P);
        integerVariableMap.put("Q", Q);
        integerVariableMap.put("R", R);
        integerVariableMap.put("S", S);
        integerVariableMap.put("T", T);
        integerVariableMap.put("U", U);
        integerVariableMap.put("V", V);
        integerVariableMap.put("W", W);
        integerVariableMap.put("X", X);
        integerVariableMap.put("Y", Y);
        integerVariableMap.put("Z", Z);
    }

    private Model model;

    public ConstraintSolver() {
        model = new CPModel();;
    }

    public void addOperation(String op1, String op2, String result) {
        int uppB_op1 = (int) Math.pow(10d, op1.length()),
                uppB_op2 = (int) Math.pow(10d, op2.length()),
                uppB_result = (int) Math.pow(10d, result.length());

        IntegerVariable iv_op1 = Choco.makeIntVar(op1, 0, uppB_op1, Options.V_BOUND);
        IntegerVariable iv_op2 = Choco.makeIntVar(op2, 0, uppB_op2, Options.V_BOUND);
        IntegerVariable iv_result = Choco.makeIntVar(result, 0, uppB_result, Options.V_BOUND);

        Set<IntegerVariable> integerVariableSet = new HashSet<IntegerVariable>();

        IntegerVariable iv_array_op1[];
        IntegerVariable iv_array_op2[];
        IntegerVariable iv_array_result[];

        iv_array_op1 = new IntegerVariable[op1.length()];

        String key;
        IntegerVariable variable;
        for (int i = 0; i < op1.length(); i++) {
            key = String.valueOf(op1.charAt(i));
            variable = integerVariableMap.get(key);

            iv_array_op1[i] = variable;

            integerVariableSet.add(variable);
        }

        iv_array_op2 = new IntegerVariable[op2.length()];

        for (int i = 0; i < op2.length(); i++) {
            key = String.valueOf(op2.charAt(i));
            variable = integerVariableMap.get(key);

            iv_array_op2[i] = variable;

            integerVariableSet.add(variable);
        }

        iv_array_result = new IntegerVariable[result.length()];

        for (int i = 0; i < result.length(); i++) {
            key = String.valueOf(result.charAt(i));
            variable = integerVariableMap.get(key);

            iv_array_result[i] = variable;

            integerVariableSet.add(variable);
        }

        int[] coefficients_op1 = new int[op1.length()];
        int[] coefficients_op2 = new int[op2.length()];
        int[] coefficients_result = new int[result.length()];

        uppB_op1 *= 0.1;
        uppB_op2 *= 0.1;
        uppB_result *= 0.1;

        for (int i = 0; i < coefficients_op1.length; i++) {
            coefficients_op1[i] = uppB_op1;
            uppB_op1 *= 0.1;
        }

        for (int i = 0; i < coefficients_op2.length; i++) {
            coefficients_op2[i] = uppB_op2;
            uppB_op2 *= 0.1;
        }

        for (int i = 0; i < coefficients_result.length; i++) {
            coefficients_result[i] = uppB_result;
            uppB_result *= 0.1;
        }

        IntegerExpressionVariable letters_op1 = Choco.scalar(iv_array_op1, coefficients_op1);
        IntegerExpressionVariable letters_op2 = Choco.scalar(iv_array_op2, coefficients_op2);
        IntegerExpressionVariable letters_result = Choco.scalar(iv_array_result, coefficients_result);

//        Erstes zeichen darf nicht 0 sein
        model.addConstraints(neq(integerVariableMap.get(op1.substring(0, 1)), 0));
        model.addConstraints(neq(integerVariableMap.get(op2.substring(0, 1)), 0));
        model.addConstraints(neq(integerVariableMap.get(result.substring(0, 1)), 0));

        model.addConstraint(Choco.eq(letters_op1, iv_op1));
        model.addConstraint(Choco.eq(letters_op2, iv_op2));
        model.addConstraint(Choco.eq(letters_result, iv_result));

//        System.out.println("added: "+op1);
//        System.out.println("added: "+op2);
//        System.out.println("added: "+result);


//        for (IntegerVariable integerVariable : integerVariableSet) {
//            model.addConstraint(Choco.eq(Choco.scalar(new IntegerVariable[]{integerVariable},new int[]{1}),integerVariable));
//        }

//        for (int i = result.length()-1; i > 0; i--) {
//            model.addConstraint(Choco.eq(
//                    Choco.plus(integerVariableMap.get(String.valueOf(op1.charAt(i))),
//                               integerVariableMap.get(String.valueOf(op2.charAt(i)))),
//                    integerVariableMap.get(String.valueOf(result.charAt(i)))));
//        }

        model.addConstraint(Choco.eq(Choco.plus(iv_op1, iv_op2), iv_result));

        model.addConstraint(Choco.allDifferent(integerVariableSet.toArray(new IntegerVariable[]{})));


//        for (Map.Entry<String, IntegerVariable> stringIntegerVariableEntry : integerVariableMap.entrySet()) {
//            if(solver.getVar(stringIntegerVariableEntry.getValue()) != null)
//                System.out.println(stringIntegerVariableEntry.getKey()+": "+solver.getVar(stringIntegerVariableEntry.getValue()).getVal());
//        }
    }

    public void solveModel() {
        Solver solver = new CPSolver();
        solver.read(model);
        solver.solve();
        // das alles nach oben?????^

        Iterator<IntegerVariable> integerVariableIterator = model.getIntVarIterator();
        IntegerVariable integerVariable;
        String varname;
        Set<String> stringSet = new HashSet<String>();
        while (integerVariableIterator.hasNext()) {
            integerVariable = integerVariableIterator.next();
            varname = integerVariable.getName();
            if (__Test__.tokenMap.containsKey(varname) && !stringSet.contains(varname)) {
                System.out.println(varname+": "+solver.getVar(integerVariable).getVal());
                stringSet.add(varname);
            }
        }
    }


    public static void main(String[] args) {
//        for (char buchstabe = 'A'; buchstabe <= 'Z'; buchstabe++) {
////            System.out.println(buchstabe + ", " + (int)buchstabe);
////            System.out.println("IntegerVariable "+ buchstabe+" = Choco.makeIntVar(\""+ buchstabe +"\", 0, 9, String.valueOf(Options.V_ENUM));");
//            System.out.println("integerVariableMap.put(\""+buchstabe+"\",");
//        }
    }
}
