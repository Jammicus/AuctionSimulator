import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class InitializerTests {

    @Test
    public void auctionResultsStoredCorrectListAscending() {
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction("Ascending", 10, 0, 100, 1);
        initializer.prepareAuction("Ascending", 10, 0, 100, 1);
        assertEquals(2, initializer.getNumberOfResults());
        initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListDescending() {
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction("Descending", 10, 0, 100, 1);
        initializer.prepareAuction("Descending", 10, 0, 100, 1);
        initializer.prepareAuction("Descending", 10, 0, 100, 1);
        initializer.prepareAuction("Descending", 10, 0, 100, 1);
        assertEquals(4, initializer.getNumberOfResults());
        initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListFirstprice() {
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction("Firstprice", 10, 0, 100, 1);
        assertEquals(1, initializer.getNumberOfResults());
        initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListSecondPrice() {
        Initializer initializer = Initializer.getInstance();
        initializer.prepareAuction("secondprice", 10, 0, 100, 1);
        initializer.prepareAuction("secondprice", 10, 0, 100, 1);
        initializer.prepareAuction("secondprice", 10, 0, 100, 1);
        assertEquals(3, initializer.getNumberOfResults());
        initializer.clearResults();
    }


}
