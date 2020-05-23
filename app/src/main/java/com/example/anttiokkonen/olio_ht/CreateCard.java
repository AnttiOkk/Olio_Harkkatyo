package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import java.sql.SQLOutput;

public class CreateCard extends AppCompatActivity {
    private Button button12;

    Account account;
    private TextView accountName;

    private Bank bank = Bank.getInstance();
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;

    private EditText creditAmmount;

    String c13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        //System.out.println(bank.user.getAccounts());

        spinner5 = findViewById(R.id.spinner5);

        ArrayAdapter<Account> adapter = new ArrayAdapter<Account>(this, android.R.layout.simple_spinner_item, bank.getUser().getAccounts());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Account account = (Account) parent.getSelectedItem();

                displayAccountData(account);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        // PANKKIKORTIN MALLI
        spinner6 = findViewById(R.id.spinner6);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("VISA");
        arrayList.add("VISA Electron");
        arrayList.add("MasterCard");
        arrayList.add("MasterCard Gold");
        arrayList.add("American Express");

        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);

        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner6.setAdapter(adapter12);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cardModel = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "VALITTU: " + cardModel, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        // PANKKIKORTIN TYYPPI
        spinner7 = findViewById(R.id.spinner7);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("DEBIT");
        arrayList2.add("CREDIT");

        ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);

        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner7.setAdapter(adapter22);
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cardType = parent.getItemAtPosition(position).toString();

                if (cardType == "DEBIT") {
                    Toast.makeText(parent.getContext(), "VALITTU: " + cardType + "\n Kortille ei voi lisätä luottoa", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(parent.getContext(), "VALITTU: " + cardType, Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String accountName = account.getAccountName();
                Account acc11 = (Account) spinner5.getSelectedItem();
                String c11 = (String) spinner6.getSelectedItem();
                String c12 = (String) spinner7.getSelectedItem();

                String serial = "";
                for (int i = 0; i < 4; i++) {
                    int rand = (int)(Math.random() * 8999) + 1000;
                    serial += String.valueOf(rand) + " ";
                }

                //int index = spinner5.getSelectedItemPosition();

                //String creditAmmount = editText.getText().toString();

                creditAmmount = (EditText) findViewById(R.id.editText);
                String creditAmmount2 = creditAmmount.getText().toString();

                if (c12 == "DEBIT") {
                    acc11.addCard(new Card(c11,c12, serial,"0"));
                }else {
                    acc11.addCard(new Card(c11,c12, serial,creditAmmount2));
                }
            }
        });

    }

    private void displayAccountData(Account account) {
        String accountName = account.getAccountName();

        String accountData = "TILIN NIMI: " + accountName;

        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }

    private void displayAccountData1(Account account) {
        String accountName = account.getAccountName();

        String accountData = "TILIN NIMI: " + accountName;

        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }


    /*private void displayNewCardData(Account account) {
       String newAccountName = account.getPrimaryCard().getCardName();

        String accountData1 = "UUSI KORTII: " + newAccountName + "LISÄTTY";

        Toast.makeText(this, accountData1, Toast.LENGTH_LONG).show();
    }*/
}

