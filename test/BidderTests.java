import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by james_walter on 08/04/2017.
 */
public class BidderTests {
    @Test
    public void createBidder(){
        Bidder bidder = new Bidder(0,125);
        assertNotNull(bidder);
    }

    @Test
    public void assertBidderMoney(){
        Bidder bidder = new Bidder(0,125);
        assertEquals(bidder.getMoney(),125);
    }

    @Test
    public void assertBidderId(){
        Bidder bidder = new Bidder(0,125);
        assertEquals(bidder.getId(),0);
    }

    @Test
    public void setMoney() {
        Bidder bidder = new Bidder();
        bidder.setMoney(100.25);
        assertEquals(bidder.getMoney(),100.25);
    }

    @Test
    public void setId(){
        Bidder bidder = new Bidder();
        bidder.setId(10);
        assertEquals(bidder.getId(),10);
    }

    @Test
    public void addBiddersToList(){
        int numberOfBidders = 10;
        Bidder bidder = new Bidder();
        List<Bidder> bidderList = new ArrayList<>();
        bidderList = bidder.createBidders(10,0.0,100.0);
        assertEquals(10,bidderList.size());
    }

    @Test
    public void bidderValueAboveValue(){
        double moneyRangeLow = 0;
        int iterations = 100;
        Bidder bidder = new Bidder();
        List <Bidder> listOfBidders = new ArrayList<>();

        listOfBidders=bidder.createBidders(iterations,0,100);

        for ( int i = 0;  i < iterations; i ++) {
            assertTrue(listOfBidders.get(i).getMoney() >= 0);
        }
    }

    @Test
    public void bidderValueBelowValue() {
        double moneyRangeHigh = 100.00;
        int iterations = 100;
        Bidder bidder = new Bidder();
        List<Bidder> listOfBidders = new ArrayList<>();

        listOfBidders=bidder.createBidders(iterations,0,100);

        for (int i = 0; i < iterations; i++) {
            assertTrue(listOfBidders.get(i).getMoney() <= 100);
        }
    }
}
