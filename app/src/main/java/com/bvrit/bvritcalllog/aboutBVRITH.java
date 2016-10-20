package com.bvrit.bvritcalllog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class aboutBVRITH extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_bvrith);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Button Button01 = (Button)findViewById(R.id.Button01);
        Button Button03 = (Button)findViewById(R.id.Button03);
        Button Button05 = (Button)findViewById(R.id.Button05);
        Button Button04 = (Button)findViewById(R.id.Button04);
        Button Button06 = (Button)findViewById(R.id.Button06);
        Button Button02 = (Button)findViewById(R.id.Button02);
        Button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutBVRITH.this,mission.class);
                startActivity(i);
            }
        });
        Button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutBVRITH.this,vision.class);
                startActivity(i);
            }
        });
        Button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutBVRITH.this,founder.class);
                startActivity(i);
            }
        });
        Button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutBVRITH.this,chairman.class);
                startActivity(i);
            }
        });
        Button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutBVRITH.this,principal.class);
                startActivity(i);
            }
        });
        Button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(aboutBVRITH.this,sves.class);
                startActivity(i);
            }
        });
    }

    @Override
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
