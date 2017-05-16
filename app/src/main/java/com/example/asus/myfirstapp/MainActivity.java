package com.example.asus.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import  java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import  java.util.List;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import models.Account;
import models.Task;

public class MainActivity extends AppCompatActivity {
    EditText username ;
    EditText password ;
    String Username ;
    int  coubter = 3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       ActiveAndroid.initialize(this);




   Account account = new Account();

      final  ArrayList<String> users = new ArrayList<String>();

        ArrayList<Account> persons = new ArrayList<>();

       persons = (ArrayList<Account>) account.getAllAccounts();
         for(Account person : persons)
        {
           users.add(person.username);

        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);




        username.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s , int start, int count, int after) {

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
            }
        );
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

//        db = new DatabaseManger(MainActivity.this);
//        persons = db.getPersons();
//        int flag = 0;
//         Person per= new Person();
//        String pas = new String() ;
//        for (Person person : persons) {
//            if (person.username.equalsIgnoreCase(Username) ) {
//                flag = 1;
//                if(person.password.equalsIgnoreCase(Password))
//                {
//                    pas = person.password;
//                    flag = 2 ;
//                    per = person ;
//                    break;
//                }
//                per = person ;
//                break;
//            }
//
//
//        }
//         if(flag ==2)
//         {
//         Intent intent = new Intent(getApplicationContext() ,Courses.class) ;
//         intent.putExtra("Person" , per );
//         startActivity(intent);
//
//         Toast.makeText(MainActivity.this, "Hello " + Username , Toast.LENGTH_LONG).show();
//         }
//        else
//        if (flag == 1) {
//            coubter -- ;
//            //Toast.makeText(MainActivity.this, "wronge " + Username + " |" + per.password +"|"+Password, Toast.LENGTH_LONG).show();
//        } else {
//            coubter --;
//        //    Toast.makeText(MainActivity.this, " wrong password " + Username + " " + pas, Toast.LENGTH_LONG).show();
//
//        }
    }

    //  when user want to regester he press forget password  and should move to register layout , omer will handele this
//    public void  register (View view)
//    {
//       Intent intent = new Intent(getApplicationContext() , reg.class);
//        Username = username.getText().toString();
//        intent.putExtra("String" ,Username);
//        startActivity(intent);
//    }



}
