
import java.util.ArrayList;
import java.util.List;

public interface Auction{
     //To Store Auction Results
     //Need to think about this.
     List<Auction> auctionResults = new ArrayList<>();


     Auction simulateAuction(List<Bidder> bidders, double auctionValue);


     //Think about this method and getFinalAuctionValue;
     Auction setAuctionResults(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays);

     double getFinalAuctionValue();

     double getPriceWinningBidderPays();

     double getInitialBidderMoney();

     int getWinningBidderID();
}
