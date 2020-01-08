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

    Class GamingMachine: Sharique

/**
 *test should pass when place a bet is placed by providing betRound
 *testing method double placeBet(BetRound betRound)
 */
    @Test
    public void successfullyPlaceABet()
    {
    }


    /**
     *test should pass when throws exception in case of betAmount is incorrect while placing a bet
     *testing method double placeBet(BetRound betRound)

     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBetAmountIsInCorrectWhilePlacingABet()
    {
    }


    /**
     *test should pass when getMachineID, returns a UUID
     *testing method UUID getMachineId()
     */
    @Test
    public void successfullyGetMachineId()
    {
    }

    /**
     *test should pass when throws exception while getting machine id does not return UUID format
     *testing method UUID getMachineId()
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenGetMachineIdReturnsIncorrectFormatOfMachineId()
    {
    }



}
