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

import java.util.ArrayList;

public class activity_admin extends AppCompatActivity {

    private com.bvrit.bvritcall.adapter.contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<com.bvrit.bvritcall.model.contact> contacts = new ArrayList<>();
        contacts.add(new com.bvrit.bvritcall.model.contact("DR.K.V.N.SUNITHA, Principal", "9949402211"));
        contacts.add(new com.bvrit.bvritcall.model.contact("JAGAPATHI REDDY.S, PlacementOfficer", "8106184848"));

        contacts.add(new com.bvrit.bvritcall.model.contact("RAMU MANTENA", "9949145656"));


        //this code will be private to current activity.. means scope.. and those class nad layout can be reused..
        //if any change.. then only u have to create new.. otherwise no need


        ListView contactListView = (ListView) findViewById(R.id.contact_list);
        adapter = new com.bvrit.bvritcall.adapter.contactAdapter(this, contacts);
        contactListView.setAdapter(adapter);

        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                final com.bvrit.bvritcall.model.contact current_Contact = adapter.getItem(i);
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
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
                                                    ActivityCompat.requestPermissions(activity_admin.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
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
