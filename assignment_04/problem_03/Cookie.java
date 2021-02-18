package problem_03;

public class Cookie extends DessertItem {
    private int number;
    private int pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getPricePerDozen() {
        return pricePerDozen;
    }

    public int getNumber() {
        return number;
    }

    public int getCost() {
        int cookieCost = Math.round(pricePerDozen * number / 12);
        return cookieCost;
    }
}