package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardApiTest {
    public static final String CREDIT_CARD_NUMBER="1234-5678";
    public static final BigDecimal CC_LIMIT=BigDecimal.valueOf(1000);
    private CreditCardFacade api;
    private inMemmoryCreditCardStorage storage;
    private BigDecimal moneyLeft;

    @Test
    public void iAmAbleToWithdrawFromCard(){
        thereIsCCPermanentStorage();
        thereIsCreditCard(CREDIT_CARD_NUMBER);
        thereIsCCApi();

        api.withdraw(CREDIT_CARD_NUMBER, BigDecimal.valueOf(200));
        ccwithNumberBalanceEquals(CREDIT_CARD_NUMBER, BigDecimal.valueOf(800));

    }

    private void ccwithNumberBalanceEquals(String creditCardNumber, BigDecimal valueOf) {
    CreditCard cc = storage.load(creditCardNumber);
    Assert.assertEquals(cc.getCurrentBalance(), moneyLeft);
    }

    private void thereIsCCPermanentStorage() {
        this.storage=new inMemmoryCreditCardStorage();
    }

    private void thereIsCreditCard(String creditCardNumber) {
        CreditCard cc = new CreditCard(creditCardNumber);
        cc.assignLimit(CC_LIMIT);

        this.storage.add(cc);

    }

    private void thereIsCCApi() {
        this.api=new CreditCardFacade();
    }
}
