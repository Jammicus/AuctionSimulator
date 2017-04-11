
import java.util.List;

public interface Auction{

     Bidder simulateAuction(List<Bidder> bidders);

     Bidder winnerDetmination (List<Bidder> bidders);

}
