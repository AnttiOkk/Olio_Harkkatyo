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

    private Bank bank = Bank.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_and_change_account);

        account = (Account) getIntent().getSerializableExtra("account");

        accountName = findViewById(R.id.textView8);
        accountNumber = findViewById(R.id.textView10);

        switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setChecked(account.getCanTransferMoney());

        switch2 = (Switch) findViewById(R.id.switch2);
        switch2.setChecked(account.getCanDepositMoney());


        if (account != null) {
            accountName.append(account.getAccountName());
            accountNumber.append(account.getAccountNumber());
        }


        // TIETOJEN MUOKKAAMINEN, TALLENTAMINEN JA PALUU ETUSIVULLE
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // SWITCHIN ASENNON PÄIVITTÄMINEN UUDEKSI OLION ARVOKSI
                boolean switch1value = switch1.isChecked();
                System.out.println(switch1value);

                account.setCanTransferMoney(switch1.isChecked());
                account.setCanDepositMoney(switch2.isChecked());
                openActivityMain();
            }
        });


    }
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
