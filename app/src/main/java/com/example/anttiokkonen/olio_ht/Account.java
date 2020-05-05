package com.example.anttiokkonen.olio_ht;

import java.io.Serializable;
import java.util.ArrayList ;
import java.io.PrintWriter ;
import java.io.IOException ;
import java.util.List;

public class Account implements Serializable {
    public String accountName;
    public String accountNumber;
    public int credit;
    public int money;
    public Boolean canTransferMoney;
    public Boolean canDepositMoney;
    public double lastPayment;


    public Account(String accountName, String accountNumber, int credit, int money, boolean canTransferMoney, boolean canDepositMoney, double lastPayment) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.credit = credit;
        this.money = money;
        this.canTransferMoney = canTransferMoney;
        this.canDepositMoney = canDepositMoney;
        this.lastPayment = lastPayment;
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
    public Boolean getCanTransferMoney() {
        return canTransferMoney;
    }

    public void setCanTransferMoney(Boolean canTransferMoney) {
        this.canTransferMoney = canTransferMoney;
    }

    public Boolean getCanDepositMoney() {
        return canDepositMoney;
    }

    public void setCanDepositMoney(Boolean canDepositMoney) {
        this.canDepositMoney = canDepositMoney;
    }

    public double getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(double lastPayment) {
        this.lastPayment = lastPayment;
    }

    @Override
    public String toString() {
        return accountName;
    }
}