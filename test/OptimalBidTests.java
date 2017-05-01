import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;

public class OptimalBidTests {

    @Test
    public void OptimalBidAuctioneerTestGreaterThanEqualZeroAscending() {
        UserInput ui = new UserInput("ascending", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() >= 0);
    }

    @Test
    public void OptimalBidAuctioneerTestLessThanOneHundredAndOneAscending() {
        UserInput ui = new UserInput("ascending", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() < 101);
    }

    @Test
    public void OptimalBidAuctioneerTestGreaterThanEqualZeroDescending() {
        UserInput ui = new UserInput("descending", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() >= 0);
    }

    @Test
    public void OptimalBidAuctioneerTestLessThanOneHundredAndOneDescending() {
        UserInput ui = new UserInput("descending", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() < 101);
    }

    @Test
    public void OptimalBidAuctioneerTestGreaterThanEqualZeroFirstPrice() {
        UserInput ui = new UserInput("Firstprice", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() >= 0);
    }

    @Test
    public void OptimalBidAuctioneerTestLessThanOneHundredAndOneFirstPrice() {
        UserInput ui = new UserInput("Firstprice", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() < 101);
    }


    @Test
    public void OptimalBidAuctioneerTestGreaterThanEqualZeroSecondPrice() {
        UserInput ui = new UserInput("secondprice", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() >= 0);
    }

    @Test
    public void OptimalBidAuctioneerTestLessThanOneHundredAndOneSecondPrice() {
        UserInput ui = new UserInput("secondprice", 10, 0, 100, 1);
        OptimalBidAuctioneer auctioneer = new OptimalBidAuctioneer();
        auctioneer.prepareOptimalBid(ui);
        assertTrue(auctioneer.prepareOptimalBid(ui).getOptimalPercentage() < 101);
    }

}
