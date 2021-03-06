import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondPrice implements Auction {
    private double finalAuctionValue;
    private double priceWinningBidderPays;
    private double initialBidderMoney;
    private int bidderID;
    private boolean auctionEfficient;

    public SecondPrice() {
    }

    public SecondPrice(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays, boolean auctionEfficient) {
        this.finalAuctionValue = finalAuctionValue;
        this.priceWinningBidderPays = priceWinningBidderPays;
        this.bidderID = winningBidder.getId();
        this.initialBidderMoney = winningBidder.getMoney();
        this.auctionEfficient = auctionEfficient;
    }

    @Override
    public Auction simulateAuction(List<Bidder> bidders, double auctionValue) {
        Bidder winningBidder;
        Bidder.sortBiddersByMoneyAscending(bidders);
        winningBidder = (winnerDetermination(bidders, auctionValue));
        auctionEfficient = isAuctionEfficient(winningBidder, bidders);
        return new SecondPrice(winningBidder, winningBidder.getMoney(), bidders.get(1).getMoney(), auctionEfficient);
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
    public boolean getWhetherAuctionWasEfficient() {
        return auctionEfficient;
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

    //refactor this so it just takes the highest valued bidder, and the auction results.

    @Override
    public boolean isAuctionEfficient(Bidder winningBidder, List<Bidder> sortedListOfBiddersFromHighToLow) {
        if (winningBidder.getMoney() == sortedListOfBiddersFromHighToLow.get(0).getMoney()) {
            return true;
        } else {
            return false;
        }
    }

}
