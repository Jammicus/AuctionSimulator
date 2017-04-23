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
        return new Descending(winningBidder, auctionValue, auctionValue);
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
    public Boolean isAuctionEfficient(Bidder winningBidder, List<Bidder> sortedListOfBiddersFromHighToLow) {
        if (winningBidder.getId() == sortedListOfBiddersFromHighToLow.get(0).getId()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double calculateAuctionEfficiency(List<Boolean> highestBidderWonResults) {
        double occurrencesOfTrue = 0;
        for (int i = 0; i < highestBidderWonResults.size(); i++) {
            if (highestBidderWonResults.get(i).equals(true)) {
                occurrencesOfTrue++;
                System.out.println("Yes");
            }
        }
        return occurrencesOfTrue / (highestBidderWonResults.size());
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

            return biddersWithEqualValues(bidders, auctionValue);
        } else {
            return bidders.get(0);
        }
    }

    private Bidder biddersWithEqualValues(List<Bidder> bidders, double auctionValue) {
        List<Bidder> tieBreakBidders = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < bidders.size(); i++) {
            if (bidders.get(i).getMoney() >= auctionValue) {
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
