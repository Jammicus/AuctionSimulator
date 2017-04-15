
import java.util.List;

public interface Auction {

    Auction simulateAuction(List<Bidder> bidders, double auctionValue);

    double getPriceWinningBidderPays();

    double getInitialBidderMoney();

    int getWinningBidderID();

    double getFinalAuctionValue();

    void printAuctionResults();
}
