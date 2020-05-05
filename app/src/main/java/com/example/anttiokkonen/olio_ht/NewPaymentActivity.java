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
import android.widget.Toast;

import java.sql.SQLOutput;

public class NewPaymentActivity extends AppCompatActivity {
    private Button button1;
    private Button button7;
    private Button button8;
    private Bank bank = Bank.getInstance();
    private Spinner spinner;
    private Spinner spinner2;
    Account account;
    private EditText ammountMoney1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_payment);
        account = (Account) getIntent().getSerializableExtra("account");

        button1 = (Button) findViewById(R.id.etusivu2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });

        
        // TILI JOHON HALUAT LAITTAA RAHAA
        // NÄYTTÄÄ TILIT JOISSA ON SWITCH2 ASENTO = TRUE, EI NÄYTÄ TILEJÄ, JOISSA SWITCH2 = FALSE
        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<Account> adapter = new ArrayAdapter<Account>(this, android.R.layout.simple_spinner_item, bank.getUser().getAccounts());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Account account1 = (Account) parent.getSelectedItem();
                displayAccountData(account1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // TILI, JOSTA HALUAT SIIRTÄÄ RAHAA
        // NÄYTTÄÄ TILIT JOISSA SWITCH1 ASENTO = TRUE, EI NÄYTÄ TILEJÄ, JOISSA SWITCH1 = FALSE
        spinner2 = findViewById(R.id.spinner3);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Account account2 = (Account) parent.getSelectedItem();
                displayAccountData(account2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // RAHAN SIIRTÄMINEN TILIEN VÄLILLÄ
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ammountMoney1 = (EditText) findViewById(R.id.ammountMoney);
                final double ammountMoney2 = Double.parseDouble(ammountMoney1.getText().toString());

                Account acc1 = (Account) spinner.getSelectedItem();
                Account acc2 = (Account) spinner2.getSelectedItem();


                if (acc2.getMoney() > ammountMoney2) {
                    acc1.setMoney((int) (acc1.getMoney()+ammountMoney2));
                    acc2.setMoney((int) (acc2.getMoney()-ammountMoney2));
                    displayAccountDataWhenMoneyAdded(acc1);
                }
                else {
                    displayErrorMessege(acc1);
                }
            }
        });

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityTransactions();
            }
        });

    }

    // MAINACTIVITYN AVAAMINEN
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // TRANSACTIONSACTIVITYN AVAAAMINEN
    public void openActivityTransactions() {
        Intent intent2 = new Intent(this, TransactionsActivity.class);
        intent2.putExtra("account", account);
        startActivity(intent2);
    }

    // VALITUN TILIN TIETOJEN TULOSTAMINEN
    private void displayAccountData(Account account) {
        String accountName = account.getAccountName();
        int money = account.getMoney();

        String accountData = "TILIN NIMI: " + accountName + "\nTILILLÄ RAHAA: " + money;
        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }


    // RAHAN LISÄYS JA PÄIVITETTYJEN TIETOJEN PÄIVITTÄMINEN JOS ONNISTUU
    private void displayAccountDataWhenMoneyAdded(Account account) {
        String accountName = account.getAccountName();
        int money = account.getMoney();
        final double ammountMoney3 = Double.parseDouble(ammountMoney1.getText().toString());


        String accountData = "TILILLE: " + accountName + "\nTILILLE LISÄTTIIN: " + ammountMoney3+"€"+ "\nTILILLÄ RAHAA: "+ money+"€";
        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
        }

    // RAHAN LISÄYS JA PÄIVITETTYJEN TIETOJEN PÄIVITTÄMINEN JOS ONNISTUU
    private void displayErrorMessege(Account account) {
        String accountName = account.getAccountName();
        int money = account.getMoney();
        final double ammountMoney3 = Double.parseDouble(ammountMoney1.getText().toString());


        String accountData = "TILILLE " + accountName + "EI PYSTYTTY \nSIIRTÄMÄÄN "+ ammountMoney3+ "€, \nKOSKA TOISELLA TTILILLÄ EI \nRIITTÄNYT KATE.";
        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }

}

