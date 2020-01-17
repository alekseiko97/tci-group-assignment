import java.time.LocalDateTime;
import java.util.List;

public interface BetLoggingAuthority {
    void logBettingRound(String token, LocalDateTime timeStamp);
    void logEnd(List<Bet> bets, List<String> tokens, LocalDateTime timeStamp);
    void logCardHandedOut(Card c, LocalDateTime timeStamp);
    void logCardReturned(Card c, LocalDateTime timeStamp);
}
