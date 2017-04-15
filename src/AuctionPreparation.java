import java.util.ArrayList;
import java.util.List;

public class AuctionPreparation {

    private static List<Auction> listOfAuctionResults = new ArrayList<>();

    public static void prepareAuction(String auctionType, int numberOfBidders, double lowerBoundBidderValue, double upperBoundBidderValue) {


    }

    private void storeAuctionResults(Auction auctionResults) {
        listOfAuctionResults.add(auctionResults);
    }


}
