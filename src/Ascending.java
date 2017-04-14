import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ascending implements Auction {
    private double finalAuctionValue;
    private double priceWinningBidderPays;
    private double initialBidderMoney;
    private int bidderID;

    public Ascending() {
    }

    public Ascending(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays) {
        this.finalAuctionValue = finalAuctionValue;
        this.priceWinningBidderPays = priceWinningBidderPays;
        this.bidderID = winningBidder.getId();
        this.initialBidderMoney = winningBidder.getMoney();
    }

    @Override
    public Auction simulateAuction(List<Bidder> bidders, double auctionValue) {
        Bidder winningBidder;
        double auctionValueHolder = 0;

        Bidder.sortBiddersByMoneyAscending(bidders);

        while (bidders.get(1).getMoney() >= auctionValue) {
            auctionValueHolder = auctionValue;
            auctionValue = biddingRules(auctionValue);
        }
        System.out.println(auctionValue);
        if (bidders.get(0).getMoney() < auctionValue) {
            auctionValue = auctionValueHolder;
        }

        winningBidder = (winnerDetermination(bidders, auctionValue));
        return new Ascending(winningBidder, winningBidder.getMoney(), auctionValue);
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
        } else if (bidders.get(0).getMoney() >= auctionValue && bidders.get(1).getMoney() >= auctionValue) {
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
        if (auctionValue >= 1000) {
            return auctionValue + 1000;
        } else if (auctionValue >= 100) {
            return auctionValue + 100;
        } else if (auctionValue >= 10) {
            return auctionValue + 10;
        } else {
            return auctionValue + 1;
        }
    }
}
