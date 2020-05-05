package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class CreateAndChangeAccountActivity extends AppCompatActivity {

    private Button button5;
    Account account;
    private TextView accountName;
    private TextView accountNumber;
    private Bank bank = Bank.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_and_change_account);

        account = (Account) getIntent().getSerializableExtra("account");

        // TILIN NIMEN JA TILINUMERON TULOSTAMINEN TEXTVIEW-KENTTIIN
        accountName = findViewById(R.id.textView8);
        accountNumber = findViewById(R.id.textView10);

        // EHTO
        if (account != null) {
            accountName.append(account.getAccountName());
            accountNumber.append(account.getAccountNumber());
        }

        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setChecked(account.getCanDepositMoney());

        final Switch switch2 = (Switch) findViewById(R.id.switch2);
        switch2.setChecked(account.getCanTransferMoney());

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    account.setCanDepositMoney(true);
                    System.out.println("nappi on ON-Asennossa");
                }
                else {
                    account.setCanDepositMoney(false);
                    System.out.println("nappi on OFF-Asennossa");
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    account.setCanTransferMoney(true);
                    System.out.println("nappi on ON-Asennossa");
                }
                else {
                    account.setCanTransferMoney(false);
                    System.out.println("nappi on OFF-Asennossa");
                }
            }
        });

        // TIETOJEN MUOKKAAMINEN, TALLENTAMINEN JA PALUU ETUSIVULLE
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // SWITCHIN ASENNON PÄIVITTÄMINEN UUDEKSI OLION ARVOKSI
                openActivityMain();
            }
        });

    }
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
