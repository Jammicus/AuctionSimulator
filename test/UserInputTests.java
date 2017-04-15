import org.junit.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInputTests {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        PrintStream oldOutput = System.out;
        System.setOut(oldOutput);
    }

    @Test
    public void incorrectNumberOfBiddersTest() {

        UserInput.validateUserInput("Ascending", 1, 1.23, 100);
        assertTrue(outContent.toString().contains("Number of bidders needs to be greater than 1"));
    }

    @Test
    public void LowerBoundBidderMoneyBelowZeroTest() {
        UserInput.validateUserInput("Ascending", 2, -1.234, 100);
        assertTrue(outContent.toString().contains("The lowest possible bidder value must be a positive number"));
    }

    @Test
    public void LowerBoundBidderMoneyAboveUpperBoundTest() {
        UserInput.validateUserInput("Ascending", 2, 500, 100);
        assertTrue(outContent.toString().contains("The lowest possible bidder value must be lower than the highest possible bidder value"));
    }

    @Test
    public void incorrectAuctionType() {
        UserInput.validateUserInput("", 2, 1.23, 100);
        assertTrue(outContent.toString().contains("Invalid auction type, possible auction types are 'first price'," +
                "'second price', 'ascending' or 'descending'"));
    }

    @Test
    public void correctUserInputsTest() {
        UserInput.validateUserInput("firstprice", 2, 1.23, 100);
        assertTrue(outContent.toString().contains("Inputted values validated"));
    }

    @Test
    public void assertSpacesAreRemovedFromAuctionType() {
        UserInput.validateUserInput("first    price", 2, 1, 5);
        assertTrue(outContent.toString().contains("Inputted values validated"));
    }

    @Test
    public void assertCapitalsAreIgnoredFromAuctionType() {
        UserInput.validateUserInput("aSceNdInG", 2, 1, 5);
        assertTrue(outContent.toString().contains("Inputted values validated"));
    }

}
