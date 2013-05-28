package antlr.constraint;

import choco.Choco;
import choco.Options;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.Solver;

/**
 * Created with IntelliJ IDEA.
 * User: abg628
 * Date: 28.05.13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        donald();
    }

    public static void donald() {
        // Build model
        Model model = new CPModel();
// Declare every letter as a variable
        IntegerVariable d = Choco.makeIntVar("d", 0, 9, Options.V_ENUM);
        IntegerVariable o = Choco.makeIntVar("o", 0, 9, Options.V_ENUM);
        IntegerVariable n = Choco.makeIntVar("n", 0, 9, Options.V_ENUM);
        IntegerVariable a = Choco.makeIntVar("a", 0, 9, Options.V_ENUM);
        IntegerVariable l = Choco.makeIntVar("l", 0, 9, Options.V_ENUM);
        IntegerVariable g = Choco.makeIntVar("g", 0, 9, Options.V_ENUM);
        IntegerVariable e = Choco.makeIntVar("e", 0, 9, Options.V_ENUM);
        IntegerVariable r = Choco.makeIntVar("r", 0, 9, Options.V_ENUM);

        IntegerVariable b = Choco.makeIntVar("b", 0, 9, Options.V_ENUM);
        IntegerVariable t = Choco.makeIntVar("t", 0, 9, Options.V_ENUM);
// Array of coefficients
        int[] c = new int[]{100000, 10000, 1000, 100, 10, 1};

// Add equality between name and letters combination
        IntegerVariable uebertrag = Choco.makeIntVar("uebertrag", 0, 1);
        IntegerVariable uebertrag2 = Choco.makeIntVar("uebertrag2", 0, 1);
        IntegerVariable uebertrag3 = Choco.makeIntVar("uebertrag3", 0, 1);
        IntegerVariable uebertrag4 = Choco.makeIntVar("uebertrag4", 0, 1);
        IntegerVariable uebertrag5 = Choco.makeIntVar("uebertrag5", 0, 1);

        // Add constraint of all different letters.
        model.addConstraint(Choco.allDifferent(d, o, n, a, l, g, e, r, b, t));

        model.addConstraint(Choco.eq(Choco.plus(d,d),Choco.plus(t,Choco.mult(uebertrag,10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(l, l),uebertrag), Choco.plus(r, Choco.mult(uebertrag2, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(a, a),uebertrag2), Choco.plus(e, Choco.mult(uebertrag3, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(n, r),uebertrag3), Choco.plus(b, Choco.mult(uebertrag4, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(o, e),uebertrag4), Choco.plus(o, Choco.mult(uebertrag5, 10))));
        model.addConstraint(Choco.eq(Choco.plus(Choco.plus(d, g),uebertrag5), r));

// Build a solver, read the model and solve it
        Solver s = new CPSolver();
        s.read(model);
        s.solve();
// Print name value
        System.out.println("donald = " + s.getVar(d).getVal()+""+s.getVar(o).getVal()+""+s.getVar(n).getVal()+""+s.getVar(a).getVal()+""+s.getVar(l).getVal()+""+s.getVar(d).getVal());
        System.out.println("gerald = " + s.getVar(g).getVal()+""+s.getVar(e).getVal()+""+s.getVar(r).getVal()+""+s.getVar(a).getVal()+""+s.getVar(l).getVal()+""+s.getVar(d).getVal());
        System.out.println("robert = " + s.getVar(r).getVal()+""+s.getVar(o).getVal()+""+s.getVar(b).getVal()+""+s.getVar(e).getVal()+""+s.getVar(r).getVal()+""+s.getVar(t).getVal());
    }
}
