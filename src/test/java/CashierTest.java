import org.junit.Assert;
import org.junit.Test;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CashierTest {
    /**
     * This test should be passed when a new card is given to the gambler successfully by the cashier
     * This is created to test Card issueCard() method
     */
    @Test
    public void aNewCardShouldBeAssignedToGamblerSuccessfully(){
        //arrange
        DayOfWeek expectedDate = LocalDateTime.now().getDayOfWeek();
        Month expectedMonth = LocalDateTime.now().getMonth();
        int expectedHour = LocalDateTime.now().getHour();
        //act
        Card actualCard = BankTeller.Cashier.issueCard();

        //assert
        Assert.assertEquals("Card is not created correctly by cashier", expectedMonth, actualCard.getTimestamp().getMonth());
        Assert.assertEquals("Card is not created correctly by cashier", expectedDate, actualCard.getTimestamp().getDayOfWeek());
        Assert.assertEquals("Card is not created correctly by cashier", expectedHour, actualCard.getTimestamp().getHour());
        assertNotNull(actualCard);
    }

    /**
     * This test should be passed when a card has the amount less then the betAmount
     * This is created to test boolean checkBalance(Card card) method
     */
    @Test
    public void aCardWithInsufficientBalanceShouldReturnFalse(){
        //arrange
        Card c = BankTeller.Cashier.issueCard();

        //act
        BankTeller.Cashier.updateCardBalance(c, 50);
        boolean actualResult = BankTeller.Cashier.checkCardBalance(c, 50);

        //assert
        Assert.assertTrue(actualResult);
    }

    /**
     * This test should be passed when a card has the amount more then the betAmount
     * This is created to test boolean checkBalance(Card card) method
     */
    @Test
    public void aCardWithSufficientBalanceShouldReturnFalse(){
        //arrange

        //act
        boolean actualResult = BankTeller.Cashier.checkCardBalance(BankTeller.Cashier.issueCard(), 200.0);

        //assert
        Assert.assertFalse( actualResult);
    }

    /**
     * This test should throw exception when updating the credit on the card with the insufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateCardBalanceWithInsufficientAmountShouldThrowException(){
        //arrange
        Card c = BankTeller.Cashier.issueCard();
        //act
        BankTeller.Cashier.updateCardBalance(c, -2);
        //assert
    }

    /**
     * This test should be passed when updating the credit on the card with the sufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test
    public void updateCardBalanceWithSufficientAmountShouldBeSuccessful(){
        //arrange
        Card c = BankTeller.Cashier.issueCard();
        //act
        BankTeller.Cashier.updateCardBalance(c, 20);
        //assert
    }

    /**
     * This test should be passed when a card is handed back to the cashier, the method returnCardToCashier()
     * is called from Card class
     * This test is created to test void resetCard(Card c) method
     */
    @Test
    public void aCardSuccessfullyReset(){
        //arrange
        Card cardShouldBeReset = mock(Card.class);
        //act
        BankTeller.Cashier.resetCard(cardShouldBeReset);
        //assert
        verify(cardShouldBeReset).returnCardToCashier();
    }

    /**
     * Test should be passed when logCardHandedOut from BettingAuthority is being called from Cashier-> issueCard
     * this test is created to test Card issueCard()
     */
    @Test
    public void logCardHandedOutWhenCardIsIssuedSuccessfullyFromIssueCard(){
        //arrange
        //act
        Card card = BankTeller.Cashier.issueCard();
        //assert
        assertEquals(true, BankTeller.Cashier.isLogCardHandedOut);
    }

    /**
     * Test should be passed when a cashier wants to get the balance of a card
     * This test is created to test  Double getCardBalance(Card card) method
     */
    @Test
    public void balanceOfACardShouldBeGetSuccessful(){
        //arrange
        Card cardToTest = BankTeller.Cashier.issueCard();
        BankTeller.Cashier.updateCardBalance(cardToTest, 20);
        Double expectedBalance = 20.0;

        //act
        Double actualBalance = BankTeller.Cashier.getCardBalance(cardToTest);

        //assert
        Assert.assertEquals("Balance of a card is not returned correctly!", expectedBalance, actualBalance);
    }

}
