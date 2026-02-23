import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int NOT_DEFINED_USER_ID = 2;
    private static final int STARTING_BALANCE = 0;
    public static final int DEPOSITED_AMOUNT = 100;
    public static final int WITHDRAWN_AMOUNT = 70;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, STARTING_BALANCE);
        bankAccount.deposit(accountHolder.id(), DEPOSITED_AMOUNT);
    }

    @Test
    void testInitialBalance() {
        assertEquals(STARTING_BALANCE + DEPOSITED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        assertEquals(DEPOSITED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int moneyToTryToDeposit = 50;
        bankAccount.deposit(NOT_DEFINED_USER_ID, moneyToTryToDeposit);
        assertEquals(DEPOSITED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(accountHolder.id(), WITHDRAWN_AMOUNT);
        assertEquals(DEPOSITED_AMOUNT - WITHDRAWN_AMOUNT - SimpleBankAccount.FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.withdraw(NOT_DEFINED_USER_ID, WITHDRAWN_AMOUNT);
        assertEquals(DEPOSITED_AMOUNT, bankAccount.getBalance());
    }
}
