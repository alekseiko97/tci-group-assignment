import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Card {
    private UUID cardId;
    private LocalDateTime timestamp;
    private List<Bet> listOfBets;
    private boolean isCardConnected;

    public Card() {
        this.cardId = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.listOfBets = new ArrayList<Bet>();
        this.isCardConnected=false;
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

    public boolean connectToGamingMachine(GameType blackJack) {
        GamingMachine gm=new GamingMachine(blackJack);
        gm.addCardToConnectedCards(this);
        this.isCardConnected=true;
        return this.isCardConnected;
    }


}
