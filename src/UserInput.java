
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
        Initializer initializer = Initializer.getInstance();

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
        ui.calculateOptimalBiddingPoint = scanner.nextLine();

        System.out.println("Validating your input, please wait.");
        ui.auctionType = ui.auctionType.replaceAll("\\s+", "");
        validateUserInput(ui);

        initializer.prepareAuction(ui.getAuctionType(), ui.getNumberOfBidders(), ui.getLowerBoundBidderValue(), ui.getUpperBoundBidderValue(), ui.getNumberOfSimulations());

        System.out.println("Would you like to simulate another auction?");
        ui.runAnotherAuction = scanner.next();
        ui.setRunAnotherAuction(ui.getRunAnotherAuction());
    }

    //too many parameters
    public static void validateUserInput(UserInput userInput) {
        validateAuctionType(userInput.getAuctionType());
        validateNumberOfBidders(userInput.getNumberOfBidders());
        validateBidderValueBounds(userInput.getLowerBoundBidderValue(), userInput.getUpperBoundBidderValue());
        validateNumberOfSimulations(userInput.getNumberOfSimulations());
        System.out.println("Inputted values validated");

    }

    private static void validateAuctionType(String auctionType) {

        if (!auctionType.equalsIgnoreCase("firstprice") &&
                (!auctionType.equalsIgnoreCase("secondprice") &&
                        (!auctionType.equalsIgnoreCase("ascending") &&
                                (!auctionType.equalsIgnoreCase("descending"))))) {
            System.out.println("Invalid auction type, possible auction types are 'first price'," +
                    "'second price', 'ascending' or 'descending'");
        }
    }

    private static void validateNumberOfBidders(int numberOfBidders) {
        if (numberOfBidders < 2) {
            System.out.println("Number of bidders needs to be greater than 1");
        }
    }

    private static void validateBidderValueBounds(double lowerBoundBidderValue, double upperBoundBidderValue) {
        if (lowerBoundBidderValue > upperBoundBidderValue) {
            System.out.println("The lowest possible bidder value must be lower than the highest possible bidder value");
        } else if (lowerBoundBidderValue < 0) {
            System.out.println("The lowest possible bidder value must be a positive number");
        }
    }

    private static void validateNumberOfSimulations(int numberOfSimulations) {
        if (numberOfSimulations < 1) {
            System.out.println("Number of simulations must be greater than 0");
        }
    }

    private static void setRunAnotherAuction(String yesOrNo) {
        if (yesOrNo.equalsIgnoreCase("yes")) {
            gatherUserInput();
        } else {
            System.out.println("Thank you for using the simulator.");
        }
    }

    private static void setOptimalBiddingPoint(String yesOrNo) {
        if (yesOrNo.equalsIgnoreCase("yes")) {
            //
        } else {
            System.out.println("The optimal bidding point will not be calculated");
        }
    }

}
