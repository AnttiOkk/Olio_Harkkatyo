package com.example.anttiokkonen.olio_ht;

public class Bank {
    private static Bank bank = new Bank();
    User user;

    Account account;
    //Card card;

    private Bank() {
        user = new User();
        // OLETUSTILIEN LUONTI
        Account acc1 = new Account("Käyttötili", "FI 4558 4962 91", 1200, 1900, false, true, 0);
        Account acc2 = new Account("Kultapossu-tili", "FI 1234 5678 90", 0, 4100,true, false,0);
        Account acc3 = new Account("ASP-tili", "FI 2468 1357 90", 0, 3450,true, false,0);

        user.addAccount(acc1);
        user.addAccount(acc2);
        user.addAccount(acc3);

    }


    public static Bank getInstance(){
        return bank;
    }

    public void addUser(User u) {
        user = u;
    }

    public User getUser(){
        return user;
    }

}


