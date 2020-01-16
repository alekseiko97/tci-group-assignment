import org.junit.Test;

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
     * This test should be passed when a new card is given to the gambler successfully by the cashier
     * This test is created to test void giveCardToGambler(Gambler gambler) method
     */
    @Test
    public void aNewCardShouldBeAssignedToGamblerSuccessfully(){

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

}
