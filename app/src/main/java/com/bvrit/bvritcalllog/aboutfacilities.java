package com.bvrit.bvritcalllog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class aboutfacilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutfacilities);
        Button Button07 = (Button)findViewById(R.id.Button07);
        Button Button09 = (Button)findViewById(R.id.Button09);
        Button Button011 = (Button)findViewById(R.id.Button011);
        Button Button010 = (Button)findViewById(R.id.Button010);
        Button Button012 = (Button)findViewById(R.id.Button012);
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
                Intent i = new Intent(aboutfacilities.this,canteen.class);
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
                Intent i = new Intent(aboutfacilities.this,incubationcenter.class);
                startActivity(i);
            }
        });
    }

}