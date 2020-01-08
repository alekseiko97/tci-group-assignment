import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BetAuthorityTest {

    /**
     * Test should pass when starting betting round is accompanied by a logging and timestamping of it
     * The information about the bet round needs to be logged upon creating it
     * This is to test the behavior of the method void logBettingRound(BetRound betRound, String token)
     */

    @Test
    public void creationOfBettingRoundShouldBeLoggedAndTimestamped() {
        throw new NotImplementedException();
    }

    /**
     * Test should pass if all bets from the given betting round are logged by the end of the round
     * Valid token should be provided to succeed
     * This test is created to test void logEnd(List<Bet> bets, String token)
     */

    @Test
    public void allBetsFromBettingRoundShouldBeLoggedWhenFinished() {
        throw new NotImplementedException();
    }

    /**
     * Test should pass if handing out the gambling card to the gambler is logged
     * This test is created to test a behavior of void logCardHandedOut(Card c)
     */

    @Test
    public void handingOutGamblingCardShouldBeLogged() {
        throw new NotImplementedException();
    }

    /**
     * Test should pass if handing in gambling card is logged along with the list of bet ID's
     * This test is created to test the behavior of void logCardReturned(Card c)
     */

    @Test
    public void handingInGamblingCardShouldBeLogged() {
        throw new NotImplementedException();
    }

    /**
     * Test should pass if random unique token can be generated and returned as a string
     * Valid betting round ID should be provided
     * This test is created to test string generateToken(UUID betId)
     */

    @Test
    public void uniqueTokenCanBeGenerated() {
        throw new NotImplementedException();
    }

    /**
     * This test should succeed if IllegalArgumentException is thrown in the case when
     * invalid (e.g. duplicate) bet round ID is provided
     * This test is created to test string generateToken(UUID betId)
     */

    @Test (expected = IllegalArgumentException.class)
    public void providingInvalidBetRoundIDWhenGeneratingTokenShouldThrowAnException() {
        throw new NotImplementedException();
    }
}
