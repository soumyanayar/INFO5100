public class Account {
    protected String firstName;
    protected String lastName;
    protected double curBalance;

    public Account(String firstName, String lastName, double curBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.curBalance = curBalance;
    }

    public String getAcctype() {
        return "Saving Account";
    }

    public double debitTransaction(double debitAmount) {
        double newDebitBalance = this.curBalance - debitAmount;
        this.curBalance = newDebitBalance;
        return newDebitBalance;
    }

    public double creditTransaction(double creditAmount) {
        double newCreditBalance = this.curBalance + creditAmount;
        this.curBalance = newCreditBalance;
        return newCreditBalance;
    }

    public String toString() {
        return "Account Name : " + this.firstName + " " + this.lastName + " Account Type : " + getAcctype()
                + " Balance in $ : " + this.curBalance;
    }
}
