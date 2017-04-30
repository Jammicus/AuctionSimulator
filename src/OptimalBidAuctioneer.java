import java.util.List;

public class OptimalBidAuctioneer {
    int numberOfSimulations = 1000;
    double[] optimalBidArray = new double[101];
    int optimalPercentage;

    public OptimalBidAuctioneer() {
    }

    public OptimalBidAuctioneer(int numberOfSimulations, int optimalPercentageResult) {
        this.numberOfSimulations = numberOfSimulations;
        this.optimalPercentage = optimalPercentageResult;
    }

    public OptimalBidAuctioneer prepareOptimalBid(UserInput userInput) {
        List<Bidder> listOfBidders;
        Auction auctionResult = null;
        Bidder ourBidder;
        int optimalBid;
        double maxBidderValue = userInput.getUpperBoundBidderValue();

        for (int j = 0; j <= 100; j++) {
            for (int i = 0; i < 1000; i++) {
                listOfBidders = Bidder.createBidders(userInput.getNumberOfBidders(), userInput.getLowerBoundBidderValue(),
                        userInput.getUpperBoundBidderValue());

                ourBidder = listOfBidders.get(0);

                ourBidder.setMoney(maxBidderValue);
                ourBidder.changeBiddersValueByPercentage(ourBidder, j);
                listOfBidders.set(0, ourBidder);

                //break this up?
                if (userInput.getAuctionType().equalsIgnoreCase("ascending")) {
                    Auction ascending = new Ascending();
                    auctionResult = ascending.simulateAuction(listOfBidders, 0);
                } else if (userInput.getAuctionType().equalsIgnoreCase("descending")) {
                    Auction descending = new Descending();
                    auctionResult = descending.simulateAuction(listOfBidders, 0);
                } else if (userInput.getAuctionType().equalsIgnoreCase("firstprice")) {
                    Auction firstprice = new FirstPrice();
                    auctionResult = firstprice.simulateAuction(listOfBidders, 0);
                } else if (userInput.getAuctionType().equalsIgnoreCase("secondprice")) {
                    Auction secondprice = new SecondPrice();
                    auctionResult = secondprice.simulateAuction(listOfBidders, 0);
                }

                //Boolean method?
                if (auctionResult.getWinningBidderID() == ourBidder.getId()) {

                    optimalBidArray[j] = optimalBidArray[j] + 1;
                }
            }
        }
        optimalBid = findIndexWithOptimalBid(calculateOptimalBid(optimalBidArray, maxBidderValue));
        return new OptimalBidAuctioneer(numberOfSimulations, optimalBid);
    }


    private double[] calculateOptimalBid(double[] winsAtPercentage, double maxBidderValue) {
        double[] calculatedResults = new double[101];

        for (int i = 0; i < winsAtPercentage.length; i++) {
            double calculatedResult = 0;
            Bidder tempBidder = new Bidder();
            tempBidder.setMoney(maxBidderValue);
            double probablity = winsAtPercentage[i] / numberOfSimulations;
            tempBidder.changeBiddersValueByPercentage(tempBidder, i);
            double bid = tempBidder.getMoney();
            double privateValueMinusBid = maxBidderValue - bid;

            if (probablity != 0.0) {
                calculatedResult = (privateValueMinusBid * probablity);
            }


            calculatedResults[i] = calculatedResult;
        }
        return calculatedResults;
    }

    private int findIndexWithOptimalBid(double[] listOfResults) {
        double tempValue = 0;
        int index = 0;

        for (int i = 0; i < listOfResults.length; i++) {
            if (listOfResults[i] > tempValue) {
                tempValue = listOfResults[i];

                index = i;
            }
        }
        return index;
    }

    public int getOptimalPercentage() {
        return this.optimalPercentage;
    }
}
