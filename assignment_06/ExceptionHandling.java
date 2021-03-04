/*
    Explanation: 

    What is the problem with below program?
    Ans: More generic exception is being caught first. Since the order in which JVM evaluates the exception handling is from top to bottom, the generic exception with get caught instead of more specific exception below. 

    Recommend a solution:
    Ans: Move the catch block for the NumberFormatException above the genric catch block for Exception. The below code is the corrected version of the problem statement.
*/

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt("abc");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("This block handles all exceptions");
        }
    }
}
