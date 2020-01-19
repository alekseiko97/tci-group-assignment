
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;


public class BettingAuthorityTest {

    private BettingAuthority bettingAuthority;
    private String token;
    private String timestamp;
    private static int countOfLogs;
    private BetRound betRound;
    private Bet bet;
    private Card card;

    //setup method will be executed first before test
    @Before
    public void setUp(){
        countOfLogs=0;
        bettingAuthority = new BettingAuthority();
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
        assertEquals(countOfLogs+1,bettingAuthority.loggerList.size());
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
        assertEquals(countOfLogs+1, bettingAuthority.loggerList.size());
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
        assertEquals(countOfLogs+1, bettingAuthority.loggerList.size());
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
        assertEquals(countOfLogs+1, bettingAuthority.loggerList.size());
    }

    /**
     * Test should pass if random unique token can be generated and returned as a string
     * Valid betting round ID should be provided
     * This test is created to test string getUniqueToken(UUID betId)
     */

    @Test
    public void uniqueTokenCanBeGenerated() {
        //arrange
        //act
        String result = bettingAuthority.getUniqueToken(token);
        //assert
        assertThat(result, containsString(token));
    }
    /**
     * This test should when getRandomWholeNumber returns an int random number
     * This test is created to test Integer getRandomWholeNumber(String token)
     */

    @Test
    public void gettingRandomIntegerNumberFromBettingAuthority() {
        //arrange
        //act
        int result = bettingAuthority.getRandomWholeNumber(token);
        //assert
        assertThat(result, instanceOf(Integer.class));

    }

    /**
     * This test should when logs are getting added in the list named loggerList returns listOfString
     * This test is created to test List<String> getLoggerList()
     */
    @Test
    public void gettingListOfLogsFromBettingAuthority() {
        //arrange
        //act
        List<String> result = bettingAuthority.getLoggerList();
        //assert
        assertEquals(countOfLogs, result.size());

    }


}
