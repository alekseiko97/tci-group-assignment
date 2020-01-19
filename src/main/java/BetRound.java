import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BetRound {
    private String roundId;
    private String token;
    private List<Bet> bets;
    private boolean isRunning;
    private double winningAmount;
    private BettingAuthority bettingAuthority;

    public BetRound(BettingAuthority bettingAuthority) {
        this.roundId = UUID.randomUUID().toString();
        this.bets = new ArrayList<Bet>();
        this.isRunning = false;
        this.bettingAuthority = bettingAuthority;
        this.winningAmount = 0.0;
    }

    public LocalDateTime startRound(String token) {
        if (token == null || token.isEmpty()) { throw new IllegalArgumentException("Token cannot be null or empty"); }
        // log
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStamp = Integer.toString(currentTime.getDayOfMonth()) + currentTime.getMonth() + currentTime.getYear();
        bettingAuthority.logBettingRound(UUID.randomUUID().toString(), timeStamp);
        // change the status
        isRunning = true;
        return LocalDateTime.now();
    }

    public Bet getWinningBet() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(bets.size()-1);
        return bets.get(randomIndex);
    }

    public LocalDateTime endRound(Bet winingBet) {
        if(!bets.contains(winingBet)){
            throw new IllegalArgumentException("This bet has not been placed in this round!");
        }
        //BetRound round, Bet winningBet, LocalDateTime now
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStamp = Integer.toString(currentTime.getDayOfMonth()) + currentTime.getMonth() + currentTime.getYear();
        isRunning = false;
        bettingAuthority.logEnd(this, winingBet, timeStamp);
        for(Bet bet : bets){
            winningAmount += bet.getInAmount();
        }
        return LocalDateTime.now();
    }

    public double getWinningAmount(){
        return this.winningAmount;
    }

    public void placeBet(Bet bet) {
        this.bets.add(bet);
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

    public String getBetRoundID() {
        return roundId;
    }

    public boolean getBetRoundStatus() {
        return this.isRunning;
    }

    public Integer getRandomValue(String token) {
        if (token == null || token.isEmpty()) { throw new IllegalArgumentException("Token cannot be null or empty"); }
        return this.bettingAuthority.getRandomWholeNumber(token);
    }
}
