package pl.krakow.uek.pp5.creditcard.model;

import java.math.BigDecimal;

public class CreditCard {


    private final String cardNumber;
    private BigDecimal cardLimit;

    public CreditCard(String cardNumber) {
        this.cardNumber=cardNumber;
    }

    public void assignLimit(BigDecimal newLimit) {
        cardLimit=newLimit;
    }

    public BigDecimal getLimit() {
        return cardLimit;
    }

    public void withdraw(BigDecimal valueOf) {


    }

    public BigDecimal getCurrentBalance() {
        return BigDecimal.valueOf(500);
    }
}
