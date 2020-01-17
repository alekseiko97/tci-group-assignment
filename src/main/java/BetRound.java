import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BetRound {
    private String roundId;
    private String token;
    private List<Bet> bets;
    private BettingAuthority bettingAuthority;

    public BetRound(BettingAuthority bettingAuthority) {
        this.roundId = UUID.randomUUID().toString();
        this.bets = new ArrayList<Bet>();
        this.bettingAuthority = bettingAuthority;
    }

    public LocalDateTime startRound() {

        bettingAuthority.logBettingRound(UUID.randomUUID().toString(),LocalDateTime.now());
        return LocalDateTime.now();
    }

    public LocalDateTime endRound(Bet winingBet) {
        //BetRound round, Bet winningBet, LocalDateTime now
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStamp = Integer.toString(currentTime.getDayOfMonth()) + currentTime.getMonth() + currentTime.getYear();

        bettingAuthority.logEnd(this, winingBet, timeStamp);
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
