import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDateTime;

public class CardTest {

    /**
     *Test should pass when card details(timestamp & list of bets) are reset
     *This is to test the behaviour of method void returnCardToCashier()
     */
    @Test
    public void cardSuccessfullyReturnedToCashier()
    {
        //arrange
        Card card = new Card();
        //act
        card.returnCardToCashier();
        //assert
        Assert.assertEquals(0, card.getListOfBets().size());
        Assert.assertEquals(null, card.getTimestamp());
    }

    /**
     *test should pass when money is deposited in the provided card with provided amount
     *testing method void depositMoney(double amount,Card card)
     */
    @Test
    public void successfullyDepositMoneyInCard()
    {

    }


    /**
     *test should pass when it throws exception in case of amount is incorrect while depositing money to the *provided card
     *testing method void depositMoney(double amount,Card card)
     */
    @Test(expected = IllegalArgumentException.class)
    public void DepositMoneyInCardShouldThrowExceptionWhenAmountIsInCorrect()
    {
    }





}
