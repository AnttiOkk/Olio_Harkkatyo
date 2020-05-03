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
    ListView mListView = (ListView) findViewById(R.id.listview);
    private Bank bank = Bank.getInstance();
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        account = (Account) getIntent().getSerializableExtra("account");

        // Display all accounts
        listView = (ListView) findViewById(R.id.listview);
        AccountListAdapter adapter = new AccountListAdapter(this, R.layout.adapter_view_layout, bank.getUser().getAccounts());
        mListView.setAdapter(adapter);
    }
}
