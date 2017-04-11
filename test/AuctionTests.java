import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionTests {


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


        assertEquals(bidderPrime.getMoney(), (fp.simulateAuction(listOfBidders)).getMoney());

    }
}
