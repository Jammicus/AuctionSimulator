import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondPrice implements Auction {
    private double finalAuctionValue;
    private double priceWinningBidderPays;
    private double initialBidderMoney;
    private int bidderID;


    public SecondPrice() {
    }

    public SecondPrice(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays) {
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
        return new SecondPrice(winningBidder, winningBidder.getMoney(), bidders.get(1).getMoney());
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

    @Override
    public double getFinalAuctionValue() {
        return finalAuctionValue;
    }


    @Override
    public void printAuctionResults() {
        System.out.println("The Final Auction Value is: " + getFinalAuctionValue());
        System.out.println("The price the winning bidder pays is: " + getPriceWinningBidderPays());
        System.out.println("The winning bidders ID is: " + getWinningBidderID());
        System.out.println("The money the bidder came to the auction with is: " + getInitialBidderMoney());
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
