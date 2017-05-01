package com.example.asus.myfirstapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TextFragment extends Fragment {
    EditText text;
    Button button ;
    int position ;
    Person person;

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text = (EditText) view.findViewById(R.id.course);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ua = text.getText().toString();
                switch (position) {
                    case 0:
                        person.corse1 = ua;
                        break;
                    case 1:
                        person.corse2 = ua;
                        break;
                    case 2:
                        person.corse3 = ua;
                        break;
                    case 3:
                        person.corse4 = ua;
                        break;


                }
                Toast.makeText(getActivity(), "update course" + position + "  " + person.id.toString(), Toast.LENGTH_SHORT).show();
                DatabaseManger db = new DatabaseManger(getActivity());
                db.update(person);


            }

        });



        return view;
    }

    public void courseUpdate(View v){

                /*  make update here   */
        String ua = text.getText().toString();
        switch (position) {
            case 0:
                person.corse1 = ua;
                break;
            case 1:
                person.corse2 = ua;
                break;
            case 2:
                person.corse3 = ua;
                break;
            case 3:
                person.corse4 = ua;
                break;


        }
        Toast.makeText(getActivity(), "update course" + position + "  " + person.corse1.toString(), Toast.LENGTH_SHORT).show();
        DatabaseManger db = new DatabaseManger(getActivity());
        db.update(person);

    }



    public void change(String txt ,Person person , int position ){
        text.setText(txt);
        this.position = position;
        this.person = person;


    }
    /*make update in database*/
}
