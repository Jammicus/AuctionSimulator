import java.util.List;


public class Ascending implements Auction {
    private double finalAuctionValue;
    private double priceWinningBidderPays;
    private double initialBidderMoney;
    private int bidderID;

    @Override
    public Auction simulateAuction(List<Bidder> bidders, double auctionValue) {
        return null;
    }

    @Override
    public Auction setAuctionResults(Bidder winningBidder, double finalAuctionValue, double priceWinningBidderPays) {
        return null;
    }

    @Override
    public double getFinalAuctionValue() {
        return finalAuctionValue;
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
}
