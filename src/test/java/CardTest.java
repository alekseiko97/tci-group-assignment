import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class CardTest {

    private Card card;
    private BetRound betRound;
    private final GameType DUMMY_GAME_TYPE = GameType.BlackJack;

    @Before
    public void before()  {
        card = BankTeller.Cashier.issueCard();
        betRound = new BetRound(mock(BettingAuthority.class));
        card.connectToGamingMachine(DUMMY_GAME_TYPE);
        BankTeller.Cashier.updateCardBalance(card, 200);
    }

    /**
     * Test should pass if two cards id's are not the same, in other words, unique
     */
    @Test
    public void cardIDShouldBeUnique() {
        // arrange
        Card card2 = new Card();

        // assert
        Assert.assertNotEquals("Card id's are not unique", card.getCardId(), card2.getCardId());
    }
    /**
     *Test should pass when card details(timestamp & list of bets) are reset
     *This is to test the behaviour of method void returnCardToCashier()
     */

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
        //act
        card.placeBet(betRound,10.0);
        //assert
        Assert.assertEquals(1, card.getListOfBets().size());
    }

    /**
     * A gambler can make multiple bets per betting round
     * Test will pass if two bets were placed on the same betting round by one card
     */

    @Test
    public void placingMultipleBetsPerOneBettingRoundShouldBePossible() {
        // act
        card.placeBet(betRound, 20);
        card.placeBet(betRound, 30);

        // assert
        Assert.assertEquals(2, betRound.getListOfBets().size());
    }

    /**
     * A gambler can make multiple bets per betting round, but each of them should be unique.
     */

    @Test
    public void multiplePlacedBetsNeedToBeUnique() {
        // act
        card.placeBet(betRound, 20);
        card.placeBet(betRound, 30);

        // assert
        Assert.assertNotSame("Bets are not unique", betRound.getListOfBets().get(0), betRound.getListOfBets().get(1));
    }

    /**
     * After placing a bet, balance of a card should be decremented successful
     */
    @Test
    public void cardBalanceShouldBeDecrementedAfterPlacingABet() {
        // arrange
        Card testCard = BankTeller.Cashier.issueCard();
        testCard.connectToGamingMachine(GameType.BlackJack);
        // deposit some money
        BankTeller.Cashier.updateCardBalance(testCard, 20);

        // act
        testCard.placeBet(betRound, 15);
        double newBalance = BankTeller.Cashier.getCardBalance(testCard);

        // assert
        Assert.assertEquals("New balance is not as expected", 5, newBalance, 0);
    }

}
