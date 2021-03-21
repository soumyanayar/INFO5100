package Problem_01;

import java.util.LinkedList;
import java.util.List;

class UserData {
    private User user;
    private String pwd;
    private double balance;
    private LinkedList<Transaction> records;

    public UserData(String accountNumber, String name, int age, String address, String phoneNumber, String pwd) {
        this.pwd = pwd;
        this.balance = 0;
        this.user = new User(accountNumber, name, age, address, phoneNumber);
        records = new LinkedList<Transaction>();
    }

    public boolean checkPassWord(String pwd) {
        return pwd.equals(this.pwd);
    }

    public void updatePassWord(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return this.balance;
    }

    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    public double withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
        return this.balance;
    }

    public String getName() {
        return this.user.getName();
    }

    public boolean verifyName(String name) {
        return name.equals(this.user.getName());
    }

    public boolean verifyAge(int age) {
        return age == this.user.getAge();
    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        return phoneNumber.equals(this.user.getPhoneNumber());
    }

    public void addTransactionRecord(Transaction newRecord) {
        records.addFirst(newRecord);
    }

    public List<Transaction> getRecentTransactions(int numberOfTransactions) {
        int recentTransactionslength = records.size() > numberOfTransactions ? numberOfTransactions : records.size();
        return records.subList(0, recentTransactionslength);
    }
}
