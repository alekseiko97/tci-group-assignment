import java.time.LocalDateTime;
import java.util.HashMap;

public class BankTeller {
    public static class Cashier {

        private static HashMap<Card, Double> cashToCard = new HashMap<>();
        public static BettingAuthority bettingAuthority = new BettingAuthority();
        public static boolean isLogCardHandedOut = false;

        /**
         * @param c
         * @param betAmount
         * @return false if amount on the card is less then betAmount
         * @return true if amount on the card is more then betAmount
         */
        public static boolean checkCardBalance(Card c, double betAmount) {
            return cashToCard.get(c) >= betAmount;
        }

        /**
         *
         * @param c
         * @param amount
         * If the amount <=0, the method will throw IllegalArgumentException
         */
        public static void updateCardBalance(Card c, double amount) {

            if(!cashToCard.containsKey(c)){
                throw new NullPointerException("Cashier does not know about this Card");
            }

            if(cashToCard.get(c) + amount < 0)
                  throw new IllegalArgumentException ("Can not withdraw more than current balance of the card");

            cashToCard.put(c, cashToCard.get(c) + amount);
        }

        public static Card issueCard() {
            Card card = new Card();
            // initial amount is 0.0
            cashToCard.put(card, 0.0);
            bettingAuthority.logCardHandedOut(card, String.valueOf(LocalDateTime.now()));
            isLogCardHandedOut=true;
            return card;
        }

        /**
         * When the method resetCard is called, it removed card from cashToCard list
         * And method returnCardToCashier() in Card class will be called.
         * @param card
         */
        public static void resetCard (Card card) {
            card.returnCardToCashier();
        }

        /**
         * @return the balance of a card
         */
        public static Double getCardBalance(Card card) {
           return cashToCard.get(card);
        }
    }
}

