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

public class BshActivity extends AppCompatActivity {

    private contactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsh);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("DR. P. Anuradha,HOD", "9989448015"));
        contacts.add(new contact("DR.J.Manoj Kumar", "9247164714"));
        contacts.add(new contact("Mr.A.Sampath Kumar", "9963977802"));
        contacts.add(new contact("Ms.A.Ramya", "9640125266"));
        contacts.add(new contact("Ms.B.Sreekala", "9493019971"));
        contacts.add(new contact("Ms.D.Chaya Kumari", "9666699505"));
        contacts.add(new contact("Ms.Deepika.G", "9177222460"));
        contacts.add(new contact("DR.M.Venkanna", "9492210041"));
        contacts.add(new contact("DR.K.Kavitha", "9298801605"));
        contacts.add(new contact("Mr.Kasturi Sydaiah", "9440527274"));
        contacts.add(new contact("Mr.M.Gangadhar Tilak", "9912333223"));
        contacts.add(new contact("Mr.M.Gopi Krishna", "9542723245"));
        contacts.add(new contact("Mr.K.Nagendra Kumar", "9912521818"));
        contacts.add(new contact("Mr.T.Ramesh", "9160400066"));
        contacts.add(new contact("Ms.B.Anna Tanuja Safala", "9030916646"));
        contacts.add(new contact("Ms.B.Rajitha", "9642342220"));
        contacts.add(new contact("Ms.Faith Manjusha Vijayalatha", "9966462671"));
        contacts.add(new contact("Ms.V.Saileela", "8886812956"));
        contacts.add(new contact("Ms.V.Malathi", "9666350035"));
        contacts.add(new contact("Mr.NV.Samba Murthy", "9985778854"));
        contacts.add(new contact("Ms.P.Sharadha", "8790252407"));
        contacts.add(new contact("Ms.B.Sunita Rao", "8501825377"));
        contacts.add(new contact("Ms.T.Mounika", "9494877559"));
        contacts.add(new contact("Ms.T.Roja Rani", "9490969499"));
        contacts.add(new contact("Ms.V.Madhavi", "9494803119"));
        contacts.add(new contact("Ms.G.Krishnaveni", "9948628216"));
        contacts.add(new contact("Ms.G.Swathi", "9676630355"));
        contacts.add(new contact("Ms.J.R.K.S.M.Lakshmi", "9848566118"));
        contacts.add(new contact("Mr.K.Venkata Nagaraju", "9705386543"));
        contacts.add(new contact("Ms.K.Geetha Rani", "9603088927"));
        contacts.add(new contact("Ms.K.Raju Jayasri", "9492705324"));
        contacts.add(new contact("Mr.V.Sudendra Chary", "9848969492"));
        contacts.add(new contact("Mr.P.Kranthi Kumar", "9949412740"));
        contacts.add(new contact("Ms.P.L.V.R.Surya Meghana", "9493461778"));
        contacts.add(new contact("Mr.S.Venkateshwarlu", "9985549732"));
        contacts.add(new contact("Ms.Y.Renuka", "9912571093"));


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
                                                    ActivityCompat.requestPermissions(BshActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
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
