package example.model;

abstract class BasicBankAccount implements BankAccount{
    public double balance;
    public final AccountHolder holder;

    public BasicBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    protected boolean checkUser(final int id) {
        return this.holder.id() == id;
    }

    public abstract void withdraw(final int userID, final double amount);

    abstract boolean isWithdrawAllowed(final double amount);
}
