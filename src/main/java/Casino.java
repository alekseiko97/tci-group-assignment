public class Casino {

    private BettingAuthority bettingAuthority;

    public Casino(BettingAuthority bettingAuthority) {
        this.bettingAuthority = bettingAuthority;
    }

    public BetRound createBetRound() {
        return new BetRound(bettingAuthority);
    }

    public String requestUniqueToken(String betRoundID) {
        if (betRoundID == null || betRoundID.isEmpty())
        {
            throw new IllegalArgumentException("Bet round id can't be null or empty");
        }
        else {
            return this.bettingAuthority.getUniqueToken(betRoundID);
        }
    }

    public Integer requestRandomWholeNumber(String token) {
        if (token == null || token.isEmpty()) throw new IllegalArgumentException("Token can't be null or empty");
        return bettingAuthority.getRandomWholeNumber(token);
    }
}
