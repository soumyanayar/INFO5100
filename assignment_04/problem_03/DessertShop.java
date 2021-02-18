package problem_03;

public class DessertShop {
    static final String storeName = "M & M Dessert Shoppe";
    static final float taxrate = 6.5f; // 6.5%
    static final int maxSizeOfItemName = 50;
    static final int maxWidthToDisplayCost = 10;

    public static String cents2dollarsAndCentsmethod(int cents) {
        int dollar = cents / 100;
        double cent = cents % 100;
        return String.valueOf(dollar + cent / 100);
    }
}