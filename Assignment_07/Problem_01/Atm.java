package Problem_01;

import java.util.HashMap;
import java.util.Scanner;
import java.io.Console;

enum TransactionType {
    WITHDRAWAL("withDrawal"), DEPOSIT("deposit");

    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    public String toString() {
        return this.displayName;
    }
}

class Transaction {
    private TransactionType type;
    private double amount;
    private double fee;

    public Transaction(TransactionType type, double amount, double fee) {
        this.type = type;
        this.amount = amount;
        this.fee = fee;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-12s", this.type));
        sb.append(String.format("%-16s", this.amount));
        sb.append(String.format("%-12s", this.fee));
        return sb.toString();
    }
}

public class Atm {
    enum STATUS {
        LOGGEDOUT, LOGIN, SIGNUP, RESETPASSWORD, LOGGEDIN
    };

    private double availableAmountInMachine;
    private double transactionFee;
    private int RECENT_TRANSACTIONS_LENGTH = 10;

    private HashMap<String, UserData> usersInfo;

    public Atm(double totalAmount, double transactionFee) {
        this.availableAmountInMachine = totalAmount;
        this.transactionFee = transactionFee;
        this.usersInfo = new HashMap<String, UserData>();
    }

    private UserData checkAccountNumber(String accountNumber) {
        return this.usersInfo.get(accountNumber);
    }

    private String readPassword(Console console, Scanner scanner) {
        if (console == null) {
            return scanner.nextLine();
        } else {
            return new String(console.readPassword(""));
        }
    }

    private String configureNewPassword(Console console, Scanner scanner) {
        String password, recheck;
        while (true) {
            System.out.println("Please Enter your new password:");
            password = this.readPassword(console, scanner);
            System.out.println("Please Re enter your password:");
            recheck = this.readPassword(console, scanner);
            if (password.equals(recheck)) {
                return password;
            } else {
                System.out.println("Password not match.");
            }
        }
    }

    public void addUser(String accountNumber, String name, int age, String address, String phoneNumber, String pwd) {
        this.usersInfo.put(accountNumber, new UserData(accountNumber, name, age, address, phoneNumber, pwd));
    }

