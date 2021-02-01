// Write a java function that adds all the digits of an integer until it is single digit.
// 		i. function takes an integer as input and returns its sum of digits.
// 		ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.

class Problem1 {
    public int addDigits(int number) {
        int sumOfDigits;
        do {
            sumOfDigits = 0;
            while (number != 0) {
                // Till the number becomes '0' keep adding its remainder to the sum
                // and keep dividing the number by 10.
                sumOfDigits = sumOfDigits + number % 10;
                number = number / 10;
            }
            number = sumOfDigits;
        } while (number > 9);
        return sumOfDigits;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int testNumber = 7;
        int sumOfDigits = problem1.addDigits(testNumber);
        System.out.println("The sum of the digits of number : " + testNumber + " is " + sumOfDigits);

        testNumber = 37;
        sumOfDigits = problem1.addDigits(testNumber);
        System.out.println("The sum of the digits of number : " + testNumber + " is " + sumOfDigits);

        testNumber = 437;
        sumOfDigits = problem1.addDigits(testNumber);
        System.out.println("The sum of the digits of number : " + testNumber + " is " + sumOfDigits);

        testNumber = 54389;
        sumOfDigits = problem1.addDigits(testNumber);
        System.out.println("The sum of the digits of number : " + testNumber + " is " + sumOfDigits);

        testNumber = 0;
        sumOfDigits = problem1.addDigits(testNumber);
        System.out.println("The sum of the digits of number : " + testNumber + " is " + sumOfDigits);
    }
}