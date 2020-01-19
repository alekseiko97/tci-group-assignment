import java.time.LocalDateTime;
import java.util.UUID;

public class Bet {
    public double getInAmount() {
        return inAmount;
    }

    private double inAmount;

    public UUID getBetId() {
        return betId;
    }

    private UUID betId;
    private LocalDateTime timestamp;

    /**
     * When a bet is a placed, the bet inAmount should be more than 0
     * otherwise, IllegalArgumentException will be throw
     * @param inAmount
     */
    public Bet(double inAmount) {
        if(inAmount > 0){
            this.inAmount = inAmount;
            this.betId=UUID.randomUUID();
            this.timestamp=LocalDateTime.now();
        }
        else
            throw new IllegalArgumentException ("Bet can not be placed with insufficient amount!");

    }
}
