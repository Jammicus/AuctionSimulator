
import java.util.List;


public interface Auction {

     void simulateAuction(List<Bidder> bidders);

     Bidder winnerDetmination (List<Bidder> bidders);

}
