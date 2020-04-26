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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        startActivity(intent1);

    }
    public void openActivityNewAccount() {
        Intent intent3 = new Intent(this, CreateAccountActivity.class);
        startActivity(intent3);
    }
    public void openActivitySettings() {
        Intent intent4 = new Intent(this, SettingsActivity.class);
        startActivity(intent4);
    }

}
