
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
    
    void printAuctionResults();
}
