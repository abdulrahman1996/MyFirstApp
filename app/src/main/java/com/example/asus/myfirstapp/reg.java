// package com.example.asus.myfirstapp;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class reg extends AppCompatActivity {
//
//    //create ui variables that control ui component
//    EditText password_et,f_name_et,l_name_et,username_et;
//    Button saveBtn;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.register);
//
//        saveBtn = (Button)findViewById(R.id.save_btn);
//        //initialize edit text elements using it's id from ui
//        password_et = (EditText)findViewById(R.id.passwordET);
//        f_name_et = (EditText)findViewById(R.id.f_name_ET);
//        l_name_et = (EditText)findViewById(R.id.l_name_ET);
//        username_et = (EditText)findViewById(R.id.usernameET);
//
//       String user =(String) getIntent().getSerializableExtra("String").toString();
//        username_et .setText(user);
//        Toast.makeText(reg.this , "useername :"  + user , Toast.LENGTH_SHORT ).show();
//        username_et.setEnabled(false) ;
//        saveBtn.setEnabled(false);
//        password_et.setEnabled(false);
//
//        f_name_et.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(s!= null)
//                {
//                    f_name_et.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ok,0);
//                    l_name_et.addTextChangedListener(new TextWatcher() {
//                        @Override
//                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                        }
//
//                        @Override
//                        public void onTextChanged(CharSequence s, int start, int before, int count) {
//                            if(s!= null) {
//                                l_name_et.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ok,0);
//
//                                password_et.setEnabled(true);
//                                saveBtn.setEnabled(true);
//                            }
//                                else
//                                {
//                                    l_name_et.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
//                                    password_et.setEnabled(false);
//                                    saveBtn.setEnabled(false);
//                                }
//
//
//                        }
//
//                        @Override
//                        public void afterTextChanged(Editable s) {
//
//                        }
//                    });
//
//
//                }
//                else
//                {
//                    f_name_et.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ok,0);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//
//        //initialize button using it's id from ui
//
//
//        //set a listener to save button to get all inserted data and make an insert operation "database operation"
//        saveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = username_et.getText().toString(),password = password_et.getText().toString(),
//                        f_name = f_name_et.getText().toString(),l_name = l_name_et.getText().toString();
//                Person person = new Person();
//                person.username = username;
//                person.password = password;
//                person.firstname = f_name;
//                person.lastname = l_name;
//                DatabaseManger db = new DatabaseManger(reg.this);
//
//                //here you must check if data inserted successfully or not if true clear all fields or perform some action
//                db.insert(person);
//                Toast.makeText(reg.this,"Your Data Had Been Inserted",Toast.LENGTH_LONG).show();
//                username_et.setText("");
//                password_et.setText("");
//                l_name_et.setText("");
//                f_name_et.setText("");
//            }
//        });
//    }
//}
