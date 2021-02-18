package problem_03;

import java.util.LinkedList;
import java.util.List;

public class Checkout {
    public List<DessertItem> items;

    public Checkout() {
        this.items = new LinkedList<DessertItem>();
    }

    public int numberOfItems() {
        return this.items.size();
    }

    public void enterItem(DessertItem item) {
        this.items.add(item);
    }

    public void clear() {
        this.items.clear();
    }

    public int totalCost() {
        int totalcost = 0;
        for (DessertItem item : this.items) {
            totalcost = totalcost + item.getCost();
        }
        return totalcost;
    }

    public int totalTax() {
        int totalTax = (int) Math.round(totalCost() * DessertShop.taxrate * 0.01);
        return totalTax;
    }

    public String toString() {
        String output = "     " + DessertShop.storeName + "\n     ----------------------\n";

        int leftGap = 24;
        int rightGap = 12;

        String taxToDisplay = DessertShop.cents2dollarsAndCentsmethod(totalTax());
        if (taxToDisplay.length() > DessertShop.maxWidthToDisplayCost) {
            taxToDisplay = taxToDisplay.substring(0, DessertShop.maxWidthToDisplayCost);
        }

        String displayTotalCost = DessertShop.cents2dollarsAndCentsmethod(totalTax() + totalCost());
        if (displayTotalCost.length() > DessertShop.maxWidthToDisplayCost) {
            displayTotalCost = displayTotalCost.substring(0, DessertShop.maxWidthToDisplayCost);
        }

        for (DessertItem item : items) {
            String displayCost = DessertShop.cents2dollarsAndCentsmethod(item.getCost());
            if (displayCost.length() > DessertShop.maxWidthToDisplayCost) {
                displayCost = displayCost.substring(0, DessertShop.maxWidthToDisplayCost);
            }
            if (item instanceof Sundae) {
                output += "\n" + String.format("%-" + leftGap + "s", item.getName().split("\\n")[0]) + "\n"
                        + String.format("%-" + leftGap + "s", item.getName().split("\\n")[1])
                        + String.format("%" + rightGap + "s", displayCost);
            } else if (item instanceof IceCream) {
                output += "\n" + String.format("%-" + leftGap + "s", item.getName())
                        + String.format("%" + rightGap + "s", displayCost);
            } else if (item instanceof Cookie) {
                output += "\n"
                        + String.format("%-" + leftGap + "s", ((Cookie) item).getNumber() + " @ "
                                + DessertShop.cents2dollarsAndCentsmethod(((Cookie) item).getPricePerDozen()) + " /dz.")
                        + "\n" + String.format("%-" + leftGap + "s", item.getName())
                        + String.format("%" + rightGap + "s", displayCost);
            } else {
                output += "\n"
                        + String.format("%-" + leftGap + "s", ((Candy) item).getWeight() + " lbs. @ "
                                + DessertShop.cents2dollarsAndCentsmethod(((Candy) item).getPricePerPound()) + " /lb.")
                        + "\n" + String.format("%-" + leftGap + "s", item.getName())
                        + String.format("%" + rightGap + "s", displayCost);
            }
        }
        output += "\n\n" + String.format("%-" + leftGap + "s", "Tax")
                + String.format("%" + rightGap + "s", taxToDisplay) + "\n"
                + String.format("%-" + leftGap + "s", "Total Cost")
                + String.format("%" + rightGap + "s", displayTotalCost) + "\n\n";
        return output;
    }
}