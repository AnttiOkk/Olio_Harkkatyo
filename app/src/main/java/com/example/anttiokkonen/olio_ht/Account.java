package com.example.anttiokkonen.olio_ht;

import java.io.Serializable;
import java.util.ArrayList ;
import java.io.PrintWriter ;
import java.io.IOException ;
import java.util.List;

public class Account implements Serializable {
    public String accountName;
    public String accountNumber;
    public String credit;
    public String money;
    public Boolean canTransferMoney;
    public Boolean canDepositMoney;


    public Account(String accountName, String accountNumber, String credit, String money, boolean canTransferMoney, boolean canDepositMoney) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.credit = credit;
        this.money = money;
        this.canTransferMoney = canTransferMoney;
        this.canDepositMoney = canDepositMoney;
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

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
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

    @Override
    public String toString() {
        return accountName;
    }

}