import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bidder implements Comparable<Bidder> {
    private double money;
    private int id;

    public Bidder() {
    }

    public Bidder(int id, double money) {
        this.money = money;
        this.id = id;
    }

    public static List<Bidder> createBidders(int numberOfBidders, double lowestMoneyValue, double highestMoneyValue) {
        List<Bidder> listOfBidders = new ArrayList<>();

        for (int i = 0; i < numberOfBidders; i++) {
            Random random = new Random();
            Double randomMoneyValue = (random.nextInt((int) ((highestMoneyValue - lowestMoneyValue) * 10 + 1)) + lowestMoneyValue * 10) / 10.0;
            listOfBidders.add(new Bidder(i, randomMoneyValue));
        }
        return listOfBidders;
    }

    public double getMoney() {
        return this.money;
    }

    public int getId() {
        return this.id;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Do I want this as 0.5 or 75?
    public Bidder changeBiddersValueByPercentage(Bidder aBidder, double percentageValue) {
        double bidderValue = aBidder.getMoney();

        bidderValue = bidderValue * (percentageValue / 100);

        aBidder.setMoney(bidderValue);
        return aBidder;
    }

    public static List<Bidder> sortBiddersByMoneyAscending(List<Bidder> bidders) {
        Collections.sort(bidders);
        return bidders;
    }

    @Override
    public int compareTo(Bidder bidder) {
        if (this.money < bidder.getMoney()) {
            return 1;
        } else if (this.money > bidder.getMoney()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "" + getMoney() + "";
    }

    public void printBidderDetails() {
        System.out.println("Bidder ID is:" + getId());
        System.out.println("Bidder money is: " + getMoney());
    }
}
