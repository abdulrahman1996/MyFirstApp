package com.example.asus.myfirstapp;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by Mohamed on 3/23/2017.
 */

public class ToolbarFragment extends ListFragment  {

    Courses courses ;
    Person per ;
    String[] AndroidOS ;


    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        // Person per  = courses.getPerson();
        //AndroidOS =new String[]{per.corse1 , per.corse2 , per.corse3 , per.corse4};
       per = (Person) getActivity().getIntent().getSerializableExtra("Person");
        AndroidOS=new String[]{per.corse1 ,per.corse4 ,per.corse2 ,per.corse3};
        View view =inflater.inflate(R.layout.toolbar_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, AndroidOS);
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(AndroidOS[position] ,per ,position );
        getListView().setSelector(android.R.color.darker_gray);
    }
}
