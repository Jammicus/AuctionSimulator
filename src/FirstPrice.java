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

    @Override
    public Auction simulateAuction(List<Bidder> bidders, double auctionValue) {
        Bidder winningBidder;
        Bidder.sortBiddersByMoneyAscending(bidders);
        winningBidder = (winnerDetermination(bidders, auctionValue));
        return new FirstPrice(winningBidder,winningBidder.getMoney(),winningBidder.getMoney());
    }

    @Override
    public double getPriceWinningBidderPays() {
        return priceWinningBidderPays;
    }

    @Override
    public double getInitialBidderMoney() {
        return initialBidderMoney;
    }

    @Override
    public int getWinningBidderID() {
        return bidderID;
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
