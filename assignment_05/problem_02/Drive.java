public class Drive {
    public static void main(String[] args) {
        Account account = new CheckingAccount("Soumya", "Nayar", 120.0);
        double debitAmount;
        double creditAmount;
        System.out.println(account.toString());
        debitAmount = 30;
        System.out.println("Balance after debiting " + debitAmount + " is: " + account.debitTransaction(debitAmount));
        debitAmount = 8;
        System.out.println("Balance after debiting " + debitAmount + " is: " + account.debitTransaction(debitAmount));
        creditAmount = 12.8;
        System.out
                .println("Balance after crediting " + creditAmount + " is: " + account.creditTransaction(creditAmount));
        creditAmount = 15;
        System.out
                .println("Balance after crediting " + creditAmount + " is: " + account.creditTransaction(creditAmount));
    }
}
