
import java.util.ArrayList;
import java.util.List;

public interface Auction {

    Auction simulateAuction(List<Bidder> bidders, double auctionValue);

    double getPriceWinningBidderPays();

    double getInitialBidderMoney();

    int getWinningBidderID();

    double getFinalAuctionValue();

    //split into another interface?
    Boolean isAuctionEfficient(Bidder winningBidder, List<Bidder> sortedListOfBiddersFromHighToLow);

    double calculateAuctionEfficiency(List<Boolean>highestBidderWonResults);

    void printAuctionResults();
}
