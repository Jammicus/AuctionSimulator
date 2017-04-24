import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class AuctioneerTests {

    @Test
    public void auctionResultsStoredCorrectListAscending() {
        UserInput ui = new UserInput("Ascending", 10, 0, 100, 1);
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction(ui);
        initializer.prepareAuction(ui);
        assertEquals(2, initializer.getNumberOfResults());
        initializer.clearAuctionHistory();
    }

    @Test
    public void auctionResultsStoredCorrectListDescending() {
        UserInput ui = new UserInput("Descending", 10, 0, 100, 1);
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction(ui);
        initializer.prepareAuction(ui);
        initializer.prepareAuction(ui);
        initializer.prepareAuction(ui);
        assertEquals(4, initializer.getNumberOfResults());
        initializer.clearAuctionHistory();
    }

    @Test
    public void auctionResultsStoredCorrectListFirstprice() {
        UserInput ui = new UserInput("Firstprice", 10, 0, 100, 1);
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction(ui);
        assertEquals(1, initializer.getNumberOfResults());
        initializer.clearAuctionHistory();
    }

    @Test
    public void auctionResultsStoredCorrectListSecondPrice() {
        UserInput ui = new UserInput("secondprice", 10, 0, 100, 1);
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction(ui);
        initializer.prepareAuction(ui);
        initializer.prepareAuction(ui);
        assertEquals(3, initializer.getNumberOfResults());
        initializer.clearAuctionHistory();
    }


}
