package com.bvrit.bvritcalllog;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CseActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("A VASANTHI, HOD", "8885510777"));
        contacts.add(new contact("A SALEEM", "7660000933"));
        contacts.add(new contact("AMARINDER KAUR", "9581461000"));
        contacts.add(new contact("B NAGAVENI", "9703218899"));
        contacts.add(new contact("BRAHMA NAIDU KAKARLA", "9912494400"));
        contacts.add(new contact("K V SHARADA", "9494266156"));
        contacts.add(new contact("KOENNI NARESH", "9989803310"));
        contacts.add(new contact("P KAVITHA", "8790020724"));
        contacts.add(new contact("POORNIMA K", "9100930829"));
        contacts.add(new contact("RAJESH KANDAKATLA", "9505060105"));
        contacts.add(new contact("SHANTI GUNNA", "9701507468"));
        contacts.add(new contact("SWAPNA D", "9177322252"));
        contacts.add(new contact("TILOTTAMA GOSWAMI", "9849561801"));
        contacts.add(new contact("V NANI KALYAN", "9966626954"));
        contacts.add(new contact("H SANTOSH KUMARI", "9912888716"));
        contacts.add(new contact("K SASI PAVANI PRIYA", "9292552733"));
        contacts.add(new contact("K YESU PADAM", "9704220395"));
        contacts.add(new contact("SAI RAMANI P", "9000502220"));
        contacts.add(new contact("SIRISHA G", "9494239931"));

        //this code will be private to current activity.. means scope.. and those class nad layout can be reused..
        //if any change.. then only u have to create new.. otherwise no need


        ListView contactListView = (ListView) findViewById(R.id.contact_list);
        adapter = new contactAdapter(this, contacts);
        contactListView.setAdapter(adapter);

        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final contact current_Contact = adapter.getItem(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(current_Contact.getName())
                        .setItems(new CharSequence[]{"Call", "SMS"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent;
                                switch (i) {
                                    case 0:
                                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + current_Contact.getNumber()));
                                        if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                            //    ActivityCompat#requestPermissions
                                            // here to request the missing permissions, and then overriding
                                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                            //                                          int[] grantResults)
                                            // to handle the case where the user grants the permission. See the documentation
                                            // for ActivityCompat#requestPermissions for more details
                                            return;
                                        }
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + current_Contact.getNumber()));
                                        startActivity(intent);
                                        break;
                                }
                            }
                        });
                builder.show();
            }
        });

    }
}
