package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button3;
    private Button button4;
    private Button button11;

    private Account account;
    protected Card card;
    private Bank bank = Bank.getInstance();
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        System.out.println(bank.getUser().getAccounts().get(0).getCards());

        System.out.println("\n\n");
        System.out.println(bank.getUser().getAccounts());
        System.out.println();
        System.out.println("\n\n");
        //System.out.println(account.getPrimaryCard());

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

        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateCard();
            }
        });

    }

    // UUSI MAKSU AKTIVITEETIN AVAAMINEN
    public void openActivityNewPayment() {
        Intent intent1 = new Intent(this, NewPaymentActivity.class);
        //intent1.putExtra("account", account);
        startActivity(intent1);

    }
    // UUDEN TILIN LUONTI AKTIVITEETIN AVAAMINEN
    public void openActivityNewAccount() {
        Intent intent3 = new Intent(MainActivity.this, CreateAccountActivity.class);
        //intent3.putExtra("account", account);
        //intent3.putExtra("card", card);
        startActivity(intent3);
    }
    // ASETUS AKTIVITEETIN AVAAMINEN
    public void openActivitySettings() {
        Intent intent4 = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent4);
    }
    // PANKKIKORTIN LUONNIN AKTIVITEETIN AVAAMINEN
    public void openCreateCard() {
        Intent intent5 = new Intent(this, CreateCard.class);
        //intent5.putExtra("account", user);
        //System.out.println(user);
        startActivity(intent5);
    }

}

