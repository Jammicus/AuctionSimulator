import java.util.List;


public class Descending implements Auction {
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
        return 0;
    }

    @Override
    public double getPriceWinningBidderPays() {
        return 0;
    }

    @Override
    public double getInitialBidderMoney() {
        return 0;
    }

    @Override
    public int getWinningBidderID() {
        return 0;
    }
}
