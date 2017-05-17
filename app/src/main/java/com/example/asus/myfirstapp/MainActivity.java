package com.example.asus.myfirstapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import  java.util.ArrayList;

import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import models.Account;

public class MainActivity extends AppCompatActivity {
    EditText username ;
    EditText password ;
    String Username ;
    Button login; 
    int  coubter = 3 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActiveAndroid.initialize(this);


        Account account = new Account();

        final ArrayList<String> users = new ArrayList<String>();

        ArrayList<Account> persons = new ArrayList<>();

        persons = (ArrayList<Account>) account.getAllAccounts();
        for (Account person : persons) {
            users.add(person.username);

        }






        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                    int index = users.indexOf(s.toString());
                    if(index!=-1)
                    {
                        username.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ok,0);

                    }
                    else {
                        username.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }



    public  void action(View view) {
        if (coubter == 0 )
        {
          //System.exit(0);
        }
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

         Username = username.getText().toString();

         String Password = password.getText().toString();
        Account cheker = new Account();
         if(cheker.getAccount(username.getText().toString() ,password.getText().toString()) !=null)
         {
             Account account = cheker.getAccount(username.getText().toString() ,password.getText().toString());
             Toast.makeText(MainActivity.this, "role " +account.roleId , Toast.LENGTH_SHORT).show();
             if(account.roleId == 0)
             {

               Intent intent = new Intent(getApplicationContext() , homeAdmin.class)  ;
                 intent.putExtra("Account" , account);
                 startActivity(intent);
             }
             else if(account.roleId == 1 )
             {
                 Intent intent = new Intent(getApplicationContext() , homeFreelancer.class)  ;
                 intent.putExtra("Account" , account);
                 startActivity(intent);
             }
             else
             {
                 Intent intent = new Intent(getApplicationContext() , homeEmployer.class)  ;
                 intent.putExtra("Account" , account);
                 startActivity(intent);
             }
         }
        else {
             Toast.makeText(MainActivity.this, "wronge pass or user name ", Toast.LENGTH_LONG).show();
         }
    }

    //  when user want to regester he press forget password  and should move to register layout , omer will handele this

    public void  register (View view)
    {
        Toast.makeText(MainActivity.this, "wronge ", Toast.LENGTH_LONG).show();
       Intent intent = new Intent(getApplicationContext() , reg.class);
        startActivity(intent);

    }




}
