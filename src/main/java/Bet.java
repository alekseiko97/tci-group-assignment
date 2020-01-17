import java.time.LocalDateTime;
import java.util.UUID;

public class Bet {

    private double inAmount;
    private UUID betId;
    private LocalDateTime timestamp;



    public Bet(double inAmount) {

        this.inAmount = inAmount;
        this.betId=UUID.randomUUID();
        this.timestamp=LocalDateTime.now();
    }
}
