
import java.util.List;

public interface Auction {

    Auction simulateAuction(List<Bidder> bidders, double auctionValue);

    double getPriceWinningBidderPays();

    double getInitialBidderMoney();

    int getWinningBidderID();

    double getFinalAuctionValue();

    boolean getWhetherAuctionWasEfficient();

    boolean isAuctionEfficient(Bidder winningBidder, List<Bidder> sortedListOfBiddersFromHighToLow);

    void printAuctionResults();
}
