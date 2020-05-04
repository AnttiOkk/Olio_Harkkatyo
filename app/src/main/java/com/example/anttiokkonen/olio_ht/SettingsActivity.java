package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SettingsActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    private Bank bank = Bank.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Tulostaa EditTex -tekstikenttiin oliolle annetut vakio-arvot
        // Etunimet
        EditText editText1 = (EditText) findViewById(R.id.FirstNames);
        editText1.setText(bank.user.getFirstnames());

        // Sukunimi
        EditText editText2 = (EditText) findViewById(R.id.LastName);
        editText2.setText(bank.user.getLastname());
        // Syntymäaika
        EditText editText3 = (EditText) findViewById(R.id.Birthday);
        editText3.setText(bank.user.getBday());
        // Osoite
        EditText editText4 = (EditText) findViewById(R.id.Address);
        editText4.setText(bank.user.getAddress());

        button1= (Button) findViewById(R.id.etusivu1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }

        });

        button2 = (Button) findViewById(R.id.SaveChanges);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Etunimien muokkaus
                EditText editText1 = (EditText) findViewById(R.id.FirstNames);
                bank.user.setFirstnames(editText1.getText().toString());

                // Sukunimien Muokkaus
                EditText editText2 = (EditText) findViewById(R.id.LastName);
                bank.user.setLastname(editText2.getText().toString());
                openActivityMain();

                // Syntymäajan muokkaus
                EditText editText3 = (EditText) findViewById(R.id.Birthday);
                bank.user.setBday(editText3.getText().toString());

                // Osoitteen muokkaus
                EditText editText4 = (EditText) findViewById(R.id.Address);
                bank.user.setAddress(editText4.getText().toString());

                openActivityMain();
            }
        });


    }
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

