import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class CashierTest {


    /**
     * This test should be passed when a new card is given to the gambler successfully by the cashier
     * This is created to test Card issueCard() method
     */
    @Test
    public void aNewCardShouldBeAssignedToGamblerSuccessfully(){
        //arrange
        Cashier cashier = new Cashier();
        DayOfWeek expectedDate = LocalDateTime.now().getDayOfWeek();
        Month expectedMonth = LocalDateTime.now().getMonth();
        int expectedHour = LocalDateTime.now().getHour();
        //act
        Card actualCard = cashier.issueCard();

        //assert
        Assert.assertEquals("Card is not created correctly by cashier", expectedMonth, actualCard.getTimestamp().getMonth());
        Assert.assertEquals("Card is not created correctly by cashier", expectedDate, actualCard.getTimestamp().getDayOfWeek());
        Assert.assertEquals("Card is not created correctly by cashier", expectedHour, actualCard.getTimestamp().getHour());
    }

    /**
     * This test should throw exception when updating the credit on the card with the insufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateCardBalanceWithInsufficientAmountShouldThrowException(){

    }

    /**
     * This test should be passed when updating the credit on the card with the sufficient amount
     * This test is created to test void updateCardCredit(Card c, double amount) method
     */
    @Test
    public void updateCardBalanceWithSufficientAmountShouldBeSuccessful(){

    }

    /**
     * This test should be passed when a card is handed back to the cashier successfully
     * This test is created to test void resetCard(Card c) method
     */
    @Test
    public void cardSuccessfullyReset(){

    }

}
