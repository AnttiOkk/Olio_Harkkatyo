package com.example.anttiokkonen.olio_ht;

import java.util.ArrayList ;
import java.io.PrintWriter ;
import java.io.IOException ;
import java.util.List;

public class Account {
    public String accountName;
    public String accountNumber;
    public int credit;
    public int money;

    public Account(String accountName, String accountNumber, int credit, int money) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.credit = credit;
        this.money = money;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return accountName;
    }
}