package problem_01;

public class Problem1 {
    public static void main(String[] args) {
        Mreview mreview = new Mreview("Kill Bill", 5);
        mreview.addRating(4);
        mreview.addRating(5);
        mreview.addRating(4);
        mreview.addRating(3);
        mreview.addRating(4);
        System.out.println("The Average Ratings " + mreview.aveRating());
        System.out.println("The Mreview object is\n" + mreview);
    }
}
