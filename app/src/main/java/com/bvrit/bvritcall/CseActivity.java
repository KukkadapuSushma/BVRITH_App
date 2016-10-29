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

public class CseActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new com.bvrit.bvritcall.model.contact("DR.K.V.N.Sunitha, Principal", "9949402211"));
        contacts.add(new contact("Ms.A.Vasanthi,HOD", "8885510777"));
        contacts.add(new contact("Mr.A.Saleem", "7660000933"));
        contacts.add(new contact("Ms.Amarinder Kaur", "9581461000"));
        contacts.add(new contact("Ms.B.Nagaveni", "9703218899"));
        contacts.add(new contact("Mr.K.Brahma Naidu", "9912494400"));
        contacts.add(new contact("Ms.K.V.Sharada", "9494266156"));
        contacts.add(new contact("Mr.K.Naresh", "9989803310"));
        contacts.add(new contact("Ms.P.Kavitha", "8790020724"));
        contacts.add(new contact("Ms.K.Poornima", "9100930829"));
        contacts.add(new contact("Mr.K.Rajesh", "9505060105"));
        contacts.add(new contact("Ms.Shanti.G", "9701507468"));
        contacts.add(new contact("Ms.Swapna.D", "9177322252"));
        contacts.add(new contact("Ms.Tilottama Goswami", "9849561801"));
        contacts.add(new contact("Mr.V.Nani Kalyan", "9966626954"));
        contacts.add(new contact("Ms.H.Santosh Kumari", "9912888716"));
        contacts.add(new contact("Ms.K.Sasi Pavani Priya", "9292552733"));
        contacts.add(new contact("Mr.K.Yesu Padam", "9704220395"));
        contacts.add(new contact("Ms.P.Sai Ramani", "9000502220"));
        contacts.add(new contact("Ms.G.Sirisha", "9494239931"));


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
                                                    ActivityCompat.requestPermissions(CseActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
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
