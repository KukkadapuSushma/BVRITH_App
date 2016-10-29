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

public class EeeActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("Mr.CH.Sunil Kumar,HOD", "9440545949"));
        contacts.add(new contact("Ms.Babita Gupta", "9640603999"));
        contacts.add(new contact("Ms.K.Bhavya", "9573836511"));
        contacts.add(new contact("Mr.Guruswamy Revana", "9985271464"));
        contacts.add(new contact("Ms.K.Amritha", "9885511580"));
        contacts.add(new contact("Mr.G.Sandeep", "8801199945"));
        contacts.add(new contact("Ms.N.Siva Gowri", "8985806346"));
        contacts.add(new contact("Mr.J.Srinivasa Rao", "9866849787"));
        contacts.add(new contact("Ms.P.Subhashitha", "9985214198"));
        contacts.add(new contact("Ms.B.Sujatha", "8142691516"));
        contacts.add(new contact("Mr.A.Venkat Ramana Reddy", "8149165846"));
        contacts.add(new contact("Mr.K.Santhosh Kumar", "9866599494"));
        contacts.add(new contact("Mr.P.Narsimha Ramulu", "9949075686"));
        contacts.add(new contact("Mr.P.L.Srinivas Rao", "9912916156"));

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
                                                    ActivityCompat.requestPermissions(EeeActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
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
