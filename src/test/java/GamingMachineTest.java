import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GamingMachineTest {

    GameType gameType = GameType.BlackJack;
    GamingMachine gm = new GamingMachine(gameType);
    Casino casino = new Casino();
    BetRound betRound = casino.createBetRound();

    /**
     * Test should pass when place a bet is placed by providing betRound
     * This is to test the behavior of the method double placeBet(BetRound betRound, double amount)
     */

    @Test
    public void gamingMachineCanPlaceBetOnBettingRound() {
        // arrange
        double AMOUNT = 50.0;

        // act
        gm.placeBet(betRound, AMOUNT);

        // assert
        Assert.assertEquals(1, betRound.getListOfBets().size());
    }

    /**
     * Test should pass when exception is thrown in case of betAmount is incorrect while placing a bet
     * This is to test the behavior of the method double placeBet(BetRound betRound, double amount)
     */
    @Test(expected = IllegalArgumentException.class)
    public void betAmountLessThanZeroShouldThrowAnException() {
        // act
        gm.placeBet(betRound, -1.0);
    }

    /**
     * Test should pass if the card can be added to the list of connected cards on a gaming machine
     * This is to test the behavior of the method addCardToConnectedCards(Card c)
     */

    @Test
    public void cardCanBeConnectedToGamblingMachine() {
        // arrange
        Card card = mock(Card.class);

        // act
        gm.addCardToConnectedCards(card);

        // assert
        Assert.assertEquals(1, gm.getListOfConnectedCards().size());
    }

    /**
     * Test should pass when getMachineID, returns a UUID
     * Testing the behavior of the method UUID getMachineId()
     */
    @Test
    public void gettingMachineIDShouldReturnNonNullValue() {
        // act
        Assert.assertNotNull(gm.getMachineID());
    }

    /**
     * Test should pass if the card with sufficient amount on it (more or equal to the bet amount) can place a bet
     */

    @Test
    public void cardWithSufficientBalanceCanPlaceBet() {
        // arrange
        Cashier cashier = new Cashier();
        cashier.updateCardBalance(c, 55.00);

        // act
        gm.placeBet(card, betRound, 50.0);

        // assert
        Assert.assertEquals(2, betRound.getListOfBets().size());
    }

}