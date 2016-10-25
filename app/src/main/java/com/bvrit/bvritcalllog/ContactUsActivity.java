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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bvrit.bvritcalllog.adapter.*;
import com.bvrit.bvritcalllog.adapter.contactAdapter;
import com.bvrit.bvritcalllog.model.*;

import java.util.ArrayList;

public class ContactUsActivity extends AppCompatActivity {
    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ArrayList<com.bvrit.bvritcalllog.model.contact> contacts = new ArrayList<>();
        contacts.add(new com.bvrit.bvritcalllog.model.contact("JAGAPATHI REDDY.S, PlacementOfficer", "8106184848"));
        contacts.add(new com.bvrit.bvritcalllog.model.contact("CH. JHANSI LAKSHMI", "9963341529"));
        contacts.add(new com.bvrit.bvritcalllog.model.contact("G SURESH", "7095882695"));
        contacts.add(new com.bvrit.bvritcalllog.model.contact("MEENAKSHI", "9490335004"));
        contacts.add(new com.bvrit.bvritcalllog.model.contact("P MAHESH", "9000336040"));
        contacts.add(new com.bvrit.bvritcalllog.model.contact("P VENKATESWARA RAO", "9704804201"));
        contacts.add(new com.bvrit.bvritcalllog.model.contact("P VIJAYALAKSHMI", "9701001927"));
        contacts.add(new com.bvrit.bvritcalllog.model.contact("RAMU MANTENA", "9949145656"));



        //this code will be private to current activity.. means scope.. and those class nad layout can be reused..
        //if any change.. then only u have to create new.. otherwise no need


        ListView contactListView = (ListView) findViewById(R.id.contact_list);
        adapter = new com.bvrit.bvritcalllog.adapter.contactAdapter(this, contacts);
        contactListView.setAdapter(adapter);

        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final com.bvrit.bvritcalllog.model.contact current_Contact = adapter.getItem(i);
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
