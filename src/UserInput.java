
import java.util.Scanner;

public class UserInput {


    private static String auctionType;
    private static int numberOfBidders;
    private static double lowerBoundBidderValue;
    private static double upperBoundBidderValue;
    private static int numberOfSimulations;
    private static String runAnotherAuction;

    public static void main(String args[]) {
        gatherUserInput();
    }

    public static void gatherUserInput() {
        Scanner scanner = new Scanner(System.in);
        Initializer initializer = Initializer.getInstance();

        System.out.println("Please input the type of auction you would like to simulate");
        auctionType = scanner.nextLine();

        System.out.println("Please enter the number of bidders");
        numberOfBidders = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is the lowest possible value a bidder could have?");
        lowerBoundBidderValue = scanner.nextDouble();

        System.out.println("What is the highest possible value a bidder could have?");
        upperBoundBidderValue = scanner.nextDouble();

        System.out.println("How many simulations would you like?");
        numberOfSimulations = scanner.nextInt();

        System.out.println("Validating your input, please wait.");
        auctionType = auctionType.replaceAll("\\s+", "");
        validateUserInput(auctionType, numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue, numberOfSimulations);

        initializer.prepareAuction(auctionType, numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue, numberOfSimulations);

        System.out.println("Would you like to simulate another auction?");
        runAnotherAuction = scanner.next();
        setRunAnotherAuction(runAnotherAuction);
    }


    public static void validateUserInput(String auctionType, int numberOfBidders, double lowerBoundBidderValue, double upperBoundBidderValue, int numberOfSimulations) {
        validateAuctionType(auctionType);
        validateNumberOfBidders((numberOfBidders));
        validateBidderValueBounds(lowerBoundBidderValue, upperBoundBidderValue);
        validateNumberOfSimulations(numberOfSimulations);
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
            removePreviousUserInput();
            gatherUserInput();
        } else {
            System.out.println("Thank you for using the simulator.");
        }
    }

    // is this needed?
    private static void removePreviousUserInput() {
        auctionType = "";
        numberOfBidders = 0;
        lowerBoundBidderValue = 0;
        upperBoundBidderValue = 0;
        numberOfSimulations = 0;
        runAnotherAuction = "";
    }
}
