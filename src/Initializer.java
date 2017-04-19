import java.util.ArrayList;
import java.util.List;

public class Initializer {

    private static Initializer initializer;

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
        List<Bidder> listOfBidders = Bidder.createBidders(numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue);

        if (auctionType.equalsIgnoreCase("ascending")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting Ascending Auction number #" + i);
                Auction ascending = new Ascending();
                storeAuctionResults(ascending.simulateAuction(listOfBidders, 0));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (auctionType.equalsIgnoreCase("descending")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting Descending Auction number #" + i);
                Auction descending = new Descending();
                storeAuctionResults(descending.simulateAuction(listOfBidders, upperBoundBidderValue * 2));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (auctionType.equalsIgnoreCase("firstprice")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting First Price Auction number #" + i);
                Auction firstPrice = new FirstPrice();
                storeAuctionResults(firstPrice.simulateAuction(listOfBidders, 0));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (auctionType.equalsIgnoreCase("secondprice")) {
            for (int i = 0; i < numberOfSimulations; i++, resultPointer++) {
                System.out.println("Starting Second Price Auction number #" + i);
                Auction secondPrice = new SecondPrice();
                storeAuctionResults(secondPrice.simulateAuction(listOfBidders, 0));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
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
}
