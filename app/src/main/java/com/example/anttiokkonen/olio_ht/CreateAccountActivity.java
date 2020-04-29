package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button6;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        button1= (Button) findViewById(R.id.etusivu3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateAndChangeActivity();
            }
        });
        spinner = findViewById(R.id.spinner);

        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account("KULTAPOSSU-TILI", "FI 1234 5678 90", 1000, 10200);
        accountList.add(account1);
        Account account2 = new Account("ASP-TILI", "FI 2468 1357 90", 0, 18000);
        accountList.add(account2);

        ArrayAdapter<Account> adapter = new ArrayAdapter<Account>(this, android.R.layout.simple_spinner_item, accountList);
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
    }

    public void getSelectedAccount(View v) {
        Account account = (Account) spinner.getSelectedItem();
        displayAccountData(account);
    }
    private void displayAccountData(Account account) {
        String accountName = account.getAccountName();
        String accountNumber = account.getAccountNumber();
        int money = account.getMoney();
        int credit = account.getCredit();

        String accountData = "TILIN NIMI: " + accountName + "\nTILINUMERO: " + accountNumber; //"\nRAHAA TILILLÄ: " + money + "\nTILILLÄ LUOTTOA: " + credit;

        Toast.makeText(this, accountData, Toast.LENGTH_LONG).show();
    }


    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openCreateAndChangeActivity() {
        Intent intent2 = new Intent(this, CreateAndChangeAccountActivity.class);
        startActivity(intent2);
    }
}
