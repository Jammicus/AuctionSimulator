import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionTests {

    //refactor
    @Test
    public void returnHighestBidder(){
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,100);
        Bidder bidderPrime = new Bidder(2,123);
        Bidder bidderPrimePrime = new Bidder(3,120);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);


        assertEquals(bidderPrime.getMoney(), (fp.simulateAuction(listOfBidders,250)).getMoney());

    }

    //First Price Tests

    @Test
    public void simulateFPAuctionTieBreak() {
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,123);
        Bidder bidderPrime = new Bidder(2,123);
        Bidder bidderPrimePrime = new Bidder(3,120);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(fp.simulateAuction(listOfBidders,100).equals(bidder) ||fp.simulateAuction(listOfBidders,100).equals(bidderPrime));
    }
    @Test
    public void simulateFPAuctionNoTieBreak() {
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,150);
        Bidder bidderPrime = new Bidder(2,125);
        Bidder bidderPrimePrime = new Bidder(3,100);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(fp.simulateAuction(listOfBidders,100).equals(bidder));

    }

    @Test
    public void bidderWithMoneyLessThanAuctionValueDoesNotWin(){
        Auction fp = new FirstPrice();
        Bidder bidder = new Bidder(1,175);
        Bidder bidderPrime = new Bidder(2,125);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        assertFalse(fp.simulateAuction(listOfBidders,150).equals(bidderPrime));
    }
}
