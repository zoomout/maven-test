package com.bogdan._11_deadlock;

/**
 * Created by zoomout on 11/22/16.
 */
public class Account {
    public int getBalance() {
        return balance;
    }

    public void deposit(int balance) {
        this.balance += balance;
    }

    public void withdraw(int balance) {
        this.balance -= balance;
    }

    private int balance = 1000;

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
