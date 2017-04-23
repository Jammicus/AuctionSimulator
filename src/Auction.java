
import java.util.List;

public interface Auction {

    Auction simulateAuction(List<Bidder> bidders, double auctionValue);

    double getPriceWinningBidderPays();

    double getInitialBidderMoney();

    int getWinningBidderID();

    double getFinalAuctionValue();

    boolean getWhetherAuctionWasEfficient();

    default Boolean isAuctionEfficient(Bidder winningBidder, List<Bidder> sortedListOfBiddersFromHighToLow) {
        if (winningBidder.getMoney() == sortedListOfBiddersFromHighToLow.get(0).getMoney()) {
            return true;
        } else {
            return false;
        }
    }

    //Move this to a class that produces stats on the auction.
    default double calculateAuctionEfficiency(List<Boolean> highestBidderWonResults) {
        double occurrencesOfTrue = 0;
        for (int i = 0; i < highestBidderWonResults.size(); i++) {
            if (highestBidderWonResults.get(i).equals(true)) {
                occurrencesOfTrue++;
            }
        }
        return occurrencesOfTrue / (highestBidderWonResults.size());
    }

    void printAuctionResults();
}
