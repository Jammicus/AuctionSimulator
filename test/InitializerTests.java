import org.junit.After;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;



public class InitializerTests {

    @Test
    public void auctionResultsStoredCorrectListAscending(){
        Initializer initializer = new Initializer();
        initializer.prepareAuction("Ascending",10,0,100);
        initializer.prepareAuction("Ascending",10,0,100);
        assertEquals(2,initializer.getNumberOfResults());
        Initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListDescending(){
        Initializer initializer = new Initializer();
        initializer.prepareAuction("Descending",10,0,100);
        initializer.prepareAuction("Descending",10,0,100);
        initializer.prepareAuction("Descending",10,0,100);
        initializer.prepareAuction("Descending",10,0,100);
        assertEquals(4,initializer.getNumberOfResults());
        Initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListFirstprice(){
        Initializer initializer = new Initializer();
        initializer.prepareAuction("Firstprice",10,0,100);
        assertEquals(1,initializer.getNumberOfResults());
        Initializer.clearResults();
    }

    @Test
    public void auctionResultsStoredCorrectListSecondPrice(){
        Initializer initializer = new Initializer();
        initializer.prepareAuction("secondprice",10,0,100);
        initializer.prepareAuction("secondprice",10,0,100);
        initializer.prepareAuction("secondprice",10,0,100);
        assertEquals(3,initializer.getNumberOfResults());
        Initializer.clearResults();
    }


}
