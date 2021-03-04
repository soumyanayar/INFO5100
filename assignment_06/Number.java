import java.util.Scanner;

public class Number {
    public static void count(int a, int b) {
        try {
            int q = a / b;
            System.out.println("The quotient of " + a + " and " + b + " : " + q);
        }

        catch (ArithmeticException ae) {
            System.out.println("Divide by zero is not possible : Enter valid number");
        }
    }

    public static int getInput(Scanner scanner) {
        String s = null;
        try {
            s = scanner.nextLine();
            return Integer.parseInt(s);
        } catch (NumberFormatException ne) {
            System.out.println("Exception is : " + ne.getMessage());
        }
        System.out.println("\fnYou have entered an invalid number, so I will consider 10 as your input\n");
        return 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter first number : ");
        int a = getInput(scanner);
        System.out.println("Please Enter second number : ");
        int b = getInput(scanner);
        count(a, b);
    }
}
