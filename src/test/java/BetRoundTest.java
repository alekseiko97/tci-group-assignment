import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Month;
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
        String token = mock(String.class);

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
        BettingAuthority bettingAuthority = new BettingAuthority();
        BetRound round = new BetRound(bettingAuthority);
        DayOfWeek expectedDate = LocalDateTime.now().getDayOfWeek();
        Month expectedMonth = LocalDateTime.now().getMonth();
        int expectedHour = LocalDateTime.now().getHour();
        Bet winningBet=new Bet(100.0);
        //act
        LocalDateTime actualResult = round.endRound(winningBet);
        //assert
        Assert.assertEquals(expectedDate,actualResult.getDayOfWeek());
        Assert.assertEquals(expectedMonth, actualResult.getMonth());
        Assert.assertEquals(expectedHour, actualResult.getHour());
    }


    /**
     * This test should be passed when Bet Value is returned when a bet is placed successfully
     * This test is created to test double placeBet(Bet bet, double betAmount) method
     */
    @Test
    public void placeBetInBetRoundShouldReturnBetValueSuccessful(){
       //arrange
        Bet bet = new Bet(AMOUNT);
        BettingAuthority bettingAuthority = new BettingAuthority();

        BetRound round = new BetRound(bettingAuthority);
        Double expectedResult = 200.0;
        //act
        Double actualResult = round.placeBet(bet);
        //assert
        Assert.assertEquals("Bet amount is not returned correctly when a bet is placed", expectedResult, actualResult);
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
        Casino casino = new Casino(bettingAuthorityMock);
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
    public void listOfPlacedBetsShouldBeReturnedSuccessfully(){

    }

    /**
     * Test should be passed when logBettingRound from BettingAuthority is being called from BetRound-> startRound
     * this test is created to test void logBettingRound(BetRound betRound, String token)
     */
    @Test
    public void logBettingRoundSuccessfullyFromStartRound(){
        // arrange
        BettingAuthority bettingAuthority = mock(BettingAuthority.class);
        BetRound round = new BetRound(bettingAuthority);
        String token = mock(String.class);

        // act
        round.startRound(token);

        // assert
        verify(bettingAuthority, times(1)).logBettingRound(UUID.randomUUID().toString(), LocalDateTime.now());
    }

    /**
     * Test should be passed when logEnd from BettingAuthority is being called from BetRound-> endRound
     * this test is created to test void endRound()
     */
    @Test
    public void logBettingRoundSuccessfullyFromEndRound(){
        //arrange
        BettingAuthority bettingAuthority = mock(BettingAuthority.class);
        BetRound round = new BetRound(bettingAuthority);
        Bet winningBet=new Bet(100.0);
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStampTest = Integer.toString(currentTime.getDayOfMonth()) + currentTime.getMonth() + currentTime.getYear();
        //act
        round.endRound(winningBet);
        //assert
        verify(bettingAuthority, times(1)).logEnd(round, winningBet, timeStampTest);
    }

    /*
        This test should pass if bet round is able to get a random whole number
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


}
