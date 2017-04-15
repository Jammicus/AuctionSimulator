import java.util.ArrayList;
import java.util.List;

public class Initializer {
    //Uses singleton pattern
    private static Initializer initializer;

    private Initializer() {

    }

    private List<Auction> listOfResults = new ArrayList<>();

    static {
        initializer = new Initializer();
    }

    public static Initializer getInstance() {
        return initializer;
    }

    public void prepareAuction(String auctionType, int numberOfBidders, double lowerBoundBidderValue, double upperBoundBidderValue) {

        if (auctionType.equalsIgnoreCase("ascending")) {
            Auction ascending = new Ascending();
            initializer.storeAuctionResults(ascending.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), 0));
            System.out.println("Simulation Complete");
            initializer.listOfResults.get(0).printAuctionResults();
        } else if (auctionType.equalsIgnoreCase("descending")) {
            Auction descending = new Descending();
            initializer.storeAuctionResults(descending.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), upperBoundBidderValue * 2));
            System.out.println("Simulation Complete");
            initializer.listOfResults.get(0).printAuctionResults();
        } else if (auctionType.equalsIgnoreCase("firstprice")) {
            Auction firstPrice = new FirstPrice();
            initializer.storeAuctionResults(firstPrice.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), 0));
            System.out.println("Simulation Complete");
            initializer.listOfResults.get(0).printAuctionResults();
        } else if (auctionType.equalsIgnoreCase("secondprice")) {
            Auction secondPrice = new SecondPrice();
            initializer.storeAuctionResults(secondPrice.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), 0));
            System.out.println("Simulation Complete");
            initializer.listOfResults.get(0).printAuctionResults();
        } else {
            System.out.println("Oh nooooo");
        }
    }

    private void storeAuctionResults(Auction auctionResults) {
        listOfResults.add(auctionResults);
    }

    public int getNumberOfResults() {
        return listOfResults.size();
    }

    public void clearResults() {
        listOfResults.clear();
    }
}