package problem_03;

class Sundae extends IceCream {
    private int ToppingPrice;
    private String name;

    // constructor
    public Sundae(String iceCreamName, int iceCreamPrice, String name, int ToppingPrice) {
        super(name + "Sundae with\n" + iceCreamName, iceCreamPrice + ToppingPrice);
    }

    public int getCost() {
        return Math.round(super.getCost());
    }
}