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
        UserInput ui = new UserInput("Ascending", 1, 1.23, 100, 1);
        ui.validateUserInput(ui);
        assertTrue(outContent.toString().contains("Number of bidders needs to be greater than 1"));
    }

    @Test
    public void LowerBoundBidderMoneyBelowZeroTest() {
        UserInput ui = new UserInput("Ascending", 2, -1.234, 100, 1);
        ui.validateUserInput(ui);
        assertTrue(outContent.toString().contains("The lowest possible bidder value must be a positive number"));
    }

    @Test
    public void LowerBoundBidderMoneyAboveUpperBoundTest() {
        UserInput ui = new UserInput("Ascending", 2, 500, 100, 1);
        ui .validateUserInput(ui);
        assertTrue(outContent.toString().contains("The lowest possible bidder value must be lower than the highest possible bidder value"));
    }

    @Test
    public void incorrectAuctionType() {
        UserInput ui = new UserInput("", 2, 1.23, 100, 1);
        ui .validateUserInput(ui);
        assertTrue(outContent.toString().contains("Invalid auction type, possible auction types are 'first price'," +
                "'second price', 'ascending' or 'descending'"));
    }

    @Test
    public void correctUserInputsTest() {
        UserInput ui = new UserInput("firstprice", 2, 1.23, 100, 1);
        ui .validateUserInput(ui );
        assertTrue(outContent.toString().contains("Inputted values validated"));
    }

    @Test
    public void assertSpacesAreRemovedFromAuctionType() {
        UserInput ui = new UserInput("first    price", 2, 1, 5, 1);
        ui.validateUserInput(ui);
        assertTrue(outContent.toString().contains("Inputted values validated"));
    }

    @Test
    public void assertCapitalsAreIgnoredFromAuctionType() {
        UserInput ui = new UserInput("aSceNdInG", 2, 1, 5, 1);
        ui.validateUserInput(ui);
        assertTrue(outContent.toString().contains("Inputted values validated"));
    }

    @Test
    public void numberOfSimulationsError() {
        UserInput ui = new UserInput("aSceNdInG", 2, 1, 5, 0);
        ui.validateUserInput(ui);
        assertTrue(outContent.toString().contains("Number of simulations must be greater than 0"));
    }
}

