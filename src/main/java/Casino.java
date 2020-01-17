public class Casino {

    public Casino() {}

    public BetRound createBetRound() {
        return new BetRound(new BettingAuthority());
    }
}
