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

    @Test
    public void creditBelowGeneralLimitIsNotPossible(){
        //Arrange
        CreditCard card= new CreditCard("1234-5678");
        //Act

        //Assert
        try {
            card.assignLimit(BigDecimal.valueOf(50));
            Assert.fail("exception should be thrown");
        } catch (creditBelowLimitException e) {
            Assert.assertTrue(true);
        }
        }

        @Test
        public void withdrawFromCard(){
            CreditCard card1= new CreditCard("1234-5678");
            CreditCard card2= new CreditCard("1234-5678");
            card1.assignLimit(BigDecimal.valueOf(1000));
            card2.assignLimit(BigDecimal.valueOf(1000));
            card1.withdraw(BigDecimal.valueOf(500));
            card2.withdraw(BigDecimal.valueOf(100));
            Assert.assertEquals(BigDecimal.valueOf(500), card1.getCurrentBalance());
            Assert.assertEquals(BigDecimal.valueOf(900), card2.getCurrentBalance());
        }
    }
