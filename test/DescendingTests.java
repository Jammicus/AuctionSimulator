import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void correctPriceWinningBidderPaysDescending() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 200);
        Bidder bidderPrime = new Bidder(2, 125);
        Bidder bidderPrimePrime = new Bidder(3, 100);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 900).getPriceWinningBidderPays() == 200);
    }

    @Test
    public void bidderRuleLessThanTen() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 9);
        Bidder bidderPrime = new Bidder(2, 6);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 100).getPriceWinningBidderPays() == 9);
    }

    @Test
    public void bidderRuleLessThanOneHundred() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 97);
        Bidder bidderPrime = new Bidder(2, 70);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 1000).getPriceWinningBidderPays() == 90);
    }

    @Test
    public void bidderRuleLessThanOneThousand() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 923);
        Bidder bidderPrime = new Bidder(2, 500);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 10000).getPriceWinningBidderPays() == 900);
    }

    @Test
    public void bidderRuleGreaterThanOneThousand() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 9123);
        Bidder bidderPrime = new Bidder(2, 5000);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 10000).getPriceWinningBidderPays() == 9000);
    }


    @Test
    public void auctionWasEfficient() {
        Auction ds = new Descending();
        Bidder bidder = new Bidder(1, 9123);
        Bidder bidderPrime = new Bidder(2, 5000);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(ds.simulateAuction(listOfBidders, 10000).getWhetherAuctionWasEfficient() == true);
    }
}
