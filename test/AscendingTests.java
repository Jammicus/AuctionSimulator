import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertTrue(as.simulateAuction(listOfBidders, 0).getPriceWinningBidderPays() == 2000);
    }

    @Test
    public void bidderRuleLessThanTen() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 9);
        Bidder bidderPrime = new Bidder(2, 6);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders, 0).getPriceWinningBidderPays() == 7);
    }

    @Test
    public void bidderRuleLessThanOneHundred() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 90);
        Bidder bidderPrime = new Bidder(2, 70);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders, 0).getPriceWinningBidderPays() == 80);
    }

    @Test
    public void bidderRuleLessThanOneThousand() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 900);
        Bidder bidderPrime = new Bidder(2, 500);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders, 0).getPriceWinningBidderPays() == 600);
    }

    @Test
    public void bidderRuleGreaterThanOneThousand() {
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 9000);
        Bidder bidderPrime = new Bidder(2, 5000);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders, 0).getPriceWinningBidderPays() == 6000);
    }

    @Test
    public void auctionWasEfficient(){
        Auction as = new Ascending();
        Bidder bidder = new Bidder(1, 9000);
        Bidder bidderPrime = new Bidder(2, 5000);
        Bidder bidderPrimePrime = new Bidder(3, 1);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(as.simulateAuction(listOfBidders, 0).getWhetherAuctionWasEfficient() == true);
    }
}

