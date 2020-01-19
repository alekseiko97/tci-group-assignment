import org.junit.Test;

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
}
