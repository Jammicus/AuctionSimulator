
import java.util.ArrayList;
import java.util.List;

public interface Auction{
     //To Store Auction Results
     List<Auction> auctionResults = new ArrayList<>();

     //Return auction object with the relevant details???
     Bidder simulateAuction(List<Bidder> bidders, double auctionValue);
     //Think about Params here

     Auction setAuctionResults(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays);
}
