import java.util.HashMap;

public class BankTeller {
    public static class Cashier {

        private static HashMap<Card, Double> cashToCard = new HashMap<>();

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
            if(amount <= 0){
                throw new IllegalArgumentException ("Insufficient amount");
            }
            else{
                if (cashToCard.containsKey(c)) {
                    cashToCard.put(c, cashToCard.get(c) + amount);
                } else { // if the card was not in the hash map
                    cashToCard.put(c, amount);
                }
            }
        }
        public static Card issueCard() {
            Card card = new Card();
            // initial amount is 0.0
            cashToCard.put(card, 0.0);
            return card;
        }

        /**
         * When the method resetCard is called, it removed card from cashToCard list
         * And method returnCardToCashier() in Card class will be called.
         * @param card
         */
        public static void resetCard (Card card) {
            card.returnCardToCashier();
            cashToCard.remove(card);
        }
    }
}

