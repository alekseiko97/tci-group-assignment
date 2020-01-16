import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;


public class BetRoundTest {


    /**
     * This test should be passed when a round starts and returns the date value
     * This test is created to test LocalDateTime startRound(Bet bet) method
     */
    @Test
    public void startingBetRoundShouldReturnDateSuccessful(){
        //arrange
        Bet bet = new Bet();
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
        Bet bet = new Bet();
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
        Bet bet = new Bet();
        BetRound round = new BetRound();
        Double expectedResult = 200.0;
        //act
        Double actualResult = round.placeBet(bet,200.0);
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
        //arrange
        BetRound round = new BetRound();
        Bet bet1 = new Bet();
        Bet bet2 = new Bet();
        List<Bet> expectedResult = new ArrayList<>();
        expectedResult.add(bet1);
        expectedResult.add(bet2);

        //act
       // List<Bet> actualResult = round.getListOfBet();

        //assert
       // Assert.assertEquals("List of Bets is not returned correctly", expectedResult, actualResult);
    }
}
