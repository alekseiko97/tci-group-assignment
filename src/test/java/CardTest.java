import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;

public class CardTest {

    /**
     *test should pass when provided card is returned to cashier
     *testing method void returnCardToCashier()
     */
    @Test
    public void cardSuccessfullyReturnedToCashier()
    {
        //arrange
        boolean isReturnedTrue = true;
        Cashier cashier = mock(Cashier.class);
        Card card = cashier.issueCard();
        //act
        boolean result = card.returnCardToCashier();
        //assert
        Assert.assertEquals(isReturnedTrue,result);
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
