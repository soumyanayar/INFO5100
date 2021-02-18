package problem_03;

public class IceCream extends DessertItem {
    int cost;

    public IceCream(String name, int iceCreamPrice) {
        super(name);
        this.cost = iceCreamPrice;
    }

    public int getCost() {
        return this.cost;
    }
}