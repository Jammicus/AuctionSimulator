import java.util.List;

public class ResultProcessing {

    /*
    TO DO:
    Calculate the standard Deviation
    Calculate error bars?
     */

    public double calculateAuctionEfficiency(List<Auction> highestBidderWonResults) {
        double occurrencesOfTrue = 0;

        for (int i = 0; i < highestBidderWonResults.size(); i++) {
            if (highestBidderWonResults.get(i).getWhetherAuctionWasEfficient()==true) {
                occurrencesOfTrue++;
            }
        }

        return occurrencesOfTrue / (highestBidderWonResults.size()) * 100;
    }

    public double calculateAverageWinningBid(List<Auction> winningBidders) {
        double summedWinningBids = 0;

        for (int i = 0; i < winningBidders.size(); i++) {
            summedWinningBids += winningBidders.get(i).getPriceWinningBidderPays();
        }

        return summedWinningBids / winningBidders.size();
    }
}
