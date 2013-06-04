package antlr.entities;

/**
 * User: Alex
 * Date: 16.05.13
 * Time: 03:03
 */
public class NumberAlex {

    private String tokenId;

    private String number;

    private NumberAlex(String tokenId, String number) {
        this.tokenId = tokenId;
        this.number = number;
    }

    public static NumberAlex create(String tokenId, String number) {
        return new NumberAlex(tokenId, number);
    }



    @Override
    public String toString() {
        return number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
