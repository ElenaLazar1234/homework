package b_01_06;

import java.util.Date;

public class Card {
    Date expirationDate;
    String ownerName;
    Double cardNumber;

    public Card(Date expirationDate, double cardNumber, String ownerName) {
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
        this.ownerName = ownerName;

    }

}
