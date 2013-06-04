package antlr.entities;

/**
 * User: Alex
 * Date: 16.05.13
 * Time: 03:05
 */
public class Operation {

    private NumberAlex firstOperand;

    private NumberAlex secondOperand;

    private NumberAlex result;

    private Calcsym calcsym;

    private Operation(NumberAlex firstOperand, NumberAlex secondOperand, NumberAlex result, Calcsym calcsym) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.result = result;
        this.calcsym = calcsym;
    }

    private Operation() {
    }

    public static Operation create(NumberAlex firstOperand, NumberAlex secondOperand, NumberAlex result, Calcsym calcsym) {
        return new Operation(firstOperand, secondOperand, result, calcsym);
    }

    public static Operation create() {
        return new Operation();
    }

    @Override
    public String toString() {
        return "Operation{" +
                "firstOperand=" + firstOperand +
                ", secondOperand=" + secondOperand +
                ", result=" + result +
                ", calcsym=" + calcsym +
                '}';
    }

    public Operation normalize() {
        if (calcsym.equals(Calcsym.MINUS)) {
            NumberAlex tempNumberAlex = this.firstOperand;
            this.setFirstOperand(this.getResult());
            this.setResult(tempNumberAlex);
            this.setCalcsym(Calcsym.PLUS);
        }
        return this;
    }

    public NumberAlex getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(NumberAlex firstOperand) {
        this.firstOperand = firstOperand;
    }

    public NumberAlex getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(NumberAlex secondOperand) {
        this.secondOperand = secondOperand;
    }

    public NumberAlex getResult() {
        return result;
    }

    public void setResult(NumberAlex result) {
        this.result = result;
    }

    public Calcsym getCalcsym() {
        return calcsym;
    }

    public void setCalcsym(Calcsym calcsym) {
        this.calcsym = calcsym;
    }
}
