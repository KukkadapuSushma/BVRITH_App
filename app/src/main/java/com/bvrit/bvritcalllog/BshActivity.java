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

import com.bvrit.bvritcalllog.adapter.contactAdapter;
import com.bvrit.bvritcalllog.model.contact;

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
        contacts.add(new contact("DR. P. ANURADHA,HOD", "9989448015"));
        contacts.add(new contact("DR.J.MANOJ KUMAR", "9247164714"));
        contacts.add(new contact("AKULA SAMPATH KUMAR", "9963977802"));
        contacts.add(new contact("ALLURU RAMYA", "9640125266"));
        contacts.add(new contact("B. SREEKALA", "9493019971"));
        contacts.add(new contact("CHAYA KUMARI DIVAKARLA", "9666699505"));
        contacts.add(new contact("DEEPIKA.G", "9177222460"));
        contacts.add(new contact("DR. M. VENKANNA", "9492210041"));
        contacts.add(new contact("DR.K.KAVITHA", "9298801605"));
        contacts.add(new contact("KASTURI SYDAIAH", "9440527274"));
        contacts.add(new contact("M. GANGADHAR TILAK", "9912333223"));
        contacts.add(new contact("M. GOPI KRISHNA", "9542723245"));
        contacts.add(new contact("MR.K.NAGENDRA KUMAR", "9912521818"));
        contacts.add(new contact("MR.THOTAKURA RAMESH", "9160400066"));
        contacts.add(new contact("MRS.B.ANNA TANUJA SAFALA", "9030916646"));
        contacts.add(new contact("MRS.B.RAJITHA", "9642342220"));
        contacts.add(new contact("MRS.FAITH MANJUSHA VIJAYALATHA", "9966462671"));
        contacts.add(new contact("MRS.V.SAILEELA", "8886812956"));
        contacts.add(new contact("MS.V.MALATHI", "9666350035"));
        contacts.add(new contact("NV.SAMBA MURTHY", "9985778854"));
        contacts.add(new contact("PALAKURTHY SHARADHA", "8790252407"));
        contacts.add(new contact("SUNITA RAO BHADURI", "8501825377"));
        contacts.add(new contact("T MOUNIKA", "9494877559"));
        contacts.add(new contact("T. ROJA RANI", "9490969499"));
        contacts.add(new contact("V.MADHAVI", "9494803119"));
        contacts.add(new contact("G KRISHNAVENI", "9948628216"));
        contacts.add(new contact("GANGARAPU SWATHI", "9676630355"));
        contacts.add(new contact("J.R.K.S.M.LAKSHMI", "9848566118"));
        contacts.add(new contact("K VENKATA NAGARAJU", "9705386543"));
        contacts.add(new contact("KODURI GEETHA RANI", "9603088927"));
        contacts.add(new contact("KUNADHA RAJU JAYASRI", "9492705324"));
        contacts.add(new contact("MR.V.SURENDRA CHARY", "9848969492"));
        contacts.add(new contact("P.KRANTHI KUMAR", "9949412740"));
        contacts.add(new contact("PASUPULETI L V R SURYA MEGHANA", "9493461778"));
        contacts.add(new contact("SADHULA VENKATESHWARLU", "9985549732"));
        contacts.add(new contact("Y RENUKA", "9912571093"));


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
