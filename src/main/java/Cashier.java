import java.util.HashMap;

public class Cashier {
    private HashMap<Card, Double> cashToCard;
    public Cashier(){
        cashToCard = new HashMap<>();
    }
    public Card issueCard() {
        Card card = new Card();
        cashToCard.put(card, 0.0);
        return card;
    }
}
