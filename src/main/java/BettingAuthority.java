import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

public class BettingAuthority implements BetLoggingAuthority, BetTokenAuthority {

    private Logger logger = Logger.getLogger(Logger.class.getName());

    public BettingAuthority() {}
    @Override
    public void logBettingRound(String token, LocalDateTime timestamp) {
        logger.info("Log - Token: " + token + ", timestamp: " + timestamp);

    }

    @Override
    public void logCardHandedOut(Card c, String timeStamp) {
        logger.info("Log - CardId: " + c.getCardId() + ", timestamp: " + timeStamp);

    }

    @Override
    public void logCardReturned(Card c, String timeStamp) {

    }
    @Override
    public void logEnd(BetRound round, Bet winningBet, String timestamp) {
        logger.info("Log - BetId: " + winningBet.getBetId() + ", timestamp: " + timestamp);
    }

    @Override
    public String getUniqueToken(String betRoundID) {
        return UUID.randomUUID().toString() + "_" + betRoundID;
    }

    @Override
    public Integer getRandomWholeNumber(String token) {
        return new Random().nextInt();
    }
}
