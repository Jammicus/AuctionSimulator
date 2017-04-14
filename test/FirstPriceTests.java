import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstPriceTests {

    //Bidder
    @Test
    public void returnHighestBidderFirstPrice(){
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,100);
        Bidder bidderPrime = new Bidder(2,123);
        Bidder bidderPrimePrime = new Bidder(3,120);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertEquals(bidderPrime.getMoney(), (fp.simulateAuction(listOfBidders,250)).getInitialBidderMoney());

    }

    //First Price Tests

    @Test
    public void simulateAuctionTieBreakFirstPrice() {
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,123);
        Bidder bidderPrime = new Bidder(2,123);
        Bidder bidderPrimePrime = new Bidder(3,120);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue((fp.simulateAuction(listOfBidders,100).getWinningBidderID()) == bidder.getId() ||
                (fp.simulateAuction(listOfBidders,100).getWinningBidderID()) == bidderPrime.getId());
    }

    @Test
    public void simulateAuctionNoTieBreakFirstPrice() {
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,150);
        Bidder bidderPrime = new Bidder(2,125);
        Bidder bidderPrimePrime = new Bidder(3,100);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(fp.simulateAuction(listOfBidders,100).getWinningBidderID() == bidder.getId());
    }

    @Test
    public void bidderWithMoneyLessThanAuctionValueDoesNotWinFirstPrice(){
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,175);
        Bidder bidderPrime = new Bidder(2,125);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);

        assertFalse(fp.simulateAuction(listOfBidders,150).getWinningBidderID() == bidderPrime.getId());
    }

    @Test
    public void tieBreakFirstPrice(){
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,150);
        Bidder bidderPrime = new Bidder(2,150);
        Bidder bidderPrimePrime = new Bidder(3,100);
        Bidder bidderPrimePrimePrime = new Bidder(4,125);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);
        listOfBidders.add(bidderPrimePrimePrime);

        assertTrue((fp.simulateAuction(listOfBidders,100).getWinningBidderID()==bidder.getId())
                ||fp.simulateAuction(listOfBidders,100).getWinningBidderID()==bidderPrime.getId());
    }
}
