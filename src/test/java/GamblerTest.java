import org.junit.Test;

public class GamblerTest {

    /**
     *test should pass when provided card is returned to cashier
     *testing method void returnCardToCashier(Card card)
     */
    @Test
    public void cardSuccessfullyReturnsToCashier()
    {
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
