public class Casino {

    private BettingAuthority bettingAuthority;

    public Casino(BettingAuthority bettingAuthority) {
        this.bettingAuthority = bettingAuthority;
    }

    public BetRound createBetRound() {
        return new BetRound(bettingAuthority);
    }

    public String requestUniqueToken(String betRoundID) {
        return bettingAuthority.getUniqueToken(betRoundID);
    }
}
