package example.model;

/**
 * This class represent a particular instance of a Basic Bank Account.
 * In particular, a Simple Bank Account no fee is applied when withdrawing money.
 */
public class SimpleBankAccount extends BasicBankAccount {

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            balance -= amount;
        }
    }

    public boolean isWithdrawAllowed(final double amount){ return balance >= amount; }
}
