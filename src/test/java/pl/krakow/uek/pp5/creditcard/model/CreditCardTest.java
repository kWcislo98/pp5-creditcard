package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {
    private static final int LIMIT =2000 ;


    @Test
    public void itAllowAssignCreditToCard(){
        //Arranbge /given
        CreditCard card= new CreditCard("1234-5678");
        //Act   /when
        card.assignLimit(BigDecimal.valueOf(LIMIT));
        //Assert    /then
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(LIMIT))) ;
    }
}
