/*
    Explanation: 

    What is the problem with below program?
    Ans: This program will give compilation error with the message as "The exception FileNotFoundException is already caught by the alternative IOException". 
    This is due to FileNotFoundException is a child class of IOException

    Recommend a solution:
    Ans: Move the exceptions into separate exception blocks. catch the more specific FileNotFoundException first and then try to catch for IOException. 
    The below code is the correct version of the problem statement.
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
