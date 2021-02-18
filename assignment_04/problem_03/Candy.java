package problem_03;

public class Candy extends DessertItem {
    private double weight;
    private int pricePerPound;

    public Candy(String name, double weight, int pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public double getWeight() {
        return weight;
    }

    public int getCost() {
        return (int) Math.round(weight * pricePerPound);
    }
}