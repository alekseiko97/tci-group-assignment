import javafx.scene.chart.PieChart;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;


public class BettingAuthorityTest {

    private BettingAuthority bettingAuthority;
    private String token;
    private String timestamp;
    private List<String> countOfLogs;
    private Casino casino;
    private BetRound betRound;
    private Bet bet;
    private Card card;
    //setup method will be executed first before test
    @Before
    public void setUp(){
        bettingAuthority = new BettingAuthority();
        casino = mock(Casino.class);
        countOfLogs = new ArrayList<>();
        token = UUID.randomUUID().toString();
        timestamp = LocalDateTime.now().toString();
        betRound = mock(BetRound.class);
        bet = mock(Bet.class);
        card = mock(Card.class);
    }

    /**
     * Test should pass when starting betting round is accompanied by a logging and timestamping of it
     * The information about the bet round needs to be logged upon creating it
     * This is to test the behavior of the method void logBettingRound(BetRound betRound, String token)
     */
    @Test
    public void creationOfBettingRoundShouldBeLoggedAndTimestamped() {
        //arrange
        //act
        bettingAuthority.logBettingRound(token,timestamp);
        //assert
        assertEquals(1,bettingAuthority.loggerList.size());
    }
        /**
         * Test should pass if all bets from the given betting round are logged by the end of the round
         * Valid token should be provided to succeed
         * This test is created to test void logEnd(List<Bet> bets, String token)
         */
    @Test
    public void allBetsFromBettingRoundShouldBeLoggedWhenFinished() {
        //arrange
        //act
        bettingAuthority.logEnd(betRound,bet,timestamp);
        //assert
        assertEquals(1, bettingAuthority.loggerList.size());
    }

    /**
     * Test should pass if handing out the gambling card to the gambler is logged
     * This test is created to test a behavior of void logCardHandedOut(Card c)
     */

    @Test
    public void handingOutGamblingCardShouldBeLogged()
    {
        //arrange
        //act
        bettingAuthority.logCardHandedOut(card, timestamp);
        //assert
        assertEquals(1,bettingAuthority.loggerList.size());
    }

    /**
     * Test should pass if handing in gambling card is logged along with the list of bet ID's
     * This test is created to test the behavior of void logCardReturned(Card c)
     */

    @Test
    public void handingInGamblingCardShouldBeLogged()
    {
        //arrange
        //act
        bettingAuthority.logCardReturned(card, timestamp);
        //assert
        assertEquals(1,bettingAuthority.loggerList.size());
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
