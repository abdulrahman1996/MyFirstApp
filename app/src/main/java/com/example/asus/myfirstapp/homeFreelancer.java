package com.example.asus.myfirstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Asus on 17/05/2017.
 */

public class homeFreelancer extends AppCompatActivity {


    private DrawerLayout dreDrawerLayout ;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_admin);


        dreDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, dreDrawerLayout, R.string.open, R.string.close);

        dreDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(homeFreelancer.this, " " + item.toString(), Toast.LENGTH_LONG).show();

                // from here you will do  to fregment
                return false;

            }
        });
    }
}


