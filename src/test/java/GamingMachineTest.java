import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GamingMachineTest {

    private GameType gameType;
    private GamingMachine gm;
    private BettingAuthority bettingAuthority;
    private Casino casino;
    private BetRound betRound;
    private Card card;

    @Before
    public void before(){
        gameType = GameType.BlackJack;
        gm = new GamingMachine(gameType);
        bettingAuthority = mock(BettingAuthority.class);
        casino = new Casino(bettingAuthority);
        betRound = casino.createBetRound();
        card = mock(Card.class);
    }

    /**
     * Test should pass when place a bet is placed by providing betRound
     * This is to test the behavior of the method double placeBet(BetRound betRound, double amount)
     */
    @Test
    public void gamingMachineCanPlaceBetOnBettingRound() throws Exception {
        // arrange
        double AMOUNT = 50.0;
        Card cardToTest = BankTeller.Cashier.issueCard();
        BankTeller.Cashier.updateCardBalance(cardToTest, AMOUNT);
        // act
        gm.placeBet(cardToTest, betRound, new Bet(AMOUNT));
        // assert
        Assert.assertEquals(1, betRound.getListOfBets().size());
    }

    /**
     * Test should pass when multiple bets are placed sucessfully
     * This is to test the behavior of the method double placeBet(BetRound betRound, double amount) by calling it multiple times
     */
    @Test (expected = Exception.class)
    public void cardDoesNotHaveEnoughBalanceToPlaceBetShouldThrowException() throws Exception {
        // arrange
        double AMOUNT = 100.0;
        Card cardToTest = BankTeller.Cashier.issueCard();
        BankTeller.Cashier.updateCardBalance(cardToTest, AMOUNT);
        // act
        gm.placeBet(cardToTest, betRound, new Bet(50.0));
        gm.placeBet(cardToTest, betRound, new Bet(51.0));
        // assert
        Assert.assertEquals(2, betRound.getListOfBets().size());
    }

    /**
     * This test is intended to ensure that gaming machine gets assigned a unique ID upon creation
     * Test should pass if two gaming machine id's are not equal
     */
    @Test
    public void machineIdShouldBeUnique() {
        // arrange
        GamingMachine gm1 = new GamingMachine(gameType);
        GamingMachine gm2 = new GamingMachine(gameType);

        // assert
        Assert.assertNotSame("Gaming machine id's are not unique", gm1.getMachineID(), gm2.getMachineID());
    }

    /**
     * Test should pass when exception is thrown in case of betAmount is incorrect while placing a bet
     * This is to test the behavior of the method double placeBet(BetRound betRound, double amount)
     */
    @Test(expected = IllegalArgumentException.class)
    public void betAmountLessOrEqualToZeroShouldThrowAnException() throws Exception {
        // act
        gm.placeBet(card, betRound, new Bet(-1.0));
    }

    /**
     * Test should pass if the card can be added to the list of connected cards on a gaming machine
     * This is to test the behavior of the method addCardToConnectedCards(Card c)
     */
    @Test
    public void cardCanBeConnectedToGamblingMachine() {
        // act
        gm.addCardToConnectedCards(card);

        // assert
        Assert.assertEquals(1, gm.getListOfConnectedCards().size());
    }

    /**
     * Test should pass when getMachineID, returns a UUID
     * Testing the behavior of the method UUID getMachineId()
     */
    @Test
    public void gettingMachineIDShouldReturnNonNullValue() {
        // act
        Assert.assertNotNull(gm.getMachineID());
    }

    /**
     * Test should pass if the card with sufficient amount on it (more or equal to the bet amount) can place a bet
     */
    @Test
    public void cardWithSufficientBalanceCanPlaceBet() throws Exception {
        // arrange
        Card card = BankTeller.Cashier.issueCard(); // actual card
        BankTeller.Cashier.updateCardBalance(card, 55.00);

        // act
        gm.placeBet(card, betRound, new Bet(50.00));

        // assert
        Assert.assertEquals(1, betRound.getListOfBets().size());

    }

    /**
     * If the card balance is below the bet amount, an Exception should be thrown
     * @throws Exception
     */
    @Test (expected = Exception.class)
    public void placingBetViaCardWithInsufficientBalanceShouldThrowAnException() throws Exception {
        // arrange
        Card card = BankTeller.Cashier.issueCard(); // actual card
        BankTeller.Cashier.updateCardBalance(card, 55.00);

        // act
        gm.placeBet(card, betRound, new Bet(60.00));
    }
}