import org.junit.Assert;
import org.junit.Test;

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
     * test should pass when getMachineID, returns a UUID
     * testing method UUID getMachineId()
     */
    @Test
    public void successfullyGetMachineId() {
    }

    /**
     * test should pass when throws exception while getting machine id does not return UUID format
     * testing method UUID getMachineId()
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenGetMachineIdReturnsIncorrectFormatOfMachineId() {
    }
}