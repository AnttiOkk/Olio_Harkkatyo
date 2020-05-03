package com.example.anttiokkonen.olio_ht;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String firstnames = "Matti Antero";
    private String lastname = "Meikäläinen";
    private String bday = "11.04.1990";
    private String address = "Yliopistonkatu 34 A1";

    private ArrayList<Account> accounts = new ArrayList<Account>();

    public String getFirstnames(){
        return firstnames;
    }
    public String getLastname(){
        return lastname;
    }
    public String getBday(){
        return bday;
    }
    public String getAddress() {
        return address;
    }

    public void setFirstnames(String newFirstnames) {
        this.firstnames = newFirstnames;
    }
    public void setLastname(String newLastname) {
        this.lastname = newLastname;
    }
    public void setBday(String newBday) {
        this.bday = newBday;
    }
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

}
