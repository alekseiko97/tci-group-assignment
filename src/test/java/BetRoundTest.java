import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;


public class BetRoundTest {

    double AMOUNT = 20.0;
    BettingAuthority bettingAuthorityMock = mock(BettingAuthority.class);

    /**
     * This test should be passed when a round starts and returns the date value
     * This test is created to test LocalDateTime startRound(Bet bet) method
     */
    @Test
    public void startingBetRoundShouldReturnDateSuccessful(){
        // arrange
        BettingAuthority bettingAuthority = new BettingAuthority();
        BetRound round = new BetRound(bettingAuthority);
        DayOfWeek expectedDate = LocalDateTime.now().getDayOfWeek();
        Month expectedMonth = LocalDateTime.now().getMonth();
        int expectedHour = LocalDateTime.now().getHour();
        String token = UUID.randomUUID().toString();

        //act
        LocalDateTime actualResult = round.startRound(token);
        //assert
        Assert.assertEquals(expectedDate,actualResult.getDayOfWeek());
        Assert.assertEquals(expectedMonth, actualResult.getMonth());
        Assert.assertEquals(expectedHour, actualResult.getHour());
    }

    /**
     * This test should be passed when a round ends and returns the date value
     * This test is created to test LocalDateTime endRound(Cashier c, Double amount) method
     */
    @Test
    public void endingBetRoundShouldReturnDateSuccessful(){
        //arrange
        BetRound round = new BetRound(bettingAuthorityMock);
        DayOfWeek expectedDate = LocalDateTime.now().getDayOfWeek();
        Month expectedMonth = LocalDateTime.now().getMonth();
        int expectedHour = LocalDateTime.now().getHour();
        Bet betToPlaceInRound = new Bet(20.0);
        round.placeBet(betToPlaceInRound);
        //act
        LocalDateTime actualResult = round.endRound(betToPlaceInRound);
        //assert
        Assert.assertEquals(expectedDate,actualResult.getDayOfWeek());
        Assert.assertEquals(expectedMonth, actualResult.getMonth());
        Assert.assertEquals(expectedHour, actualResult.getHour());
    }

    /**
     * This test should return a winning bet from a round
     * Test is created to test method Bet getWinningBet()
     */
    @Test
    public void aWinningBetShouldBeReturnedSuccessful(){
        //arrange
        BetRound round = new BetRound(bettingAuthorityMock);
        Bet bet1ToPlaceInRound = new Bet(20.0);
        Bet bet2ToPlaceInRound = new Bet(10.0);
        Bet bet3ToPlaceInRound = new Bet(5.0);
        round.placeBet(bet1ToPlaceInRound);
        round.placeBet(bet2ToPlaceInRound);
        round.placeBet(bet3ToPlaceInRound);
        //act
        Bet actualWinningBet = round.getWinningBet();
        //assert
        Assert.assertNotNull(actualWinningBet);
    }


    /**
     * This test should be passed when Bet Value is returned when a bet is placed successfully
     * This test is created to test double placeBet(Bet bet, double betAmount) method
     */
    @Test
    public void placeBetInBetRoundShouldBeSuccessful(){
       //arrange
        Bet bet = new Bet(AMOUNT);
        BettingAuthority bettingAuthority = new BettingAuthority();

        BetRound round = new BetRound(bettingAuthority);
        //act
        round.placeBet(bet);
        List<Bet> actualBetListInRound = round.getListOfBets();
        //assert
        Assert.assertEquals(1,actualBetListInRound.size());
    }

    /**
     * This test should be passed when a token is set successfully to the betting round when betting authority acquires
     for a token
     * This test is created to test void setToken(string token) method
     */
    @Test
    public void tokenIsSetSuccessfullyToBettingRound(){
        //arrange
        String expectedResult = "TokenBetRound1";
        BettingAuthority bettingAuthority = new BettingAuthority();

        BetRound round = new BetRound(bettingAuthority);
        //act
        round.setToken(expectedResult);
        String actualResult = round.getToken();

        //assert
        Assert.assertEquals("Token is not set correctly", expectedResult, actualResult);

    }

