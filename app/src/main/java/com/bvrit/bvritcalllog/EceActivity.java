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

public class EceActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("J.NAGA VISHNU VARDHAN", "9848805545"));
        contacts.add(new contact("A RADHA", "9542500047"));
        contacts.add(new contact("ANIL KUMAR.Y", "8977032055"));
        contacts.add(new contact("ANWAR BHASHA PATTAN", "9440215230"));
        contacts.add(new contact("BRINDA DEVI.K", "9441368809"));
        contacts.add(new contact("DR. K. SEETHAIAH", "9666837310"));
        contacts.add(new contact("G SIVA SANKAR VARMA", "9642558871"));
        contacts.add(new contact("M.PRAVEENA", "9492429500"));
        contacts.add(new contact("MAHESH BABU KATTA", "9246116325"));
        contacts.add(new contact("P RAJESH KUMAR", "9849898606"));
        contacts.add(new contact("PRASHANTI.P", "9866076385"));
        contacts.add(new contact("R. MADHAVI", "9866812121"));
        contacts.add(new contact("R. PRIYAKANTH", "9849407965"));
        contacts.add(new contact("R.SRIDEVI", "9490133906"));
        contacts.add(new contact("SAI KRISHNA KUMAR N M", "9676386262"));
        contacts.add(new contact("SHYLAJA.R", "8179045635"));
        contacts.add(new contact("SIVA S SINTHURA", "8179751038"));
        contacts.add(new contact("V HINDUMATHI", "9866676690"));


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
