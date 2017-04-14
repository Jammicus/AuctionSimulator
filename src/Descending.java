import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Descending implements Auction {
    private double finalAuctionValue;
    private double priceWinningBidderPays;
    private double initialBidderMoney;
    private int bidderID;

    public Descending() {
    }

    public Descending(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays) {
        this.finalAuctionValue = finalAuctionValue;
        this.priceWinningBidderPays = priceWinningBidderPays;
        this.bidderID = winningBidder.getId();
        this.initialBidderMoney = winningBidder.getMoney();
    }

    @Override
    public Auction simulateAuction(List<Bidder> bidders, double auctionValue) {
        Bidder winningBidder;
        Bidder.sortBiddersByMoneyAscending(bidders);

        while (bidders.get(0).getMoney() < auctionValue) {
            auctionValue = biddingRules(auctionValue);
        }

        winningBidder = (winnerDetermination(bidders, auctionValue));
        return new Descending(winningBidder, winningBidder.getMoney(), auctionValue);
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

    private double biddingRules(double auctionValue) {
        if (auctionValue >= 2000) {
            return auctionValue - 1000;
        } else if (auctionValue >= 200) {
            return auctionValue - 100;
        } else if (auctionValue >= 20) {
            return auctionValue - 10;
        } else {
            return auctionValue - 1;
        }
    }
}
