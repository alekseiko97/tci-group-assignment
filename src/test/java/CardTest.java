import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class CardTest {

    /**
     *Test should pass when card details(timestamp & list of bets) are reset
     *This is to test the behaviour of method void returnCardToCashier()
     */

    private Card card;

    @Before
    public void before() throws Exception {
        card = new Card();
        card.connectToGamingMachine(GameType.BlackJack);
    }

    @Test
    public void cardSuccessfullyReturnedToCashier()
    {
        //act
        card.returnCardToCashier();
        //assert
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
        //act
        boolean result = card.connectToGamingMachine(GameType.BlackJack);
        //assert
        Assert.assertTrue(result);
    }

    /**
     *Test should pass when a bet is placed successfully by a card
     * This is to test the behaviour of method void placeBet() using a card
     */
    @Test
    public void successfullyPlaceABet()
    {
        //arrange
        BetRound betRound = new BetRound(mock(BettingAuthority.class));
        //act
        card.placeBet(betRound,10.0);
        //assert
        Assert.assertEquals(1, card.getListOfBets().size());
    }


}
