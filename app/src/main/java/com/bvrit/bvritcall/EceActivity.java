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

public class EceActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("Mr.J.Naga Vishnu Vardhan,HOD", "9848805545"));
        contacts.add(new contact("Ms.A.Radha", "9542500047"));
        contacts.add(new contact("Mr.Y.Anil Kumar", "8977032055"));
        contacts.add(new contact("Mr.Anwar Bhasha Pattan", "9440215230"));
        contacts.add(new contact("Ms.K.Brinda Devi", "9441368809"));
        contacts.add(new contact("Mr.D.Venkata Siva Prasad", "8985596616"));
        contacts.add(new contact("Mr.K.Seethaiah", "9666837310"));
        contacts.add(new contact("Ms.G.Drakshayini", "8465854684"));
        contacts.add(new contact("Ms.G.Ramalakshmi", "9177501926"));
        contacts.add(new contact("Ms.K.Suneela", "9581206699"));
        contacts.add(new contact("Mr.M.Venkatesh", "9030798001"));
        contacts.add(new contact("Mr.G.Siva Sankar Varma", "9642558871"));
        contacts.add(new contact("Ms.M.Praveena", "9492429500"));
        contacts.add(new contact("Mr.K.Mahesh Babu", "9246116325"));
        contacts.add(new contact("Dr.P.Rajesh Kumar", "9849898606"));
        contacts.add(new contact("Ms.P.Prashanthi", "9866076385"));
        contacts.add(new contact("Ms.R.Madhavi", "9866812121"));
        contacts.add(new contact("Mr.R.Priyakanth", "9849407965"));
        contacts.add(new contact("Ms.R.Sridevi", "9490133906"));
        contacts.add(new contact("Mr.N.M.Sai Krishna Kumar", "9676386262"));
        contacts.add(new contact("Ms.R.Shylaja", "8179045635"));
        contacts.add(new contact("Ms.Siva.S.Sinthura", "8179751038"));
        contacts.add(new contact("Ms.V.Hindumathi", "9866676690"));
        contacts.add(new contact("Mr.M.H.N.V.Prasad", "9949074336"));
        contacts.add(new contact("Mr.Srinivasa Rao", "9440031557"));



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
                                                    ActivityCompat.requestPermissions(EceActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
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
