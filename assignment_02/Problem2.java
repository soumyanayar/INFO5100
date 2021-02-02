// Write a method to find the maximum and minimum number in an array of numbers

public class Problem2 {

    public void maxAndMinValuesInArray(int[] array) {
        if (array.length == 0) {
            System.out.println("It is an empty array");
            return;
        }
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        System.out.println("The minimum value in the array is : " + minValue);
        System.out.println("The maximum value in the array is : " + maxValue);
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println("Test Case 01");
        int[] testCaseArray1 = { 4, 8, 9, 12, 2, 26 };
        problem2.maxAndMinValuesInArray(testCaseArray1);

        System.out.println("Test Case 02");
        int[] testCaseArray2 = { 5, 7, -2, 54, 6, 2, -32, 3 };
        problem2.maxAndMinValuesInArray(testCaseArray2);

        System.out.println("Test Case 03");
        int[] testCaseArray3 = {};
        problem2.maxAndMinValuesInArray(testCaseArray3);
    }
}
