import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BetRound {
    private String roundId;
    private String token;
    private List<Bet> bets;

    public BetRound() {
        this.roundId = UUID.randomUUID().toString();
        this.bets = new ArrayList<Bet>();
    }

    public LocalDateTime startRound() {
        return LocalDateTime.now();
    }

    public LocalDateTime endRound() {

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
