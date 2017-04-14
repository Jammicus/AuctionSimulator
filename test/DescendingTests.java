import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DescendingTests {

    @Test
    public void simulateAuctionTieBreakSecondPrice() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 200);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue((ds.simulateAuction(listOfBidders, 900).getWinningBidderID()) == bidder.getId() ||
                (ds.simulateAuction(listOfBidders, 900).getWinningBidderID()) == bidderPrime.getId());
    }


    @Test
    public void simulateAuctionNoTieBreakSecondPrice() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 150);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 900).getWinningBidderID() == bidder.getId());
    }

    @Test
    public void bidderWithMoneyLessThanAuctionValueDoesNotWinSecondPrice() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 100);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);

        assertFalse(ds.simulateAuction(listOfBidders, 900).getWinningBidderID() == bidderPrime.getId());
    }

    @Test
    public void tieBreakSecondPrice() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 200);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        Bidder bidderPrimePrimePrime = new Bidder(4, 125);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);
        listOfBidders.add(bidderPrimePrimePrime);

        assertTrue((ds.simulateAuction(listOfBidders, 900).getWinningBidderID() == bidder.getId())
                || ds.simulateAuction(listOfBidders, 900).getWinningBidderID() == bidderPrime.getId());
    }

    @Test
    public void correctPriceWinningBidderPaysSecondPrice() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 125);
        Bidder bidderPrimePrime = new Bidder(3, 100);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 900).getPriceWinningBidderPays() == bidderPrime.getMoney());
    }
}
