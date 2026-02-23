package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
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

    public boolean isWithdrawAllowed(final double amount){
        return balance >= amount;
    }

}
