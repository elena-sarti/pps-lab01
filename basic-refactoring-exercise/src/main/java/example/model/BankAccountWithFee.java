package example.model;

public class BankAccountWithFee extends BasicBankAccount{

    public static final int FEE = 1;

    public BankAccountWithFee(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            balance -= amount + FEE;
        }
    }

    public boolean isWithdrawAllowed(final double amount){
        return balance >= amount + FEE;
    }

}
