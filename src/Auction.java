
import java.util.ArrayList;
import java.util.List;

public interface Auction{
     //To Store Auction Results

     List<Auction> auctionResults = new ArrayList<>();

     //Return auction object with the relevant details???
     Auction simulateAuction(List<Bidder> bidders, double auctionValue);
     //Think about Params here

     Auction setAuctionResults(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays);

     double getFinalAuctionValue();

     double getPriceWinningBidderPays();

     double getInitialBidderMoney();

     int getWinningBidderID()

//     private double finalAuctionValue;
//     private double priceWinningBidderPays;
//     private double initialBidderMoney;
//     private int bidderID;
}
