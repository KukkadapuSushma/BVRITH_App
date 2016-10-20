package com.bvrit.bvritcalllog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void cseList(View view) {
        Intent i = new Intent(this, CseActivity.class);
        startActivity(i);
    }
    public void eceList(View view) {
        Intent i = new Intent(this, EceActivity.class);
        startActivity(i);
    }
    public void eeeList(View view) {
        Intent i = new Intent(this, EeeActivity.class);
        startActivity(i);
    }
    public void itList(View view) {
        Intent i = new Intent(this, ItActivity.class);
        startActivity(i);
    }
    public void basic1List(View view) {
        Intent i = new Intent(this, BshActivity.class);
        startActivity(i);
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
