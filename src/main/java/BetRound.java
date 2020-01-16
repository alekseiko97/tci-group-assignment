import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BetRound {
    private int roundId;
    private String token;
    private List<Bet> listOfBets;

    public BetRound(){
        this.listOfBets = new ArrayList<>();
    }
    public LocalDateTime startRound(Bet bet) {
        return LocalDateTime.now();
    }

    public LocalDateTime endRound(Bet bet) {
        return LocalDateTime.now();
    }

    public Double placeBet(Bet bet, Double v) {
        return v;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }

    public List<Bet> getListOfBets() {
        return this.listOfBets;
    }
}
