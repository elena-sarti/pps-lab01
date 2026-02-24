package example.model;

/**
 * This class represent a particular instance of a Basic Bank Account.
 * In particular, in a Bank Account With Fee a fee is applied when withdrawing money.
 */
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

    public boolean isWithdrawAllowed(final double amount){ return balance >= amount + FEE; }
}
