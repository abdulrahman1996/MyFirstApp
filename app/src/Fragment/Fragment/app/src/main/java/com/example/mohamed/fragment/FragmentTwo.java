package com.example.mohamed.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Mohamed on 3/23/2017.
 */

public class FragmentTwo extends Fragment {
    Button b;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(

                R.layout.layout, container, false);
         b=(Button) view.findViewById(R.id.hh);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),Second.class);
                startActivity(i);
            }
        });
return view;
    }
}
