package com.aishwarya;

//import com.aishwarya.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount();
    }

    @Test
    public void testInitialBalanceIsZero() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(200);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(300);
        });
    }

    @Test
    public void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(100);
        account.withdraw(40);

        List<String> history = account.getTransactionHistory();
        assertEquals(2, history.size());
        assertTrue(history.get(0).contains("Deposited "));
        assertTrue(history.get(1).contains("Withdraw "));
    }
}
