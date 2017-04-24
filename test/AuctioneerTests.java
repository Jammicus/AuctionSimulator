import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class AuctioneerTests {

    @Test
    public void auctionResultsStoredCorrectListAscending() {
        UserInput ui = new UserInput("Ascending", 10, 0, 100, 1);
        Auctioneer auctioneer = Auctioneer.getInstance();
        auctioneer.prepareAuction(ui);
        auctioneer.prepareAuction(ui);
        assertEquals(2, auctioneer.getNumberOfResults());
        auctioneer.clearAuctionHistory();
    }

    @Test
    public void auctionResultsStoredCorrectListDescending() {
        UserInput ui = new UserInput("Descending", 10, 0, 100, 1);
        Auctioneer auctioneer = Auctioneer.getInstance();
        auctioneer.prepareAuction(ui);
        auctioneer.prepareAuction(ui);
        auctioneer.prepareAuction(ui);
        auctioneer.prepareAuction(ui);
        assertEquals(4, auctioneer.getNumberOfResults());
        auctioneer.clearAuctionHistory();
    }

    @Test
    public void auctionResultsStoredCorrectListFirstprice() {
        UserInput ui = new UserInput("Firstprice", 10, 0, 100, 1);
        Auctioneer auctioneer = Auctioneer.getInstance();
        auctioneer.prepareAuction(ui);
        assertEquals(1, auctioneer.getNumberOfResults());
        auctioneer.clearAuctionHistory();
    }

    @Test
    public void auctionResultsStoredCorrectListSecondPrice() {
        UserInput ui = new UserInput("secondprice", 10, 0, 100, 1);
        Auctioneer auctioneer = Auctioneer.getInstance();
        auctioneer.prepareAuction(ui);
        auctioneer.prepareAuction(ui);
        auctioneer.prepareAuction(ui);
        assertEquals(3, auctioneer.getNumberOfResults());
        auctioneer.clearAuctionHistory();
    }


}
