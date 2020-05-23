package com.example.anttiokkonen.olio_ht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class TransactionsActivity extends AppCompatActivity {

    ListView listView;
    private Bank bank = Bank.getInstance();
    Account account;
    Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        listView= (ListView) findViewById(R.id.listview);

        account = (Account) getIntent().getSerializableExtra("account");
        card = (Card) getIntent().getSerializableExtra("card");

        AccountListAdapter adapter = new AccountListAdapter(this, R.layout.adapter_view_layout, bank.getUser().getAccounts());
        listView.setAdapter(adapter);
    }
}