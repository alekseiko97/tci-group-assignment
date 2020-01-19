import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

enum GameType {
    BlackJack, SlotMachine, Race
}

public class GamingMachine {

    private UUID machineID;
    private GameType gameType;
    private List<Card> listOfConnectedCards;

    public GamingMachine(GameType gameType) {
        this.machineID = UUID.randomUUID();
        this.gameType = gameType;
        this.listOfConnectedCards=new ArrayList<>();
    }

    public UUID getMachineID() {
        return machineID;
    }

    public void  placeBet(Card c, BetRound betRound, Bet bet) throws Exception {
        if (bet.getInAmount() <= 0) throw new IllegalArgumentException("Bet amount must be greater than zero");

        // if card has sufficient amount to place a bet
        if ((BankTeller.Cashier.checkCardBalance(c, bet.getInAmount()))) {
            BankTeller.Cashier.updateCardBalance(c, -bet.getInAmount());
            betRound.placeBet(bet);
        } else {
            throw new Exception("Card doesn't have enough balance to place a bet");
        }

    }


    public void addCardToConnectedCards(Card card) {
        listOfConnectedCards.add(card);
    }

    public List<Card> getListOfConnectedCards() {
        return this.listOfConnectedCards;
    }
}
