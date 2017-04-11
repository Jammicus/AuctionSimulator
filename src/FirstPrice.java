import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstPrice implements Auction {
    /**
     * Sort
     * Check return highest bidder
     * if a tiebreak, select one at random
     */
    @Override
    public Bidder simulateAuction(List<Bidder> bidders, double auctionValue) {
        Bidder.sortBiddersByMoneyAscending(bidders);
        return  winnerDetermination(bidders,auctionValue);
    }

    private Bidder winnerDetermination(List<Bidder> bidders,double auctionValue){
        if (bidders.size()<2){
            return bidders.get(0);
        }

        else if (bidders.get(0).getMoney() == bidders.get(1).getMoney()&& bidders.get(0).getMoney()>= auctionValue){
            List <Bidder> tieBreakBidders = new ArrayList<>();
            Random random =new Random();
            double tieBreakValue = bidders.get(0).getMoney();

            for (int i = 0; i < bidders.size();i++){
                if (bidders.get(i).getMoney() == tieBreakValue){
                    tieBreakBidders.add(bidders.get(i));
                }
            }

            return tieBreakBidders.get(random.nextInt(tieBreakBidders.size()-1)+0);
            }

        else {
            return bidders.get(0);
        }
    }

}
