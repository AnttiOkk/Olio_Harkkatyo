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
    private Button button10;
    private Bank bank = Bank.getInstance();
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    Account account;
    private EditText ammountMoney1;
    private EditText amountMoney1;


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
                if (account1.getCanTransferMoney() == true) {
                    displayAccountData(account1);
                }
                else {
                    displayError1(account1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // TILI, JOSTA HALUAT SIIRTÄÄ RAHAA
        spinner2 = findViewById(R.id.spinner3);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Account account2 = (Account) parent.getSelectedItem();
                if (account2.getCanDepositMoney() == true) {
                    displayAccountData(account2);
                }
                else {
                    displayError2(account2);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // TILI, JOLLE HALUAT LISÄÄ RAHAA
        spinner3 = findViewById(R.id.spinner4);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Account account2 = (Account) parent.getSelectedItem();
                if (account2.getCanTransferMoney() == true) {
                    displayAccountData(account2);
                }
                else {
                    displayError1(account2);
                }
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

                    acc1.setLastPayment(ammountMoney2);
                    acc2.setLastPayment(-ammountMoney2);

                    displayAccountDataWhenMoneyAdded(acc1);
                }
                else {
                    displayErrorMessege(acc1);
                }
            }
        });
        
        // RAHAN SIIRTÄMINEN TILILLE
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountMoney1 = (EditText) findViewById(R.id.ammountMoney2);
                final double amountMoney3 = Double.parseDouble(amountMoney1.getText().toString());

                Account acc3 = (Account) spinner3.getSelectedItem();

                acc3.setLastPayment(amountMoney3);
                displayAccountDataWhenMoneyAdded2(acc3);
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
    private void displayAccountDataWhenMoneyAdded2(Account account) {
        String accountName = account.getAccountName();
        int money = account.getMoney();
        final double amountMoney3 = Double.parseDouble(amountMoney1.getText().toString());

        String accountData = "TILILLE: " + accountName + "\nTILILLE LISÄTTIIN: " + amountMoney3+"€"+ "\nTILILLÄ RAHAA: "+ money+"€";
        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }

    // RAHAN LISÄYS JA PÄIVITETTYJEN TIETOJEN PÄIVITTÄMINEN JOS EI ONNISTU
    private void displayErrorMessege(Account account) {
        String accountName = account.getAccountName();
        int money = account.getMoney();
        final double ammountMoney3 = Double.parseDouble(ammountMoney1.getText().toString());

        String accountData = "ERROR: Tilille " + accountName + " ei pystytty \nsiirtämään "+ ammountMoney3+ "€, koska \ntoisella tilillä ei riittänyt kate.";
        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }
    private void displayError1(Account account) {
        String accountName = account.getAccountName();

        String accountData = "ERROR: VÄÄRÄ VALINTA. \n" + "Tilille " +accountName+ " ei voida lisätä rahaa.";
        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }
    private void displayError2(Account account) {
        String accountName = account.getAccountName();

        String accountData = "ERROR: VÄÄRÄ VALINTA. \n" + "Tililtä " +accountName+ " ei voida siirtää rahaa.";
        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }

}

