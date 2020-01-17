public class Casino {

    private BettingAuthority bettingAuthority;

    public Casino(BettingAuthority bettingAuthority) {
        this.bettingAuthority = bettingAuthority;
    }

    public BetRound createBetRound() {
        return new BetRound(bettingAuthority);
    }

    public String requestUniqueToken(String betRoundID) {
        if (betRoundID == null || betRoundID.isEmpty()) throw new IllegalArgumentException("Bet round id can't be null or empty");
        return bettingAuthority.getUniqueToken(betRoundID);
    }

    public Integer requestRandomWholeNumber(String token) {
        return bettingAuthority.getRandomWholeNumber(token);
    }
}
