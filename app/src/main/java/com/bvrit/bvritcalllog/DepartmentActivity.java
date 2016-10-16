package com.bvrit.bvritcalllog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
    }
    public void cseList(View view) {
        Intent i = new Intent(this, CseActivity.class);
        startActivity(i);
    }
}
