package antlr.entities;

/**
 * User: Alex
 * Date: 16.05.13
 * Time: 03:03
 */
public class Number {

    private String number;

    private Number(String number) {
        this.number = number;
    }

    public static Number create(String number) {
        return new Number(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
