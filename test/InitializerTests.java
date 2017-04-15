import org.junit.After;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class InitializerTests {

    @Test
    public void auctionResultsStoredCorrectListAscending() {
        Initializer.prepareAuction("Ascending", 10, 0, 100);
        Initializer.prepareAuction("Ascending", 10, 0, 100);
        assertEquals(2, Initializer.getNumberOfResults());
        Initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListDescending() {
        Initializer.prepareAuction("Descending", 10, 0, 100);
        Initializer.prepareAuction("Descending", 10, 0, 100);
        Initializer.prepareAuction("Descending", 10, 0, 100);
        Initializer.prepareAuction("Descending", 10, 0, 100);
        assertEquals(4, Initializer.getNumberOfResults());
        Initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListFirstprice() {
        Initializer.prepareAuction("Firstprice", 10, 0, 100);
        assertEquals(1, Initializer.getNumberOfResults());
        Initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListSecondPrice() {
        Initializer.prepareAuction("secondprice", 10, 0, 100);
        Initializer.prepareAuction("secondprice", 10, 0, 100);
        Initializer.prepareAuction("secondprice", 10, 0, 100);
        assertEquals(3, Initializer.getNumberOfResults());
        Initializer.clearResults();
    }


}
