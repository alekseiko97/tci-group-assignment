import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Card {
    public UUID getCardId() {
        return cardId;
    }

    private UUID cardId;
    private LocalDateTime timestamp;
    private List<Bet> listOfBets;
    private GamingMachine gamingMachine = null;

    public Card() {
        this.cardId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.listOfBets = new ArrayList<Bet>();
    }

    public void returnCardToCashier() {
        this.cardId = null;
        this.timestamp = null;
        this.listOfBets.clear();
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public List<Bet> getListOfBets() {
        return this.listOfBets;
    }

    public boolean connectToGamingMachine(GameType gameType) {
        GamingMachine gm = new GamingMachine(gameType);
        gm.addCardToConnectedCards(this);
        this.gamingMachine = gm;
        return true;
    }

    public void placeBet(BetRound betRound, double betAmount) {
        Bet bet = new Bet(betAmount);
        try {
            //this.gamingMachine = new GamingMachine(GameType.BlackJack);
            this.gamingMachine.placeBet(this, betRound, bet);
            this.listOfBets.add(bet);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Not connected to gaming machine");
        }

    }

}
