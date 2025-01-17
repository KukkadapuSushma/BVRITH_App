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

public class transport extends AppCompatActivity {
    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("Transport I/C : Ch.Sunil Kumar", "9676124655"));
        contacts.add(new contact("Route 1:Mr.Samson", "8187884887"));
        contacts.add(new contact("Route 2:Mr.Shiva Kumar", "8985558872"));
        contacts.add(new contact("Route 3:Satyanarayana", "8106439123"));
        contacts.add(new contact("Route 4:Mr.Md. Kaleel", "9652766798"));
        contacts.add(new contact("Route 5:Mr.Mogili", "7382849741"));
        contacts.add(new contact("Route 6:Mr.Jangaiah", "9010392076"));
        contacts.add(new contact("Route 7:Mr.Satyam", "9908113382"));
        contacts.add(new contact("Route 8:Mr.Umesh", "9705561697"));
        contacts.add(new contact("Route 9:Mr.V Shiva", "8790652129"));
        contacts.add(new contact("Route 10:Mr.Jangeer", "9100243876"));
        contacts.add(new contact("Route 11:Mr.Mahaboob", "9347524397"));
        contacts.add(new contact("Route 12:Mr.Raja Reddy", "9553839228"));
        contacts.add(new contact("Route 13:Mr.Md. Gouse", "9059178318"));



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
                                                    ActivityCompat.requestPermissions(transport.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
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
