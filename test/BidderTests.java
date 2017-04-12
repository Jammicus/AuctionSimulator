import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BidderTests {

    @Test
    public void createBidder() {
        Bidder bidder = new Bidder(0, 125);
        assertNotNull(bidder);
    }

    @Test
    public void assertBidderMoney() {
        Bidder bidder = new Bidder(0, 125);
        assertEquals(bidder.getMoney(), 125);
    }

    @Test
    public void assertBidderId() {
        Bidder bidder = new Bidder(0, 125);
        assertEquals(bidder.getId(), 0);
    }

    @Test
    public void setMoney() {
        Bidder bidder = new Bidder();
        bidder.setMoney(100.25);
        assertEquals(bidder.getMoney(), 100.25);
    }

    @Test
    public void setId() {
        Bidder bidder = new Bidder();
        bidder.setId(10);
        assertEquals(bidder.getId(), 10);
    }

    @Test
    public void addBiddersToList() {
        Bidder bidder = new Bidder();
        List<Bidder> bidderList;
        bidderList = bidder.createBidders(10, 0.0, 100.0);
        assertEquals(10, bidderList.size());
    }

    @Test
    public void bidderValueAboveValue() {
        int iterations = 100;
        Bidder bidder = new Bidder();
        List<Bidder> listOfBidders;

        listOfBidders = bidder.createBidders(iterations, 0, 100);

        for (int i = 0; i < iterations; i++) {
            assertTrue(listOfBidders.get(i).getMoney() >= 0);
        }
    }

    @Test
    public void bidderValueBelowValue() {
        int iterations = 100;
        List<Bidder> listOfBidders;

        listOfBidders = Bidder.createBidders(iterations, 0, 100);

        for (int i = 0; i < iterations; i++) {
            assertTrue(listOfBidders.get(i).getMoney() <= 100);
        }
    }

    @Test
    public void biddersSortedByHighestMoneyValue() {
        int iterations = 100;
        Bidder bidder = new Bidder();
        List<Bidder> listOfBidders;

        listOfBidders = bidder.createBidders(iterations, 0, 100);

        for (int i = 0; i < iterations; i++) {
            assertTrue(listOfBidders.get(i).getMoney() <= 100);
        }

        Bidder.sortBiddersByMoneyAscending(listOfBidders);

        for (int i = 0; i < iterations - 1; i++) {
            assertTrue(listOfBidders.get(i).getMoney() >= listOfBidders.get(i + 1).getMoney());
        }
    }


}
