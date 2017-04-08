import java.util.List;


public interface Auction {

    public void simulateAuction(List<Bidder> bidders);

    public Bidder winnerDetmination (List<Bidder> bidders);

    public void auctionRules () ;
}
