import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstPrice implements Auction {

    private double finalAuctionValue;
    private double priceWinningBidderPays;
    private double initialBidderMoney;
    private int bidderID;

    public FirstPrice() {

    }
    
    public FirstPrice(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays){
        this.finalAuctionValue = finalAuctionValue;
        this.priceWinningBidderPays = priceWinningBidderPays;
        this.bidderID = winningBidder.getId();
        this.initialBidderMoney = winningBidder.getMoney();

    }

    //instead of returning a winning bidder, return the First price object with the details of the winning auction.
    //Will need to change UTs
    @Override
    public Bidder simulateAuction(List<Bidder> bidders, double auctionValue) {
        Bidder.sortBiddersByMoneyAscending(bidders);
        return winnerDetermination(bidders, auctionValue);
    }
    //Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays
    //T E S T
    @Override
    public Auction setAuctionResults(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays) {
        return new FirstPrice(winningBidder, finalAuctionValue, priceWinningBidderPays);
    }

    private Bidder winnerDetermination(List<Bidder> bidders, double auctionValue) {
        if (bidders.size() < 2) {
            return bidders.get(0);
        } else if (bidders.get(0).getMoney() == bidders.get(1).getMoney() && bidders.get(0).getMoney() >= auctionValue) {

            return biddersWithEqualValues(bidders);
        } else {
            return bidders.get(0);
        }
    }

    private Bidder biddersWithEqualValues(List<Bidder> bidders) {
        List<Bidder> tieBreakBidders = new ArrayList<>();
        Random random = new Random();
        double tieBreakValue = bidders.get(0).getMoney();

        for (int i = 0; i < bidders.size(); i++) {
            if (bidders.get(i).getMoney() == tieBreakValue) {
                tieBreakBidders.add(bidders.get(i));
            }
        }

        return tieBreakBidders.get(random.nextInt(tieBreakBidders.size() - 1) + 0);
    }
}
