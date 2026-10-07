package edu.course.lab02;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance can't negative");
        }
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0 ) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Amount can't be bigger than balance");
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
