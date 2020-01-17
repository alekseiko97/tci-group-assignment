import java.time.LocalDateTime;
import java.util.logging.Logger;

public class BettingAuthority {

    Logger logger = Logger.getLogger(Logger.class.getName());
    public void logBettingRound(String token, LocalDateTime timestamp) {
        logger.info("Log - Token: " + token + ", timestamp: " + timestamp);

    }
}
