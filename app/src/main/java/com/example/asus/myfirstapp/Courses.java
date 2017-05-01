package com.example.asus.myfirstapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Courses extends AppCompatActivity {
    Person per ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      per  = (Person)getIntent().getSerializableExtra("Person");

        setContentView(R.layout.fragment_two);

    }


}