    public void startOperation() {
        Scanner scanner = new Scanner(System.in);
        STATUS currentStatus = STATUS.LOGGEDOUT;
        String accountNumber;
        String password;
        String name;
        String address;
        String phone;
        int age;
        Console console = System.console();
        int action;
        UserData currentUserInfo = null;
        try {
            while (true) {
                switch (currentStatus) {
                case LOGGEDOUT:
                    System.out.println(
                            "Enter number to choose action:\n1. Exisitng User Login\n2. New User SignUp\n3. Exit");
                    action = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("You chose: " + action);
                    switch (action) {
                    case 1:
                        currentStatus = STATUS.LOGIN;
                        break;
                    case 2:
                        currentStatus = STATUS.SIGNUP;
                        break;
                    case 3:
                        System.out.println("\nExiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid Choice: Please try again.");
                    }
                    break;

                case LOGIN:
                    System.out.println("Please enter your bank account number:");
                    accountNumber = scanner.nextLine();
                    currentUserInfo = checkAccountNumber(accountNumber);
                    if (currentUserInfo == null) {
                        System.out.println(
                                "This Bank account number does not exists. Please check your bank account number or register as a new account.");
                        currentStatus = STATUS.LOGGEDOUT;
                    } else {
                        System.out.println("Please enter the password:");
                        password = this.readPassword(console, scanner);
                        if (currentUserInfo.checkPassWord(password)) {
                            System.out.println("Welcome, " + currentUserInfo.getName() + "!");
                            currentStatus = STATUS.LOGGEDIN;
                        } else {
                            System.out.println("Password error! Please check your password.");
                            boolean passwordErrorFlag = true;
                            while (passwordErrorFlag) {
                                System.out.println(
                                        "Enter number to choose action:\n1.Forget password\n2.Go back to Menu\n");
                                action = scanner.nextInt();
                                scanner.nextLine();
                                switch (action) {
                                case 1:
                                    currentStatus = STATUS.RESETPASSWORD;
                                    passwordErrorFlag = false;
                                    break;

                                case 2:
                                    currentStatus = STATUS.LOGGEDOUT;
                                    passwordErrorFlag = false;
                                    break;

                                default:
                                    System.out.println("\nInvalid Choice: Please try again.\n\n");
                                }
                            }
                        }
                    }
                    break;

                case SIGNUP:
                    System.out.println("Please follow the instruction to register as a new user:");
                    System.out.println("Please enter your bank account number:");
                    accountNumber = scanner.nextLine();
                    if (this.checkAccountNumber(accountNumber) == null) {
                        password = configureNewPassword(console, scanner);
                        System.out.println("Please enter your name:");
                        name = scanner.nextLine();
                        System.out.println("Please enter your age:");
                        age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter your phone number:");
                        phone = scanner.nextLine();
                        System.out.println("Please enter your address:");
                        address = scanner.nextLine();
                        usersInfo.put(accountNumber, new UserData(accountNumber, name, age, address, phone, password));
                        System.out.println("\nNew account created. You can now login with your bank account number.\n");
                    } else {
                        System.out.println("Account already exists. You can sign in with this account.\n");
                    }
                    currentStatus = STATUS.LOGGEDOUT;
                    break;

                case RESETPASSWORD:
                    System.out.println("Please provide your information to reset the password:");
                    System.out.println("Please enter your name:");
                    name = scanner.nextLine();
                    boolean hasError = true;
                    if (currentUserInfo.verifyName(name)) {
                        System.out.println("Please enter your age:");
                        age = scanner.nextInt();
                        scanner.nextLine();
                        if (currentUserInfo.verifyAge(age)) {
                            System.out.println("Please enter your phoneNumber:");
                            phone = scanner.nextLine();
                            if (currentUserInfo.verifyPhoneNumber(phone)) {
                                hasError = false;
                                System.out.println("Information matches.");
                                password = configureNewPassword(console, scanner);
                                currentUserInfo.updatePassWord(password);
                                System.out.println("Password is now reset. Please try to login:");
                            }
                        }
                    }
                    if (hasError) {
                        System.out.println("Verification unsuccessful. Unable to reset the password.");
                    }
                    currentStatus = STATUS.LOGGEDOUT;
                    break;

                case LOGGEDIN:
                    System.out.println(
                            "Enter number to choose action:\n1. Show Account balance\n2. Deposit money\n3. Withdraw Money\n4. Show recent transactions\n5. Change current password\n6. Log out");
                    action = scanner.nextInt();
                    scanner.nextLine();
                    switch (action) {
                    case 1:
                        System.out.println("\nYour balance is: " + currentUserInfo.getBalance() + "\n");
                        break;

                    case 2:
                        System.out.println("Please enter the amount you want to deposit (the transaction fee is "
                                + this.transactionFee + ")");
                        double amountToDeposit = scanner.nextDouble();
                        currentUserInfo.deposit(amountToDeposit - this.transactionFee);
                        currentUserInfo.addTransactionRecord(
                                new Transaction(TransactionType.DEPOSIT, amountToDeposit, this.transactionFee));
                        this.availableAmountInMachine += amountToDeposit + this.transactionFee;
                        System.out.println(
                                "Deposit of amount " + (amountToDeposit - this.transactionFee) + " successful\n");
                        System.out.println("Your balance is: " + currentUserInfo.getBalance());
                        break;

                    case 3:
                        System.out.println("Please enter the amount you want to withdraw (the transaction fee is: "
                                + this.transactionFee + ")");
                        double amountToWithdraw = scanner.nextDouble();
                        if (amountToWithdraw + this.transactionFee > this.availableAmountInMachine) {
                            System.out.println("The Amount to withdraw " + amountToWithdraw
                                    + " exceeds the amount remaining in the ATM. Please try again\n\n");
                        } else if (amountToWithdraw + this.transactionFee > currentUserInfo.getBalance()) {
                            System.out.println("The Amount to withdraw " + amountToWithdraw
                                    + " exceeds the current balance. Please try again\n\n");
                        } else {
                            currentUserInfo.withdraw(amountToWithdraw + this.transactionFee);
                            currentUserInfo.addTransactionRecord(
                                    new Transaction(TransactionType.WITHDRAWAL, amountToWithdraw, this.transactionFee));
                            this.availableAmountInMachine -= amountToWithdraw;
                        }
                        System.out.println("Your balance is: " + currentUserInfo.getBalance());
                        break;

                    case 4:
                        System.out.println("\n\nTransaction details:(most recent 10 records)\n");
                        StringBuilder ret = new StringBuilder();
                        ret.append(String.format("%-12s", "Type"));
                        ret.append(String.format("%-16s", "Amount"));
                        ret.append(String.format("%-12s", "Fees"));
                        System.out.println(ret.toString());
                        for (Transaction transaction : currentUserInfo
                                .getRecentTransactions(this.RECENT_TRANSACTIONS_LENGTH)) {
                            System.out.println(transaction);
                        }
                        System.out.println("\n");
                        break;

                    case 5:
                        password = configureNewPassword(console, scanner);
                        currentUserInfo.updatePassWord(password);
                        System.out.println("New password has been set successfully");
                        break;

                    case 6:
                        currentStatus = STATUS.LOGGEDOUT;
                        break;

                    default:
                        System.out.println("Invalid Choice: Please try again.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Atm atm = new Atm(100000.0, 0.1);
        atm.startOperation();
    }
}
