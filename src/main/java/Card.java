import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Card {
    private UUID cardId;
    private LocalDateTime timestamp;
    private List<Bet> listOfBets;

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
}
