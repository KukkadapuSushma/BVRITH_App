package com.bvrit.bvritcall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.net.Uri;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_contact_us) {
            Intent i = new Intent(this, ContactUsActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.c) {
            Intent i = new Intent(this, aboutBVRITH.class);
            startActivity(i);
        } else if (id == R.id.action_dept) {
            Intent i = new Intent(this, DepartmentActivity.class);
            startActivity(i);
        } else if (id == R.id.custom) {
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);
          //  Uri uri = Uri.parse("https://www.google.co.in/maps/place/BVRIT+Hyderabad+College+of+Engineering+for+Women/@17.52596,78.3678963,17z/data=!3m1!4b1!4m5!3m4!1s0x3bcb8defd4fe2b81:0x64cfbb18950c8603!8m2!3d17.52596!4d78.370085");
         //   Intent intent = new Intent(Intent.ACTION_VIEW, uri);
         //   startActivity(intent);
        } else if (id == R.id.contentPanel) {
            Intent i = new Intent(this, aboutfacilities.class);
            startActivity(i);


        }
         else if (id == R.id.content_main) {
            Uri uri = Uri.parse("http://www.bvrithyderabad.edu.in");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else if (id == R.id.customPanel) {
            Uri uri = Uri.parse("http://www.bvritnext.com/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }




}

