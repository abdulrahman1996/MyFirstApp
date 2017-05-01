package com.example.mohamed.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import android.app.Activity;
import android.widget.Button;


public class MainActivity extends Activity {
//    Fragment fr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      fr=new FragmentTwo();
//Button b=(Button)findViewById(R.id.button);
//        Button bb=(Button)findViewById(R.id.button2);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fm = getFragmentManager();
//
//                FragmentTransaction fragmentTransaction = fm.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragment_place, fr);
//
//
//                fragmentTransaction.commit();
//            }
//        });
    }
    public void selectFrag(View view) {

        Fragment fr;

        if(view == findViewById(R.id.button2)) {

            fr = new FragmentOne();

        }else {

            fr = new FragmentTwo();

        }

        FragmentManager fm = getFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_place, fr);


        fragmentTransaction.commit();

    }

}
