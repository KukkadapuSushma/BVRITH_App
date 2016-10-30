package com.bvrit.bvritcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class specialLabs extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_labs);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Button Button01 = (Button)findViewById(R.id.Button01);
        Button Button02 = (Button)findViewById(R.id.Button02);
        Button Button03 = (Button)findViewById(R.id.Button03);
        Button Button04 = (Button)findViewById(R.id.Button04);

        Button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(specialLabs.this,atl.class);
                startActivity(i);
            }
        });
        Button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(specialLabs.this,incubation.class);
                startActivity(i);
            }
        });
        Button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(specialLabs.this,iot.class);
                startActivity(i);
            }
        });
        Button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(specialLabs.this,eclinic.class);
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

