package antlr.srcfiles;
import choco.Choco;
import choco.Options;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.Solver;
import static choco.Choco.neq;

public class ConstraintSolver{
    public static void main(String[] args){
        Model model = new CPModel();
        IntegerVariable D = Choco.makeIntVar("D", 0, 9, String.valueOf(Options.V_ENUM));
        IntegerVariable E = Choco.makeIntVar("E", 0, 9, String.valueOf(Options.V_ENUM));
        IntegerVariable F = Choco.makeIntVar("F", 0, 9, String.valueOf(Options.V_ENUM));
        IntegerVariable G = Choco.makeIntVar("G", 0, 9, String.valueOf(Options.V_ENUM));
        IntegerVariable A = Choco.makeIntVar("A", 0, 9, String.valueOf(Options.V_ENUM));
        IntegerVariable B = Choco.makeIntVar("B", 0, 9, String.valueOf(Options.V_ENUM));
        IntegerVariable C = Choco.makeIntVar("C", 0, 9, String.valueOf(Options.V_ENUM));
        model.addConstraint(Choco.allDifferent(D,E,F,G,A,B,C));

        IntegerVariable c1uebertrag0 = Choco.makeIntVar("c1uebertrag0", 0, 1);
        IntegerVariable c1uebertrag1 = Choco.makeIntVar("c1uebertrag1", 0, 1);
        IntegerVariable c1uebertrag2 = Choco.makeIntVar("c1uebertrag2", 0, 1);
        model.addConstraint(Choco.eq(Choco.plus(C,E), Choco.plus(F, Choco.mult(c1uebertrag0, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(B,D), c1uebertrag0), Choco.plus(C, Choco.mult(c1uebertrag1, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(A,D),c1uebertrag1),F));
        IntegerVariable c2uebertrag0 = Choco.makeIntVar("c2uebertrag0", 0, 1);
        IntegerVariable c2uebertrag1 = Choco.makeIntVar("c2uebertrag1", 0, 1);
        IntegerVariable c2uebertrag2 = Choco.makeIntVar("c2uebertrag2", 0, 1);
        model.addConstraint(Choco.eq(Choco.plus(B,E), Choco.plus(A, Choco.mult(c2uebertrag0, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(C,G), c2uebertrag0), Choco.plus(C, Choco.mult(c2uebertrag1, 10))));
        model.addConstraint(Choco.eq(Choco.plus(B, c2uebertrag1), Choco.plus(B, Choco.mult(c2uebertrag2, 10))));
        IntegerVariable c3uebertrag0 = Choco.makeIntVar("c3uebertrag0", 0, 1);
        IntegerVariable c3uebertrag1 = Choco.makeIntVar("c3uebertrag1", 0, 1);
        IntegerVariable c3uebertrag2 = Choco.makeIntVar("c3uebertrag2", 0, 1);
        IntegerVariable c3uebertrag3 = Choco.makeIntVar("c3uebertrag3", 0, 1);
        model.addConstraint(Choco.eq(Choco.plus(E,G), Choco.plus(E, Choco.mult(c3uebertrag0, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(E,B), c3uebertrag0), Choco.plus(A, Choco.mult(c3uebertrag1, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(A,C), c3uebertrag1), Choco.plus(G, Choco.mult(c3uebertrag2, 10))));
        model.addConstraint(Choco.eq(D, c3uebertrag2));
        IntegerVariable c4uebertrag0 = Choco.makeIntVar("c4uebertrag0", 0, 1);
        IntegerVariable c4uebertrag1 = Choco.makeIntVar("c4uebertrag1", 0, 1);
        IntegerVariable c4uebertrag2 = Choco.makeIntVar("c4uebertrag2", 0, 1);
        model.addConstraint(Choco.eq(Choco.plus(C,B), Choco.plus(E, Choco.mult(c4uebertrag0, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(B,C), c4uebertrag0), Choco.plus(E, Choco.mult(c4uebertrag1, 10))));
        model.addConstraint(Choco.eq(Choco.plus(A, c4uebertrag1), Choco.plus(A, Choco.mult(c4uebertrag2, 10))));
        IntegerVariable c5uebertrag0 = Choco.makeIntVar("c5uebertrag0", 0, 1);
        IntegerVariable c5uebertrag1 = Choco.makeIntVar("c5uebertrag1", 0, 1);
        IntegerVariable c5uebertrag2 = Choco.makeIntVar("c5uebertrag2", 0, 1);
        model.addConstraint(Choco.eq(Choco.plus(E,E), Choco.plus(G, Choco.mult(c5uebertrag0, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(D,G), c5uebertrag0), Choco.plus(B, Choco.mult(c5uebertrag1, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(D,B),c5uebertrag1),C));
        IntegerVariable c6uebertrag0 = Choco.makeIntVar("c6uebertrag0", 0, 1);
        IntegerVariable c6uebertrag1 = Choco.makeIntVar("c6uebertrag1", 0, 1);
        IntegerVariable c6uebertrag2 = Choco.makeIntVar("c6uebertrag2", 0, 1);
        IntegerVariable c6uebertrag3 = Choco.makeIntVar("c6uebertrag3", 0, 1);
        model.addConstraint(Choco.eq(Choco.plus(F,A), Choco.plus(E, Choco.mult(c6uebertrag0, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(C,C), c6uebertrag0), Choco.plus(A, Choco.mult(c6uebertrag1, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(F,B), c6uebertrag1), Choco.plus(G, Choco.mult(c6uebertrag2, 10))));
        model.addConstraint(Choco.eq(D, c6uebertrag2));

        Solver solver = new CPSolver();
        solver.read(model);
        solver.solve();

        System.out.println(String.valueOf(solver.getVar(A).getVal())+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(C).getVal())+ " + "+String.valueOf(solver.getVar(D).getVal())+String.valueOf(solver.getVar(D).getVal())+String.valueOf(solver.getVar(E).getVal())+" = "+String.valueOf(solver.getVar(F).getVal())+String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(F).getVal())+"");
        System.out.println(String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(B).getVal())+ " + "+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(G).getVal())+String.valueOf(solver.getVar(E).getVal())+" = "+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(A).getVal())+"");
        System.out.println(String.valueOf(solver.getVar(A).getVal())+String.valueOf(solver.getVar(E).getVal())+String.valueOf(solver.getVar(E).getVal())+ " + "+String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(G).getVal())+" = "+String.valueOf(solver.getVar(D).getVal())+String.valueOf(solver.getVar(G).getVal())+String.valueOf(solver.getVar(A).getVal())+String.valueOf(solver.getVar(E).getVal())+"");
        System.out.println(String.valueOf(solver.getVar(A).getVal())+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(C).getVal())+ " + "+String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(B).getVal())+" = "+String.valueOf(solver.getVar(A).getVal())+String.valueOf(solver.getVar(E).getVal())+String.valueOf(solver.getVar(E).getVal())+"");
        System.out.println(String.valueOf(solver.getVar(D).getVal())+String.valueOf(solver.getVar(D).getVal())+String.valueOf(solver.getVar(E).getVal())+ " + "+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(G).getVal())+String.valueOf(solver.getVar(E).getVal())+" = "+String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(G).getVal())+"");
        System.out.println(String.valueOf(solver.getVar(F).getVal())+String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(F).getVal())+ " + "+String.valueOf(solver.getVar(B).getVal())+String.valueOf(solver.getVar(C).getVal())+String.valueOf(solver.getVar(A).getVal())+" = "+String.valueOf(solver.getVar(D).getVal())+String.valueOf(solver.getVar(G).getVal())+String.valueOf(solver.getVar(A).getVal())+String.valueOf(solver.getVar(E).getVal())+"");
    }


}