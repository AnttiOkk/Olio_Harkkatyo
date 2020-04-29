package com.example.anttiokkonen.olio_ht;

import java.io.Serializable;

public class User implements Serializable {

    private String firstnames = "Matti Antero";
    private String lastname = "Meikäläinen";
    private String bday = "11.04.1990";
    private String address = "Yliopistonkatu 34 A1";

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

}
