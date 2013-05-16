package antlr.entities;

/**
 * User: Alex
 * Date: 16.05.13
 * Time: 03:05
 */
public class Operation {

    private Number firstOperand;

    private Number secondOperand;

    private Number result;

    private Calcsym calcsym;

    private Operation(Number firstOperand, Number secondOperand, Number result, Calcsym calcsym) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.result = result;
        this.calcsym = calcsym;
    }

    public static Operation create(Number firstOperand, Number secondOperand, Number result, Calcsym calcsym) {
        return new Operation(firstOperand, secondOperand, result, calcsym);
    }

    public Number getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Number firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Number getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Number secondOperand) {
        this.secondOperand = secondOperand;
    }

    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public Calcsym getCalcsym() {
        return calcsym;
    }

    public void setCalcsym(Calcsym calcsym) {
        this.calcsym = calcsym;
    }
}
