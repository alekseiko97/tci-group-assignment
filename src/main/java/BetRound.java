import java.time.LocalDateTime;

public class BetRound {
    public LocalDateTime startRound(Bet bet) {
        return LocalDateTime.now();
    }

    public LocalDateTime endRound(Bet bet) {
        return LocalDateTime.now();
    }

    public Double placeBet(Bet bet, double v) {
        return v;
    }
}
