package com.bvrit.bvritcall;

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

import com.bvrit.bvritcall.adapter.contactAdapter;
import com.bvrit.bvritcall.model.contact;

import java.util.ArrayList;

public class ItActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

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
        contacts.add(new contact("M. PARICHAY", "9000397776"));
        contacts.add(new contact("SAILAJA DANTULURI", "9000949905"));
        contacts.add(new contact("TALLURI PRAVEEN KUMAR", "9492425554"));


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
                builder.setTitle(current_Contact != null ? current_Contact.getName() : null)
                        .setItems(new CharSequence[]{"Call", "SMS"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final Intent intent;
                                switch (i) {
                                    case 0:
                                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + current_Contact.getNumber()));
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                                    ActivityCompat.requestPermissions(ItActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                                                }
                                                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                                    startActivity(intent);
                                                }/* else {
                                                    AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                                                    builder1.setTitle("Permission Denied")
                                                            .setMessage("App is not allowed to make calls. Please change permission in settings or select allow on permission dialog to make call.")
                                                            .setPositiveButton("OK", null);
                                                    builder1.show();//or leave...
                                                }
*/
                                            }
                                        });
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
