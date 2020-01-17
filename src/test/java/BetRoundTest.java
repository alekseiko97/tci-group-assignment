import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.UUID;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;


public class BetRoundTest {

    double AMOUNT = 20.0;

    /**
     * This test should be passed when a round starts and returns the date value
     * This test is created to test LocalDateTime startRound(Bet bet) method
     */
    @Test
    public void startingBetRoundShouldReturnDateSuccessful(){
        //arrange
        Bet bet = new Bet(AMOUNT);
        BetRound round = new BetRound();
        DayOfWeek expectedDate = LocalDateTime.now().getDayOfWeek();
        Month expectedMonth = LocalDateTime.now().getMonth();
        int expectedHour = LocalDateTime.now().getHour();
        //act
        LocalDateTime actualResult = round.startRound(bet);
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
        Bet bet = new Bet(AMOUNT);
        BetRound round = new BetRound();
        DayOfWeek expectedDate = LocalDateTime.now().getDayOfWeek();
        Month expectedMonth = LocalDateTime.now().getMonth();
        int expectedHour = LocalDateTime.now().getHour();
        //act
        LocalDateTime actualResult = round.endRound(bet);
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
        BetRound round = new BetRound();
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
        BetRound round = new BetRound();
        //act
        round.setToken(expectedResult);
        String actualResult = round.getToken();

        //assert
        Assert.assertEquals("Token is not set correctly", expectedResult, actualResult);

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
        //arrange
        BettingAuthority bettingAuthority = mock(BettingAuthority.class);
        BetRound round = new BetRound();
        //act
        round.startRound();
        //assert
        verify(bettingAuthority, times(1)).logBettingRound(UUID.randomUUID().toString(), LocalDateTime.now().toString());
    }


}
