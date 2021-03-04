### How would you differentiate between throw, throws and throwable in java?

1. throw: <br>
    `throw` is used to throw an Exception. The throw statement is called with just one argument i.e a throwable class object

    Example:
    ```java
    try {
        if (password.length() < 5>) {
            throw new PasswordNotSafeException("Password length "+ password.length() + "is not safe. Please try a longer password.");
        }
    }
    ```

1. throws <br>
 is used to tell the caller that this method can throw this particular exception

    Example:
    ```java
    public String readFile(String filePath) throws FileNotFoundException
    ```

1. Throwable <br> 

    Throwable is the superclass of all the exceptions and errors in the Java programming language. Only objects that derive from Throwable class can be thrown.

    Example:

    ```java
    class MyThrowable extends Throwable {

    }

    // Now MyThrowable class can be thrown within the try block.
    ```