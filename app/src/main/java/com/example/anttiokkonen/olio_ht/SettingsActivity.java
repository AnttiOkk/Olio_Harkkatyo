package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class SettingsActivity extends AppCompatActivity implements Serializable {
    private Button button1;
    private Button button2;

    User newUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        System.out.println(newUser.getFirstnames());

        // Tulostaa EditTex -tekstikenttiin oliolle annetut vakio-arvot
        // Etunimet
        EditText editText1 = (EditText) findViewById(R.id.FirstNames);
        editText1.setText(newUser.getFirstnames());

        // Sukunimi
        EditText editText2 = (EditText) findViewById(R.id.LastName);
        editText2.setText(newUser.getLastname());
        // Syntymäaika
        EditText editText3 = (EditText) findViewById(R.id.Birthday);
        editText3.setText(newUser.getBday());
        // Osoite
        EditText editText4 = (EditText) findViewById(R.id.Address);
        editText4.setText(newUser.getAddress());


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
                newUser.setFirstnames(editText1.getText().toString());
                System.out.println();
                System.out.println("\n\n moi \n\n");
                System.out.println(newUser.getFirstnames());
                openActivityMain();
            }
        });


    }
    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

