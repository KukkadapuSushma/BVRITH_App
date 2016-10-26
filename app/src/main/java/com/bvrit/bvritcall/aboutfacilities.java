package com.bvrit.bvritcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class aboutfacilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutfacilities);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Button Button07 = (Button)findViewById(R.id.Button07);
        Button Button09 = (Button)findViewById(R.id.Button09);
        Button Button011 = (Button)findViewById(R.id.Button11);
        Button Button010 = (Button)findViewById(R.id.Button10);
        Button Button012 = (Button)findViewById(R.id.Button12);
        Button Button08 = (Button)findViewById(R.id.Button08);
        Button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutfacilities.this,transport.class);
                startActivity(i);
            }
        });
        Button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutfacilities.this,library.class);
                startActivity(i);
            }
        });
        Button011.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutfacilities.this,hostels.class);
                startActivity(i);
            }
        });
        Button010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutfacilities.this,wise.class);
                startActivity(i);
            }
        });
        Button012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutfacilities.this,atl.class);
                startActivity(i);
            }
        });
        Button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutfacilities.this,canteen.class);
                startActivity(i);
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