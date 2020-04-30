package com.example.anttiokkonen.olio_ht;

public class Bank {
    private static Bank bank = new Bank();
    User user;

    private Bank() {
        user = new User();
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
