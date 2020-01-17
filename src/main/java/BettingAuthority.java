import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

public class BettingAuthority implements BetLoggingAuthority {

    Logger logger = Logger.getLogger(Logger.class.getName());
    public void logBettingRound(String token, LocalDateTime timestamp) {
        logger.info("Log - Token: " + token + ", timestamp: " + timestamp);

    }


    @Override
    public void logCardHandedOut(Card c, LocalDateTime timeStamp) {

    }

    @Override
    public void logCardReturned(Card c, LocalDateTime timeStamp) {

    }

    public void logEnd(BetRound round, Bet winningBet, String timestamp) {
    }
}
