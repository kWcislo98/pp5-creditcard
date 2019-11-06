package pl.krakow.uek.pp5.creditcard.model;

import java.math.BigDecimal;

public class CreditCard {


    private final String cardNumber;
    private BigDecimal cardLimit;
    private Object ballance;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber=cardNumber;
    }

    public void assignLimit(BigDecimal newLimit) {
        if(BigDecimal.valueOf(100).compareTo(newLimit)==1){
            throw new CreditBelowLimitException();
        }
        cardLimit=newLimit;
        balance=newLimit;
    }

    public BigDecimal getLimit() {
        return cardLimit;
    }

    public void withdraw(BigDecimal money) {
         if(balance.compareTo(money)==1){
             throw new NotEnoughMoneyExcpetion();
         }

        balance= balance.subtract(money);

    }

    public BigDecimal getCurrentBalance() {
        return balance;
    }
}
