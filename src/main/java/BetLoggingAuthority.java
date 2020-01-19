import java.time.LocalDateTime;
import java.util.List;

public interface BetLoggingAuthority {
    void logBettingRound(String token, String timeStamp);
    void logEnd(BetRound round, Bet winningBet, String timestamp);
    void logCardHandedOut(Card c, String timeStamp);
    void logCardReturned(Card c, String timeStamp);
}
