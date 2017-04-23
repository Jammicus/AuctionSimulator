
import java.util.List;

public interface Auction {

    Auction simulateAuction(List<Bidder> bidders, double auctionValue);

    double getPriceWinningBidderPays();

    double getInitialBidderMoney();

    int getWinningBidderID();

    double getFinalAuctionValue();

    default Boolean isAuctionEfficient(Bidder winningBidder, List<Bidder> sortedListOfBiddersFromHighToLow){
        if (winningBidder.getId()== sortedListOfBiddersFromHighToLow.get(0).getId()){
            return true;
        }
        else{
            return false;
        }
    };

    default double calculateAuctionEfficiency(List<Boolean> highestBidderWonResults){
        double occurrencesOfTrue = 0;
        for (int i = 0; i < highestBidderWonResults.size(); i++) {
            if (highestBidderWonResults.get(i).equals(true)) {
                occurrencesOfTrue++;
                System.out.println("Yes");
            }
        }
        return occurrencesOfTrue / (highestBidderWonResults.size());
    }

    void printAuctionResults();
}