    /**
     * This test should pass if bet round can be started after obtaining a unique token from gaming authority via casino
     * This is to test the behavior of the method startRound(string token)
     */
    @Test
    public void bettingRoundCannotBeStartedWithoutObtainingUniqueToken() {
        // arrange
        Casino casino = new Casino(new BettingAuthority());
        BetRound betRound = casino.createBetRound();
        String token = casino.requestUniqueToken(betRound.getBetRoundID());

        // act
        betRound.startRound(token);

        // assert
        Assert.assertTrue(betRound.getBetRoundStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void startOfBettingRoundWithInvalidTokenShouldThrowAnException() {
        // arrange
        Casino casino = new Casino(bettingAuthorityMock);
        BetRound betRound = casino.createBetRound();

        // act
        betRound.startRound(null);
    }

    /**
     * This test should be passed if the balance of the card is updated successfully with the amount won when the round has ended
     * This test is created to test LocalDate endRound(Cashier cashier, double amount) method
     */
    @Test
    public void balanceOfTheCardIsUpdatedSuccessfullyWithTheAmountWonWhenTheRoundHasEnded(){

    }


    /**
     * Test should be passed if a random number is get successfully for a betting round from its token.
     * It can be asked to generate for random numbers
     * This test is created to test int getRandomNumberForGame(GameType gameType) method
     */
    @Test
    public void randomNumberShouldBeGeneratedForABettingRoundFromItsToken(){

    }

    /**
     * Test should be passed if a list of placed bets is returned successfully
     * this test is created for List<Bet> getListOfPlaceBets() method
     */
    @Test
    public void listOfPlacedBetsShouldBeReturnedSuccessfully() {
        //arrange
//        BetRound round = new BetRound();
//        Bet bet1 = new Bet();
//        Bet bet2 = new Bet();
//        List<Bet> expectedResult = new ArrayList<>();
//        expectedResult.add(bet1);
//        expectedResult.add(bet2);

        //act
        // List<Bet> actualResult = round.getListOfBet();
    }
    /**
     * Test should be passed when logBettingRound from BettingAuthority is being called from BetRound-> startRound
     * this test is created to test void logBettingRound(BetRound betRound, String token)
     */
    @Test
    public void logBettingRoundSuccessfullyFromStartRound(){
        // arrange
        BettingAuthority bettingAuthority = new BettingAuthority();
        BetRound round = new BetRound(bettingAuthority);
        String  token = UUID.randomUUID().toString();
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStampTest = Integer.toString(currentTime.getDayOfMonth()) + currentTime.getMonth() + currentTime.getYear();
        // act
        round.startRound(token);
        // assert
        System.out.println(bettingAuthority.getLoggerList().size());
        Assert.assertEquals(1, bettingAuthority.getLoggerList().size());

    }

    /**
     * Test should be passed when logEnd from BettingAuthority is being called from BetRound-> endRound
     * This test is created to test void endRound()
     */
    @Test
    public void logBettingRoundSuccessfullyFromEndRound(){
        //arrange
        BettingAuthority bettingAuthority = mock(BettingAuthority.class);
        BetRound round = new BetRound(bettingAuthority);
        Bet betToPlaceInRound = new Bet(20.0);
        round.placeBet(betToPlaceInRound);
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStampTest = Integer.toString(currentTime.getDayOfMonth()) + currentTime.getMonth() + currentTime.getYear();
        //act
        round.endRound(betToPlaceInRound);
        //assert
        verify(bettingAuthority, times(1)).logEnd(round, betToPlaceInRound, timeStampTest);
    }

    /*
     *  This test should pass if bet round is able to get a random whole number
     *  This is to test the behavior of method Integer getRandomValue(String token)
     */
    @Test
    public void betRoundCanAskForRandomValue() {
        // arrange
        BettingAuthority bettingAuthority = new BettingAuthority();
        BetRound betRound = new BetRound(bettingAuthority);
        betRound.setToken("token");

        // act
        Integer value = betRound.getRandomValue(betRound.getToken());

        // assert
        Assert.assertNotNull(value);
    }

    /**
     * This test should pass if IllegalArgumentException is thrown when an invalid token is provided as
     * a parameter to the function getRandomValue(String token) - null or empty string
     */

    @Test(expected = IllegalArgumentException.class)
    public void requestingRandomValueByProvidingInvalidTokenShouldThrowAnException() {
        // arrange
        BetRound betRound = new BetRound(new BettingAuthority());

        // act
        betRound.getRandomValue(null);
    }

    /**
     * A betting round (with it’s token) can ask multiple times for a random value.
     * Test will pass if bet round is able to get two different random numbers
     */
    @Test
    public void bettingRoundCanAskMultipleTimesForRandomValue() {
        // arrange
        BettingAuthority bettingAuthority = new BettingAuthority();
        BetRound betRound = new BetRound(bettingAuthority);
        Casino casino = new Casino(bettingAuthority);
        // casino asks betting authority for a unique token
        String token = casino.requestUniqueToken(betRound.getBetRoundID());
        betRound.setToken(token);

        // act
        Integer value1 = betRound.getRandomValue(betRound.getToken());
        Integer value2 = betRound.getRandomValue(betRound.getToken());

        // assert
        Assert.assertNotSame(value1, value2);
       // Assert.assertEquals("List of Bets is not returned correctly", expectedResult, actualResult);
    }

    /**
     * This test should return a winning amount when a round ends
     * Test is created to test method double getWinningAmount()
     */
    @Test
    public void winningAmountShouldBeReturnedWhenARoundEndsSuccessful(){
        //arrange
        BetRound round = new BetRound(bettingAuthorityMock);
        Bet betToPlaceInRound = new Bet(20.0);
        round.placeBet(betToPlaceInRound);
        //act
        round.endRound(betToPlaceInRound);
        double actualWinningAmount = round.getWinningAmount();
        //assert
        Assert.assertNotEquals(0, actualWinningAmount);
    }
}
