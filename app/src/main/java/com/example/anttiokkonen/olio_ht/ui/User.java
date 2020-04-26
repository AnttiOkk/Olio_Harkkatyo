package com.example.anttiokkonen.olio_ht.ui;

import java.io.Serializable;

public class User implements Serializable {

    private String firstnames;
    private String lastname;
    private String bday;
    private String address;

    public User() {
        firstnames = "Matti Antero";
        lastname = "Meikäläinen";
        bday = "11.4.1990";
        address = "Yliopistonkatu 34 A1";
    }

    public User(String firstnames, String lastname, String bday, String address) {
        this.firstnames = firstnames;
        this.lastname = lastname;
        this.bday = bday;
        this.address = address;
    }

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

}
