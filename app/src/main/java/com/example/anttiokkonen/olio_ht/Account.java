package com.example.anttiokkonen.olio_ht;

public class Account {
    protected String accountName = "Kultapossu-tili";
    protected String accountNumber = "FI 8000 1234 5678 90";
    protected int money;
    protected int credit;

    public void addMoney(int money) {
        this.money += money;

    }public void withdrawMoney(int money) {
        this.money -= money;
        // tarkistus ettei saldo mene pakkaselle
    }
    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getMoney() {
        return money;
    }

    public int getCredit() {
        return credit;
    }


}class NormalAccount extends Account {

    public NormalAccount(String accountNumber, int money) {
        this.accountNumber = accountNumber;
        this.money = money;
        this.credit = 0;

    }
}class CreditAccount extends Account {

    public CreditAccount(String accountNumber, int money, int credit) {
        this.accountNumber = accountNumber;
        this.money = money;
        this.credit = credit;

    }
}

