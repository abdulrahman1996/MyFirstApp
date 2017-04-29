package com.example.asus.myfirstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText username ;
    EditText password ;
    Button login ;
    DatabaseManger db ;
    ArrayList<Person>  persons;
    ArrayAdapter<String> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final  ArrayList<String> users = new ArrayList<String>();
        db = new DatabaseManger(MainActivity.this);
        Person per = new Person();
        per.username = "abdoo96";
        per.password="12";
        db.insert(per);
        ArrayList<Person> persons = new ArrayList<>();
       persons = db.getPersons();
         for(Person person : persons)
        {
           users.add(person.username);
        }

        users.add("boda");
        users.add("ahmed");

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
        int flag = 0 ;

       String pas  = "" ;
        for(Person person :persons)
        {
            if (person.username.equalsIgnoreCase(Username) ||  person.password.equalsIgnoreCase(Password))
            {
               flag = 1 ;
                pas = person.password;
               break;
            }


        }


        if(flag == 1)
        {
            // omer  ,  the page should move to courses page when this condition applyed

            Toast.makeText(MainActivity.this, "Hello " + Username + " " + pas, Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, " wrong password " + Username + " " + pas, Toast.LENGTH_LONG).show();
        }

    }

    //  when user want to regester he press forget password  and should move to register layout , omer will handele this
    public void  register (View view)
    {
        //omer
    }


}
