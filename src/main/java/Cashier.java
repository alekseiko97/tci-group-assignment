import java.util.HashMap;

public class Cashier {

    private HashMap<Card, Double> cashToCard;

    public Cashier() {
        this.cashToCard = new HashMap<>();
    }

    public void updateCardBalance(Card c, double amount) {
        if (cashToCard.containsKey(c)) {
            cashToCard.put(c, cashToCard.get(c) + amount);
        } else { // if the card was not in the hash map
            cashToCard.put(c, amount);
        }
    }

    public Card issueCard() {
        Card card = new Card();
        // initial amount
        this.cashToCard.put(card, 0.0);
        return card;
    }
}
