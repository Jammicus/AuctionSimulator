import java.util.ArrayList;
import java.util.List;

public class Initializer {
    //Uses singleton pattern
    private static Initializer initializer;
    //Used to prevent wrong auction results being printed.
    private static int resultPointer = 0;

    private Initializer() {

    }

    private List<Auction> listOfResults = new ArrayList<>();

    static {
        initializer = new Initializer();
    }

    public static Initializer getInstance() {
        return initializer;
    }

    public void prepareAuction(String auctionType, int numberOfBidders, double lowerBoundBidderValue, double upperBoundBidderValue, int numberOfSimulations) {

        if (auctionType.equalsIgnoreCase("ascending")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting Ascending Auction");
                Auction ascending = new Ascending();
                initializer.storeAuctionResults(ascending.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), 0));
                System.out.println("Simulation Complete");
                initializer.listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (auctionType.equalsIgnoreCase("descending")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting Descending Auction");
                Auction descending = new Descending();
                initializer.storeAuctionResults(descending.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), upperBoundBidderValue * 2));
                System.out.println("Simulation Complete");
                initializer.listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (auctionType.equalsIgnoreCase("firstprice")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting First Price Auction");
                Auction firstPrice = new FirstPrice();
                initializer.storeAuctionResults(firstPrice.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), 0));
                System.out.println("Simulation Complete");
                initializer.listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (auctionType.equalsIgnoreCase("secondprice")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting Second Price Auction");
                Auction secondPrice = new SecondPrice();
                initializer.storeAuctionResults(secondPrice.simulateAuction(Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue), 0));
                System.out.println("Simulation Complete");
                initializer.listOfResults.get(resultPointer).printAuctionResults();
            }
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
        resultPointer = 0;
        listOfResults.clear();
    }

    public List<Auction> getResults() {
        return listOfResults;
    }
}
