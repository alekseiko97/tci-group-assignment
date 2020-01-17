import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class CardTest {

    private static final double BET_AMOUNT = 50.0;
    // arrange
    Card card = new Card();

    /**
     *Test should pass when card details(timestamp & list of bets) are reset
     *This is to test the behaviour of method void returnCardToCashier()
     */
    @Test
    public void cardSuccessfullyReturnedToCashier()
    {
        // act
        card.returnCardToCashier();

        // assert
        Assert.assertEquals(0, card.getListOfBets().size());
        Assert.assertNull(card.getTimestamp());
    }

    /**
     *Test should pass when card tries to connect with a valid gaming machine
     *This is to test the behaviour of method void connectToGamingMachine()
     */
    @Test
    public void cardIsConnectedToGamingMachineWithValidGameType()
    {
        // act
        boolean result = card.connectToGamingMachine(GameType.BlackJack);
        // assert
        Assert.assertTrue(result);
    }

    /**
     *Test should pass when a bet is placed successfully by a card
     * This is to test the behaviour of method void placeBet() using a card
     */
    @Test
    public void successfullyPlaceABet()
    {
        // arrange
        BetRound betRound = new BetRound();
        // act
        card.placeBet(betRound, BET_AMOUNT);
        // assert
        Assert.assertEquals(1, card.getListOfBets().size());

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
