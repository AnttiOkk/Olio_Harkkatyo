package com.example.anttiokkonen.olio_ht;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class AccountListAdapter extends ArrayAdapter<Account> {
    private Context mContext;
    int mResource;


    public AccountListAdapter(Context context, int resource, ArrayList<Account> accounts) {
        super(context, resource, accounts);
        mContext = context;
        mResource = resource;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String tilinnimi = getItem(position).getAccountName();
        String tilinro = getItem(position).getAccountNumber();
        int raha = getItem(position).getMoney();
        double viimeinenTilitapahtuma = getItem(position).getLastPayment();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvAccountName = (TextView) convertView.findViewById(R.id.textView21);
        TextView tvAccountNumber = (TextView) convertView.findViewById(R.id.textView22);
        TextView tvMoney = (TextView) convertView.findViewById(R.id.textView23);
        TextView tvCredit = (TextView) convertView.findViewById(R.id.textView24);


        tvAccountName.setText(tilinnimi);
        tvAccountNumber.setText(tilinro);
        tvCredit.setText(Double.toString(viimeinenTilitapahtuma));
        tvMoney.setText(Integer.toString(raha));

        return convertView;
    }
}
