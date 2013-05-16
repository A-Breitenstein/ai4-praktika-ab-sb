package antlr.entities;

/**
 * User: Alex
 * Date: 16.05.13
 * Time: 03:07
 */
public enum Calcsym {




    PLUS,
    MINUS;

    private final static String minus = "-";

    private final static String plus = "+";


    public static Calcsym evaluateStringToCalcSym(String string) {

        if (string != null) {

            if (string.equals(minus)) return MINUS;

            if (string.equals(plus)) return PLUS;
        }

        throw new IllegalArgumentException();

    }
}
