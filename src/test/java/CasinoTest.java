import org.junit.Assert;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CasinoTest {

    Casino casino = new Casino();

    /**
     * This test should be successful if a new betting round object has been created without throwing any *exception
     * This test is intended to test the behavior of the method BetRound createBetRound()
     */

    @Test
    public void bettingRoundCreationShouldBeSuccessful() {
        // arrange & act
        BetRound betRound = casino.createBetRound();

        Assert.assertNotNull(betRound);
    }



    /**
     * This test should be successful if calling DOC’s method returns a randomly generated unique token
     * Valid betting round ID should be provided as a parameter
     * This test is intended to test the behavior of the method string getUniqueToken(UUID betRoundID)
     */

    @Test
    public void uniqueTokenCanBeObtainedFromAuthority() {
        throw new NotImplementedException();
    }

    /**
     * This test will succeed if the IllegalArgumentException is thrown when invalid betRoundID is given
     * This is to test the behavior of the method string getUniqueToken(UUID betRoundID)
     */

    @Test (expected = IllegalArgumentException.class)
    public void requestingTokenWithInvalidBettingRoundIDShouldThrowAnException() {
        throw new NotImplementedException();
    }

    /**
     * This test should be successful if calling DOC’s method returns a random whole number
     * Valid token should be provided
     * This is to test the behavior of the method int getRandomNumberFromAuthority(String token)
     */

    @Test
    public void randomWholeNumberCanBeObtainedFromAuthority() {
        throw new NotImplementedException();
    }

    /**
     * This test will succeed if IllegalArgumentException is thrown when invalid token is passed
     * This is to test the behavior of the method int getRandomNumberFromAuthority(String token)
     */

    @Test (expected = IllegalArgumentException.class)
    public void requestingRandomNumberWithInvalidTokenShouldThrowAnException() {
        throw new NotImplementedException();
    }


}
