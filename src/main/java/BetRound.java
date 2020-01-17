import java.time.LocalDateTime;
import java.util.List;

public class BetRound {
    private int roundId;
    private String token;

    public LocalDateTime startRound(Bet bet) {
        return LocalDateTime.now();
    }

    public LocalDateTime endRound(Bet bet) {
        return LocalDateTime.now();
    }

    public Double placeBet(Bet bet, double v) {
        return v;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }



}
