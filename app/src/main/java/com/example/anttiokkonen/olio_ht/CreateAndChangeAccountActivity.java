package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


public class CreateAndChangeAccountActivity extends AppCompatActivity {

    private Button button5;
    Account account;

    private TextView accountName;
    private TextView accountNumber;

    private Switch switch1;
    private Switch switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_and_change_account);

        accountName = findViewById(R.id.textView8);
        accountNumber = findViewById(R.id.textView10);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });

        account = (Account) getIntent().getSerializableExtra("account");

        if (account != null) {
            accountName.append(account.getAccountName());
            accountNumber.append(account.getAccountNumber());
        }
    }
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
