import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecondPriceTests {
//Needs correct price tests


    @Test
    public void simulateAuctionTieBreakSecondPrice() {
        Auction sp = new SecondPrice();
        Bidder bidder = new Bidder(1, 123);
        Bidder bidderPrime = new Bidder(2, 123);
        Bidder bidderPrimePrime = new Bidder(3, 120);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue((sp.simulateAuction(listOfBidders, 100).getWinningBidderID()) == bidder.getId() ||
                (sp.simulateAuction(listOfBidders, 100).getWinningBidderID()) == bidderPrime.getId());
    }


    @Test
    public void simulateAuctionNoTieBreakSecondPrice() {
        Auction sp = new SecondPrice();
        Bidder bidder = new Bidder(1, 150);
        Bidder bidderPrime = new Bidder(2, 125);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(sp.simulateAuction(listOfBidders, 100).getWinningBidderID() == bidder.getId());
    }

    @Test
    public void bidderWithMoneyLessThanAuctionValueDoesNotWinSecondPrice() {
        Auction sp = new SecondPrice();
        Bidder bidder = new Bidder(1, 175);
        Bidder bidderPrime = new Bidder(2, 125);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);

        assertFalse(sp.simulateAuction(listOfBidders, 150).getWinningBidderID() == bidderPrime.getId());
    }

    @Test
    public void tieBreakSecondPrice() {
        Auction sp = new SecondPrice();
        Bidder bidder = new Bidder(1, 150);
        Bidder bidderPrime = new Bidder(2, 150);
        Bidder bidderPrimePrime = new Bidder(3, 100);
        Bidder bidderPrimePrimePrime = new Bidder(4, 125);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);
        listOfBidders.add(bidderPrimePrimePrime);

        assertTrue((sp.simulateAuction(listOfBidders, 100).getWinningBidderID() == bidder.getId())
                || sp.simulateAuction(listOfBidders, 100).getWinningBidderID() == bidderPrime.getId());
    }

    @Test
    public void correctPriceWinningBidderPaysSecondPrice() {
        Auction sp = new SecondPrice();
        Bidder bidder = new Bidder(1, 175);
        Bidder bidderPrime = new Bidder(2, 125);
        Bidder bidderPrimePrime = new Bidder(3, 100);

        List<Bidder> listOfBidders = new ArrayList<Bidder>();
        listOfBidders.add(bidder);
        listOfBidders.add(bidderPrime);
        listOfBidders.add(bidderPrimePrime);

        assertTrue(sp.simulateAuction(listOfBidders, 100).getPriceWinningBidderPays() == bidderPrime.getMoney());
    }

    @Test
    public void calculateAuctionEfficiencyTest(){
        Auction as = new Ascending();
        List<Boolean> listOfResults = new ArrayList<>();
        listOfResults.add(true);
        listOfResults.add(true);
        listOfResults.add(true);
        listOfResults.add(true);
        listOfResults.add(false);





        assertEquals(0.8,as.calculateAuctionEfficiency(listOfResults));

    }
}
