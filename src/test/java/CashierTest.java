import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class CashierTest {

    /**
     * Check the balance of the provided card.
     * Card with not enough balance will be return false
     * This test is created to test bool checkBalance(Card card) method
     */
    @Test
    public void cardWithInsufficientBalanceShouldReturnFalse(){

    }

    /**
     * Check the balance of the provided card.
     * This test should be passed when a card with sufficient balance
     * This test is created to test bool checkBalance(Card card) method
     */
    @Test
    public void cardWithSufficientBalanceShouldReturnTrue(){

    }

    /**
     * This test should be passed when a new card is issued successfully by the cashier
     * This test is created to test Card issueCard() method
     */
    @Test
    public void aNewCardShouldBeAssignedSuccessfully(){
        //arrange
        //act
        Card card = BankTeller.Cashier.issueCard();
        //assert
        assertNotNull(card);
    }

    /**
     * This test should throw exception when updating the credit on the card with the insufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateCardBalanceWithInsufficientAmountShouldThrowException(){

    }

    /**
     * This test should be passed when updating the credit on the card with the sufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test
    public void updateCardBalanceWithSufficientAmountShouldBeSuccessful(){

    }

    /**
     * This test should be passed when a card is handed back to the cashier successfully
     * This test is created to test void resetCard(Card c) method
     */
    @Test
    public void cardSuccessfullyReset(){

    }

    /**
     * Test should be passed when logCardHandedOut from BettingAuthority is being called from Cashier-> issueCard
     * this test is created to test Card issueCard()
     */
    @Test
    public void logCardHandedOutWhenCardIsIssuedSuccessfullyFromIssueCard(){
        //arrange
        BettingAuthority bettingAuthority = mock(BettingAuthority.class);
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStampTest = Integer.toString(currentTime.getDayOfMonth()) + currentTime.getMonth() + currentTime.getYear();
        //act
        Card card = BankTeller.Cashier.issueCard();
        //assert
        verify(bettingAuthority, times(1)).logCardHandedOut(card, timeStampTest);
    }

}
