import java.time.LocalDateTime;
import java.util.HashMap;

public class BankTeller {
    public static class Cashier {

        private static HashMap<Card, Double> cashToCard = new HashMap<>();
        public static BettingAuthority bettingAuthority = new BettingAuthority();
        public static boolean isLogCardHandedOut = false;

        public static boolean checkCardBalance(Card c, double betAmount) {
            return cashToCard.get(c) >= betAmount;
        }

        public static void updateCardBalance(Card c, double amount) {
            if (cashToCard.containsKey(c)) {
                cashToCard.put(c, cashToCard.get(c) + amount);
            } else { // if the card was not in the hash map
                cashToCard.put(c, amount);
            }
        }

        public static Card issueCard() {
            Card card = new Card();
            // initial amount
            cashToCard.put(card, 0.0);
            bettingAuthority.logCardHandedOut(card, String.valueOf(LocalDateTime.now()));
            isLogCardHandedOut=true;
            return card;
        }

        public static double getCardBalance(Card card) {
           return cashToCard.get(card);
        }
    }
}

