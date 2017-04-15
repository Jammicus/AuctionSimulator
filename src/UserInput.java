
import java.util.Scanner;

public class UserInput {


    private static String auctionType;
    private static int numberOfBidders;
    private static double lowerBoundBidderValue;
    private static double upperBoundBidderValue;


    public static void main(String args[]) {
        gatherUserInput();
    }

    public static void gatherUserInput() {
        Scanner scanner = new Scanner(System.in);
        Initializer initializer =  Initializer.getInstance();

        System.out.println("Please input the type of auction you would like to simulate");
        auctionType = scanner.nextLine();


        System.out.println("Please enter the number of bidders");
        numberOfBidders = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is the lowest possible value a bidder could have?");
        lowerBoundBidderValue = scanner.nextDouble();

        System.out.println("What is the highest possible value a bidder could have?");
        upperBoundBidderValue = scanner.nextDouble();

        System.out.println("Validating your input, please wait.");
        auctionType = auctionType.replaceAll("\\s+", "");
        validateUserInput(auctionType, numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue);
        System.out.println("Initializing simulation");

        initializer.prepareAuction(auctionType, numberOfBidders, lowerBoundBidderValue, upperBoundBidderValue);
    }


    public static void validateUserInput(String auctionType, int numberOfBidders, double lowerBoundBidderValue, double upperBoundBidderValue) {
        validateAuctionType(auctionType);
        validateNumberOfBidders((numberOfBidders));
        validateBidderValueBounds(lowerBoundBidderValue, upperBoundBidderValue);
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
}
