import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;

public class BettingAuthority implements BetLoggingAuthority, BetTokenAuthority {

    private Logger logger = Logger.getLogger(Logger.class.getName());

    public BettingAuthority() {}

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

    @Override
    public String getUniqueToken(String betRoundID) {
        return UUID.randomUUID().toString() + "_" + betRoundID;
    }
}
