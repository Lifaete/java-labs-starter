package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    @Test
    void addDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(30);
        assertEquals(130, account.getBalance());
    }

    @Test
    void withdrawBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(33);
        assertEquals(67, account.getBalance());
    }

    @Test
    void negativeBalance() {
        BankAccount account = new BankAccount(10);
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(100));
    }
}
