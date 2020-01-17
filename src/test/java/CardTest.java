import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

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
        Assert.assertNull(card.getTimestamp());
    }

    /**
     *Test should pass when card tries to connect with a valid gaming machine
     *This is to test the behaviour of method void connectToGamingMachine()
     */
    @Test
    public void cardIsConnectedToGamingMachineWithValidGameType()
    {
        //arrange
        Card card = new Card();
        //act
        boolean result = card.connectToGamingMachine(GameType.BlackJack);
        //assert
        Assert.assertEquals(true, result);
    }

    /**
     *Test should pass when a bet is placed successfully by a card
     * This is to test the behaviour of method void placeBet() using a card
     */
    @Test
    public void successfullyPlaceABet()
    {
        //arrange
        Card card = new Card();
        BetRound betRound = new BetRound(new BettingAuthority());
        GamingMachine gm = new GamingMachine(GameType.BlackJack);
        //act
        card.placeBet(betRound,10.0, gm);
        //assert
        Assert.assertEquals(1, card.getListOfBets().size());

    }


}
