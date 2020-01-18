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


    public Bet(double inAmount) {

        this.inAmount = inAmount;
        this.betId=UUID.randomUUID();
        this.timestamp=LocalDateTime.now();
    }
}
