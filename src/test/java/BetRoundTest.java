import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

import java.time.LocalDateTime;



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
        LocalDateTime expectedResult = LocalDateTime.now();
        //act
        LocalDateTime actualResult = round.startRound(bet);

        //assert
        Assert.assertEquals("Start Date is not returned successful!",expectedResult,actualResult);
    }

    /**
     * This test should be passed when a round ends and returns the date value
     * This test is created to test LocalDateTime endRound(Cashier c, Double amount) method
     */
    @Test
    public void endingBetRoundShouldReturnDateSuccessful(){

    }


    /**
     * This test should be passed when Bet Value is returned when a bet is placed successfully
     * This test is created to test double placeBet(Bet bet, double betAmount) method
     */
    @Test
    public void placeBetInBetRoundShouldReturnBetValueSuccessful(){
       
    }

    /**
     * This test should be passed when a token is set successfully to the betting round when betting authority acquires
     for a token
     * This test is created to test void setToken(string token) method
     */
    @Test
    public void tokenIsSetSuccessfullyToBettingRound(){

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


}
