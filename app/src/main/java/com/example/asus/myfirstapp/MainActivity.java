package com.example.asus.myfirstapp;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText username ;
    EditText password ;
    DatabaseManger db ;
    ArrayList<Person>  persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final  ArrayList<String> users = new ArrayList<String>();
        db = new DatabaseManger(MainActivity.this);

        ArrayList<Person> persons = new ArrayList<>();
        persons = db.getPersons();
         for(Person person : persons)
        {
           users.add(person.username);
        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            }
        );
    }



    public  void action(View view) {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        String Username = username.getText().toString();
        String Password = password.getText().toString();

        db = new DatabaseManger(MainActivity.this);
        persons = db.getPersons();
        int flag = 0;
         Person per= new Person();
        String pas = "";
        for (Person person : persons) {
            if (person.username.equalsIgnoreCase(Username) || person.password.equalsIgnoreCase(Password)) {
                flag = 1;
                pas = person.password;
                per = person ;
                break;
            }


        }


        if (flag == 1) {
            Intent intent = new Intent(getApplicationContext() ,Courses.class) ;
            intent.putExtra("Person" , per );
            startActivity(intent);

            Toast.makeText(MainActivity.this, "Hello " + Username + " " + pas, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, " wrong password " + Username + " " + pas, Toast.LENGTH_LONG).show();

        }
    }

    //  when user want to regester he press forget password  and should move to register layout , omer will handele this
    public void  register (View view)
    {
       Intent intent = new Intent(getApplicationContext() , reg.class);
        startActivity(intent);
    }



}
