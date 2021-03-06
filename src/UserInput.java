
import java.util.Scanner;

public class UserInput {


    private String auctionType;
    private int numberOfBidders;
    private double lowerBoundBidderValue;
    private double upperBoundBidderValue;
    private int numberOfSimulations;
    private String runAnotherAuction;
    private String calculateOptimalBiddingPoint;

    public UserInput() {
    }

    //This constructor should only be used for testing purposes;
    public UserInput(String auctionType, int numberOfBidders, double lowerBoundBidderValue, double upperBoundBidderValue, int numberOfSimulations) {
        this.auctionType = auctionType;
        this.numberOfBidders = numberOfBidders;
        this.lowerBoundBidderValue = lowerBoundBidderValue;
        this.upperBoundBidderValue = upperBoundBidderValue;
        this.numberOfSimulations = numberOfSimulations;
    }

    public String getAuctionType() {
        return auctionType;
    }

    public int getNumberOfBidders() {
        return numberOfBidders;
    }

    public double getLowerBoundBidderValue() {
        return lowerBoundBidderValue;
    }

    public double getUpperBoundBidderValue() {
        return upperBoundBidderValue;
    }

    public int getNumberOfSimulations() {
        return numberOfSimulations;
    }

    public String getRunAnotherAuction() {
        return runAnotherAuction;
    }

    public String getCalculateOptimalBiddingPoint() {
        return calculateOptimalBiddingPoint;
    }


    public static void main(String args[]) {
        gatherUserInput();
    }

    public static void gatherUserInput() {
        UserInput ui = new UserInput();
        Scanner scanner = new Scanner(System.in);
        Auctioneer auctioneer = Auctioneer.getInstance();
        OptimalBidAuctioneer OBD = new OptimalBidAuctioneer();

        System.out.println("Please input the type of auction you would like to simulate");
        ui.auctionType = scanner.nextLine();

        System.out.println("Please enter the number of bidders");
        ui.numberOfBidders = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is the lowest possible value a bidder could have?");
        ui.lowerBoundBidderValue = scanner.nextDouble();

        System.out.println("What is the highest possible value a bidder could have?");
        ui.upperBoundBidderValue = scanner.nextDouble();

        System.out.println("How many simulations would you like?");
        ui.numberOfSimulations = scanner.nextInt();

        System.out.println("Would you like to calculate the optimal bidding point?");
        ui.calculateOptimalBiddingPoint = scanner.next();

        System.out.println("Validating your input, please wait.");
        ui.auctionType = ui.auctionType.replaceAll("\\s+", "");
        ui.validateUserInput();

        auctioneer.prepareAuction(ui);
        if (ui.setOptimalBiddingPoint(ui.calculateOptimalBiddingPoint)) {
            OptimalBidAuctioneer result;

            System.out.println("Calculating the optimal bidding point, please wait");
            result = OBD.prepareOptimalBid(ui);
            System.out.println("The optimal point is: " + result.getOptimalPercentage() + "% of your valuation");
        }

        System.out.println("Would you like to simulate another auction?");
        ui.runAnotherAuction = scanner.next();
        ui.setRunAnotherAuction(ui.getRunAnotherAuction());
    }

    public void validateUserInput() {
        validateAuctionType(getAuctionType());
        validateNumberOfBidders(getNumberOfBidders());
        validateBidderValueBounds(getLowerBoundBidderValue(), getUpperBoundBidderValue());
        validateNumberOfSimulations(getNumberOfSimulations());
        System.out.println("Inputted values validated");
    }

    private void validateAuctionType(String auctionType) {

        if (!auctionType.equalsIgnoreCase("firstprice") &&
                (!auctionType.equalsIgnoreCase("secondprice") &&
                        (!auctionType.equalsIgnoreCase("ascending") &&
                                (!auctionType.equalsIgnoreCase("descending"))))) {
            System.out.println("Invalid auction type, possible auction types are 'first price'," +
                    "'second price', 'ascending' or 'descending'");
        }
    }

    private void validateNumberOfBidders(int numberOfBidders) {
        if (numberOfBidders < 2) {
            System.out.println("Number of bidders needs to be greater than 1");
        }
    }

    private void validateBidderValueBounds(double lowerBoundBidderValue, double upperBoundBidderValue) {
        if (lowerBoundBidderValue > upperBoundBidderValue) {
            System.out.println("The lowest possible bidder value must be lower than the highest possible bidder value");
        } else if (lowerBoundBidderValue < 0) {
            System.out.println("The lowest possible bidder value must be a positive number");
        }
    }

    private void validateNumberOfSimulations(int numberOfSimulations) {
        if (numberOfSimulations < 1) {
            System.out.println("Number of simulations must be greater than 0");
        }
    }

    private void setRunAnotherAuction(String yesOrNo) {
        if (yesOrNo.equalsIgnoreCase("yes")) {
            gatherUserInput();
        } else {
            System.out.println("Thank you for using the simulator.");
        }
    }

    private boolean setOptimalBiddingPoint(String yesOrNo) {
        if (yesOrNo.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }
}
