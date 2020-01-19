import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class BetTest {
    /**
     * This test should throw exception when a bet is placed with insufficient amount
     * Test is created to test the constructor Bet(double inAmount)
     */
    @Test(expected = IllegalArgumentException.class)
    public void betPlacedWithInsufficientAmountShouldThrowException(){
        //arrange
        double insufficientBetAmount = 0;
        //act
        Bet bet = new Bet(insufficientBetAmount);
        //assert
    }

    /**
     * This test should be passed when a bet is placed with sufficient amount
     * Test is created to test the constructor Bet(double inAmount)
     */
    @Test
    public void betPlacedWithSufficientAmountShouldThrowException(){
        //arrange
        double insufficientBetAmount = 20;
        //act
        Bet bet = new Bet(insufficientBetAmount);
        //assert
    }

    /**
     * This test should be passed when betId of a bet is returned
     * Test is created to test the method UUID getBetId()
     */
    @Test
    public void betIdOfABetShouldBeReturnedSuccessful(){
        //arrange
        double sufficientAmount = 20;
        Bet bet = new Bet(sufficientAmount);
        //act
        UUID actualBetId = bet.getBetId();
        //assert
        Assert.assertNotNull("BetId is not get correctly",actualBetId);
    }
}
