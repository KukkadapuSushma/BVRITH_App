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

public class ItActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("S.L.ARUNA RAO,HOD", "9553605898"));
        contacts.add(new contact("NAVEEN KUMAR LASKARI", "9701050001"));
        contacts.add(new contact("A. ARUNA JYOTHI", "9248326756"));
        contacts.add(new contact("DEEPIKA SINGH", "7838178877"));
        contacts.add(new contact("DIPALI PATTANAYAK", "9959437808"));
        contacts.add(new contact("KODUMURI BHARGAV RAM", "9160329739"));
        contacts.add(new contact("LAKSHMI. PRASANTHI.M", "9573417348"));
        contacts.add(new contact("MUGADA SWATHI", "9581536127"));
        contacts.add(new contact("P S LATHA KALYAMPUDI", "8985036362"));
        contacts.add(new contact("S. RAMA DEVI", "9866511230"));
        contacts.add(new contact("SANGEETHA DHARMAPURI", "9966581857"));


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
