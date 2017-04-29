import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultProcessingTests {

    @Test
    public void calculateEfficiencyOneHundredPercent() {
        ResultProcessing rp = new ResultProcessing();
        List<Boolean> listOfResults = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfResults.add(true);
        }
        assertEquals(rp.calculateAuctionEfficiency(listOfResults), 1.00);
    }

    @Test
    public void calculateEfficiencyZeroPercent() {
        ResultProcessing rp = new ResultProcessing();
        List<Boolean> listOfResults = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfResults.add(false);
        }
        assertEquals(rp.calculateAuctionEfficiency(listOfResults), 0.00);
    }

    @Test
    public void calculateEfficiencyFiftyPercent() {
        ResultProcessing rp = new ResultProcessing();
        List<Boolean> listOfResults = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listOfResults.add(false);
            listOfResults.add(true);
        }
        assertEquals(rp.calculateAuctionEfficiency(listOfResults), 0.5);
    }


    @Test
    public void calculateAverageWinningBidTwoBidders() {
        ResultProcessing rp = new ResultProcessing();
        List<Auction> auctionResults = new ArrayList<>();
        Bidder bidder = new Bidder();
        Auction fp = new FirstPrice(bidder, 0, 100, true);
        auctionResults.add(fp);
        auctionResults.add(fp);

        assertEquals(100, rp.calculateAverageWinningBid(auctionResults));
    }

    @Test
    public void calculateAverageWinningBidTwoBiddersDecimals() {
        ResultProcessing rp = new ResultProcessing();
        List<Auction> auctionResults = new ArrayList<>();
        Bidder bidder = new Bidder();
        Auction fp = new FirstPrice(bidder, 0, 100.22, true);
        auctionResults.add(fp);
        auctionResults.add(fp);

        assertEquals(100.22, rp.calculateAverageWinningBid(auctionResults));
    }

    @Test
    public void calculateAverageWinningBidTwentyBidders() {
        ResultProcessing rp = new ResultProcessing();
        List<Auction> auctionResults = new ArrayList<>();
        Bidder bidder = new Bidder();
        Auction fp = new FirstPrice(bidder, 0, 100, true);
        Auction fpTwo = new FirstPrice(bidder, 0, 200, true);

        for (int i = 0; i < 10; i++) {
            auctionResults.add(fp);
            auctionResults.add(fpTwo);
        }

        assertEquals(150, rp.calculateAverageWinningBid(auctionResults));
    }

    @Test
    public void calculateAverageWinningBidTwentyBiddersDecimals() {
        ResultProcessing rp = new ResultProcessing();
        List<Auction> auctionResults = new ArrayList<>();
        Bidder bidder = new Bidder();
        Auction fp = new FirstPrice(bidder, 0, 100.11, true);
        Auction fpTwo = new FirstPrice(bidder, 0, 200.22, true);

        for (int i = 0; i < 10; i++) {
            auctionResults.add(fp);
            auctionResults.add(fpTwo);
        }

        assertEquals(150.165, rp.calculateAverageWinningBid(auctionResults), 0.001);
    }

    @Test
    public void calculateAverageWinningBidThreeHundredBidders() {
        ResultProcessing rp = new ResultProcessing();
        List<Auction> auctionResults = new ArrayList<>();
        Bidder bidder = new Bidder();
        Auction fp = new FirstPrice(bidder, 0, 100, true);
        Auction fpTwo = new FirstPrice(bidder, 0, 200, true);
        Auction fpThree = new FirstPrice(bidder, 0, 300, true);

        for (int i = 0; i < 100; i++) {
            auctionResults.add(fp);
            auctionResults.add(fpTwo);
            auctionResults.add(fpThree);
        }

        assertEquals(200, rp.calculateAverageWinningBid(auctionResults));
    }

    @Test
    public void calculateAverageWinningBidThreeHundredBiddersDecimals() {
        ResultProcessing rp = new ResultProcessing();
        List<Auction> auctionResults = new ArrayList<>();
        Bidder bidder = new Bidder();
        Auction fp = new FirstPrice(bidder, 0, 100.11, true);
        Auction fpTwo = new FirstPrice(bidder, 0, 200.22, true);
        Auction fpThree = new FirstPrice(bidder, 0, 300.33, true);

        for (int i = 0; i < 100; i++) {
            auctionResults.add(fp);
            auctionResults.add(fpTwo);
            auctionResults.add(fpThree);
        }

        assertEquals(200.22, rp.calculateAverageWinningBid(auctionResults), 0.001);
    }
}
