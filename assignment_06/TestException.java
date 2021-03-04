/*
    Explanation: 

    What is the problem with below program?
    Ans: There are two Exceptions in the same catch block. That is not supported in java.

    Recommend a solution:
    Ans: Move the exceptions into separate exception blocks. The below code is the correct version of the problem statement.
*/

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestException {
    public static void main(String[] args) {
        try {
            testExceptions();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void testExceptions() throws IOException, FileNotFoundException {

    }
}
