package com.example.anttiokkonen.olio_ht;

import java.io.Serializable;
import java.util.ArrayList;

public class Card implements Serializable {

    public String cardName;
    public String cardNumber;
    public String cardType;
    public String cardCredit;

    Account account;

    public Card(String cardName, String cardNumber, String cardType, String cardCredit) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardCredit = cardCredit;

        /*Card c1 = new Card("Visa", "123456789", "Debit", "0");
        Card c2 = new Card("Visa Electron", "123456789", "Debit", "0");
        Card c3 = new Card("MasterCard", "123456789", "Debit", "0");
        Card c4 = new Card("MasterCard Gold", "123456789", "Debit", "0");
        Card c5 = new Card("American Express", "123456789", "Debit", "0");
        Card c6 = new Card("Visa", "123456789", "Credit", "1000");
        Card c7 = new Card("Visa Electron", "123456789", "Credit", "1000");
        Card c8 = new Card("MasterCard", "123456789", "Credit", "1000");
        Card c9 = new Card("MasterCard Gold", "123456789", "Credit", "1000");
        Card c10 = new Card("American Express", "123456789", "Credit", "1000");

        account.addCard(c1);
        account.addCard(c2);
        account.addCard(c3);
        account.addCard(c4);
        account.addCard(c5);
        account.addCard(c6);
        account.addCard(c7);
        account.addCard(c8);
        account.addCard(c9);
        account.addCard(c10);*/

    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardCredit() {
        return cardCredit;
    }

    public void setCardCredit(String cardCredit) {
        this.cardCredit = cardCredit;
    }

    @Override
    public String toString() {
        return cardName;
    }

}