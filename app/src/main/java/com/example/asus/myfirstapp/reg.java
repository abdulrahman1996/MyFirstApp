 package com.example.asus.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import models.Account;

 public class reg extends AppCompatActivity {
     Account acc = new Account();
    //create ui variables that control ui component
    EditText password_et,f_name_et,l_name_et,username_et ;
     RadioButton role ;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        saveBtn = (Button) findViewById(R.id.save_btn);
        //initialize edit text elements using it's id from ui
        password_et = (EditText) findViewById(R.id.passwordET);
        f_name_et = (EditText) findViewById(R.id.f_name_ET);
        l_name_et = (EditText) findViewById(R.id.l_name_ET);
        username_et = (EditText) findViewById(R.id.usernameET);


        username_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (acc.isUsernamefound(s.toString())) {
                    username_et.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ok, 0);
                }
                    else
                    username_et.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


        //initialize button using it's id from ui


        //set a listener to save button to get all inserted data and make an insert operation "database operation"
        public void onRadioButtonClicked(View vi) {
            // Is the button now checked?
            boolean checked = ((RadioButton) vi).isChecked();

            // Check which radio button was clicked
            switch(vi.getId()) {
                case R.id.employer:
                    if (checked)
                    {
                        acc.roleId = 1;
                    }
                        break;
                case R.id.freelancer :
                    if (checked)
                        acc.roleId = 2 ;
                        break;
            }
        }




     public void registerB(View view)
     {
         Account account = new Account();
         acc.username = username_et.getText().toString();
         acc.fnmae = f_name_et.getText().toString();
         acc.lname = l_name_et.getText().toString();
         acc.password = password_et.getText().toString();
         account.save(acc);
     }



    }

