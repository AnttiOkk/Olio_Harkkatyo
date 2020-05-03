package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button3;
    private Button button4;

    protected Account account;

    protected User user;

    private Bank bank = Bank.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // OLETUSTILIEN LUONTI
        Account account1 = new Account("KULTAPOSSU-TILI", "FI 1234 5678 90", 1000, 10200);
        Account account2 = new Account("ASP-TILI", "FI 2468 1357 90", 0, 18000);

        bank.getUser().addAccount(account1);
        bank.getUser().addAccount(account2);

        account = (Account) getIntent().getSerializableExtra("account");

        button1 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityNewPayment();
            }
        });
        button3 = (Button) findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityNewAccount();
            }
        });
        button4 = (Button) findViewById(R.id.button3);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySettings();
            }
        });

    }

    public void openActivityNewPayment() {
        Intent intent1 = new Intent(this, NewPaymentActivity.class);
        intent1.putExtra("account", account);
        intent1.getSerializableExtra("account");
        startActivity(intent1);

    }
    public void openActivityNewAccount() {
        Intent intent3 = new Intent(MainActivity.this, CreateAccountActivity.class);
        intent3.putExtra("account", account);
        startActivity(intent3);
    }
    public void openActivitySettings() {
        Intent intent4 = new Intent(MainActivity.this, SettingsActivity.class);
        intent4.putExtra("user", user);
        startActivity(intent4);
    }

}

