import java.util.ArrayList;
import java.util.List;

public class Auctioneer {

    private static Auctioneer auctioneer;

    private static int resultPointer = 0;


    private Auctioneer() {

    }

    private List<Auction> listOfResults = new ArrayList<>();

    static {
        auctioneer = new Auctioneer();
    }

    public static Auctioneer getInstance() {
        return auctioneer;
    }

    public void prepareAuction(UserInput userInput) {
        List<Bidder> listOfBidders;
        if (userInput.getAuctionType().equalsIgnoreCase("ascending")) {
            for (int i = 0; i < userInput.getNumberOfSimulations(); i++, resultPointer++) {
                listOfBidders = Bidder.createBidders(userInput.getNumberOfBidders(), userInput.getLowerBoundBidderValue(), userInput.getUpperBoundBidderValue());
                System.out.println("Starting Ascending Auction number #" + i);
                Auction ascending = new Ascending();
                storeAuctionResults(ascending.simulateAuction(listOfBidders, 0));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (userInput.getAuctionType().equalsIgnoreCase("descending")) {
            for (int i = 0; i < userInput.getNumberOfSimulations(); i++, resultPointer++) {
                listOfBidders = Bidder.createBidders(userInput.getNumberOfBidders(), userInput.getLowerBoundBidderValue(), userInput.getUpperBoundBidderValue());
                System.out.println("Starting Descending Auction number #" + i);
                Auction descending = new Descending();
                storeAuctionResults(descending.simulateAuction(listOfBidders, userInput.getUpperBoundBidderValue() * 2));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (userInput.getAuctionType().equalsIgnoreCase("firstprice")) {
            for (int i = 0; i < userInput.getNumberOfSimulations(); i++, resultPointer++) {
                listOfBidders = Bidder.createBidders(userInput.getNumberOfBidders(), userInput.getLowerBoundBidderValue(), userInput.getUpperBoundBidderValue());
                System.out.println("Starting First Price Auction number #" + i);
                Auction firstPrice = new FirstPrice();
                storeAuctionResults(firstPrice.simulateAuction(listOfBidders, 0));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
            }
        } else if (userInput.getAuctionType().equalsIgnoreCase("secondprice")) {
            for (int i = 0; i < userInput.getNumberOfSimulations(); i++, resultPointer++) {
                listOfBidders = Bidder.createBidders(userInput.getNumberOfBidders(), userInput.getLowerBoundBidderValue(), userInput.getUpperBoundBidderValue());
                System.out.println("Starting Second Price Auction number #" + i);
                Auction secondPrice = new SecondPrice();
                storeAuctionResults(secondPrice.simulateAuction(listOfBidders, 0));
                System.out.println("Simulation Complete");
                listOfResults.get(resultPointer).printAuctionResults();
            }
        } else {
            System.out.println("Something went wrong, please restart the application");
            System.exit(1);
        }

        printResultProcessing(listOfResults);
    }

    private void storeAuctionResults(Auction auctionResults) {
        listOfResults.add(auctionResults);
    }

    private void printResultProcessing(List<Auction> auctionResults){
        ResultProcessing rp = new ResultProcessing();
        System.out.println("The average winning bid is " + rp.calculateAverageWinningBid(auctionResults));
        System.out.println("The auction was " + rp.calculateAuctionEfficiency(auctionResults)*100+"% efficient");
    }

    public int getNumberOfResults() {
        return listOfResults.size();
    }

    public void clearAuctionHistory() {
        resultPointer = 0;
        listOfResults.clear();
    }
}
