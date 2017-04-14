import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AscendingTests {


    @Test
    public void simulateAuctionTieBreakAscending() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 200);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue((as.simulateAuction(listOfBidders, 0).getWinningBidderID()) == bidder.getId() ||
                (as.simulateAuction(listOfBidders, 0).getWinningBidderID()) == bidderPrime.getId());
    }

    @Test
    public void simulateAuctionNoTieBreakAscending() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 150);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders, 0).getWinningBidderID() == bidder.getId());
    }

    @Test
    public void bidderWithMoneyLessThanAuctionValueDoesNotWinAscending() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 100);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);

        assertFalse(as.simulateAuction(listOfBidders, 0).getWinningBidderID() == bidderPrime.getId());
    }

    @Test
    public void tieBreakAscending() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 200);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        Bidder bidderPrimePrimePrime = new Bidder(4, 125);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);
        listOfBidders.add(bidderPrimePrimePrime);

        assertTrue((as.simulateAuction(listOfBidders, 0).getWinningBidderID() == bidder.getId())
                || as.simulateAuction(listOfBidders, 0).getWinningBidderID() == bidderPrime.getId());
    }

    @Test
    public void correctPriceWinningBidderPaysAscending() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 10);
        Bidder bidderPrime = new Bidder(2, 5);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders, 0).getPriceWinningBidderPays() == 6);
    }


    @Test
    public void correctPriceWithTieBreakAscending() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 2000);
        Bidder bidderPrime = new Bidder(2, 2000);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders,0).getPriceWinningBidderPays()==2000);
    }
}
