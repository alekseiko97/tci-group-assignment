public class Casino {

    private BettingAuthority bettingAuthority;

    public Casino() {
        bettingAuthority = new BettingAuthority();
    }

    public BetRound createBetRound() {
        return new BetRound(bettingAuthority);
    }

    public String requestUniqueToken(String betRoundID) {
        return bettingAuthority.getUniqueToken(betRoundID);
    }
}
