public class CheckingAccount extends Account {

    private double minimumBalance = 100;
    private double penaltyCharges = 5;

    public CheckingAccount(String firstName, String lastName, double curBalance) {
        super(firstName, lastName, curBalance);
    }

    @Override
    public double debitTransaction(double debitAmount) {
        double remainingBalance = super.debitTransaction(debitAmount);
        this.curBalance = this.chargeFees(remainingBalance);
        return this.curBalance;
    }

    @Override
    public double creditTransaction(double creditAmount) {
        double newCreditBalance = super.creditTransaction(creditAmount);
        this.curBalance = this.chargeFees(newCreditBalance);
        return this.curBalance;
    }

    private double chargeFees(double currentBalance) {
        if (currentBalance < minimumBalance) {
            currentBalance -= penaltyCharges;
        }
        return currentBalance;
    }
}
