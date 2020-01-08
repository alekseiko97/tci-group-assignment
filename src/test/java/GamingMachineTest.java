import org.junit.Test;

public class GamingMachineTest {


    /**
     * test should pass when place a bet is placed by providing betRound
     * testing method double placeBet(BetRound betRound)
     */
    @Test
    public void successfullyPlaceABet() {
    }


    /**
     * test should pass when throws exception in case of betAmount is incorrect while placing a bet
     * testing method double placeBet(BetRound betRound)
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBetAmountIsInCorrectWhilePlacingABet() {
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