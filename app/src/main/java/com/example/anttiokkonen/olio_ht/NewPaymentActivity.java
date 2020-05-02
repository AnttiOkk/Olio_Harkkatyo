package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class NewPaymentActivity extends AppCompatActivity {
    private Button button1;
    private Button button7;
    private Button button8;
    private Bank bank = Bank.getInstance();
    private Spinner spinner;
    Account account;
    private EditText ammountMoney;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_payment);
        account = (Account) getIntent().getSerializableExtra("account");

        // Display all accounts


        button1= (Button) findViewById(R.id.etusivu2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });
        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<Account> adapter = new ArrayAdapter<Account>(this, android.R.layout.simple_spinner_item, bank.getUser().getAccounts());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Account account = (Account) parent.getSelectedItem();
                displayAccountData(account);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ammountMoney = (EditText) findViewById(R.id.ammountMoney);
        button7= (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAccountDataWhenMoneyAdded(account);
            }
        });

        listView = (ListView) findViewById(R.id.listview);


    }
    // MAINACTIVITYN AVAAMINEN
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // VALITUN TILIN TIETOJEN TULOSTAMINEN
    private void displayAccountData(Account account) {
        String accountName = account.getAccountName();
        int money = account.getMoney();

        String accountData = "TILIN NIMI: " + accountName + "\nTILILLÄ RAHAA: " + money;

        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }


    // RAHAN LISÄYS JA PÄIVITETTYJEN TIETOJEN PÄIVITTÄMINEN
    private void displayAccountDataWhenMoneyAdded(Account account) {
        String accountName = account.getAccountName();
        int money = account.getMoney();

        String newMoney = ammountMoney.getText().toString();

        if (ammountMoney != null) {
            int finalValue = Integer.parseInt(newMoney);
            money = money + finalValue;
            String accountData = "TILIN NIMI: " + accountName + "\nTILILLE LISÄTTY RAHAA: " + finalValue + "\nTILILLÄ RAHAA LISÄYKSEN JÄLKEEN: " + money;
            Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
        }
    }
}
