import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BetRound {
    private String roundId;
    private String token;
    private List<Bet> bets;
    private BettingAuthority bettingAuthority;

    public BetRound() {
        this.roundId = UUID.randomUUID().toString();
        this.bets = new ArrayList<Bet>();
        this.isRunning = false;
        this.bettingAuthority = bettingAuthority;
    }

    public LocalDateTime startRound() {
        isRunning = true;
        bettingAuthority.logBettingRound(UUID.randomUUID().toString(),LocalDateTime.now());
        return LocalDateTime.now();
    }

    public LocalDateTime endRound() {
        isRunning = false;
        return LocalDateTime.now();
    }

    public Double placeBet(Bet bet) {
        this.bets.add(bet);
        return 0.0;
    }

    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }

    public List<Bet> getListOfBets() {
        return this.bets;
    }
}
