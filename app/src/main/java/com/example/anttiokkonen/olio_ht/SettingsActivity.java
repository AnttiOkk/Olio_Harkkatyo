package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SettingsActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        user = (User) getIntent().getSerializableExtra("user");

        System.out.println(user.getFirstnames());

        // Tulostaa EditTex -tekstikenttiin oliolle annetut vakio-arvot
        // Etunimet
        EditText editText1 = (EditText) findViewById(R.id.FirstNames);
        editText1.setText(user.getFirstnames());

        // Sukunimi
        EditText editText2 = (EditText) findViewById(R.id.LastName);
        editText2.setText(user.getLastname());
        // Syntymäaika
        EditText editText3 = (EditText) findViewById(R.id.Birthday);
        editText3.setText(user.getBday());
        // Osoite
        EditText editText4 = (EditText) findViewById(R.id.Address);
        editText4.setText(user.getAddress());


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
                user.setFirstnames(editText1.getText().toString());
                openActivityMain();
            }
        });


    }
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

