package com.mahe.evento;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BookEvent extends Fragment implements AdapterView.OnItemSelectedListener{
    private Button c;
    private Button cost;
    private TextView t;
    private TextView p;
    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    private TextView t1;
    private CheckBox ce1;
    private CheckBox ce2;
    private CheckBox ce3;
    private TextView t2;
    private CheckBox cet1;
    private CheckBox cet2;
    Fragment payment = new PaymentFragment();

    public BookEvent() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_book_event, container, false);
        c=(Button)view.findViewById(R.id.check);
        cost=(Button)view.findViewById(R.id.cost);
        t=(TextView)view.findViewById(R.id.foodtxt);
        p=(TextView)view.findViewById(R.id.pay);
        c1=(CheckBox)view.findViewById(R.id.br);
        c2=(CheckBox)view.findViewById(R.id.lu);
        c3=(CheckBox)view.findViewById(R.id.sn);
        c4=(CheckBox)view.findViewById(R.id.di);
        t1=(TextView)view.findViewById(R.id.eq);
        ce1=(CheckBox)view.findViewById(R.id.mi);
        ce2=(CheckBox)view.findViewById(R.id.sp);
        ce3=(CheckBox)view.findViewById(R.id.dj);
        t2=(TextView)view.findViewById(R.id.dec);
        cet1=(CheckBox)view.findViewById(R.id.fl);
        cet2=(CheckBox)view.findViewById(R.id.li);
        t.setVisibility(View.INVISIBLE);
        c1.setVisibility(View.INVISIBLE);
        c2.setVisibility(View.INVISIBLE);
        c3.setVisibility(View.INVISIBLE);
        c4.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);
        ce1.setVisibility(View.INVISIBLE);
        ce2.setVisibility(View.INVISIBLE);
        ce3.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        cet1.setVisibility(View.INVISIBLE);
        cet2.setVisibility(View.INVISIBLE);
        cost.setVisibility(View.INVISIBLE);
        p.setVisibility(View.INVISIBLE);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setVisibility(View.VISIBLE);
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);
                c4.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                ce1.setVisibility(View.VISIBLE);
                ce2.setVisibility(View.VISIBLE);
                ce3.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                cet1.setVisibility(View.VISIBLE);
                cet2.setVisibility(View.VISIBLE);
                cost.setVisibility(View.VISIBLE);
            }
        });
        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Total cost is: Rs 0",Toast.LENGTH_LONG).show();
                p.setVisibility(View.VISIBLE);
            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfragment(payment);
            }
        });
        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        Spinner spinner2=(Spinner)view.findViewById(R.id.spinner2);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Reception");
        categories.add("Wedding");
        categories.add("Seminar");
        categories.add("Family Function");
        categories.add("College Event");
        categories.add("Others");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        Spinner spinner3=(Spinner)view.findViewById(R.id.spinner3);

        // Spinner click listener
        spinner3.setOnItemSelectedListener(this);
        List<String> categories1 = new ArrayList<String>();
        categories1.add("10:00-12:00 am");
        categories1.add("12:00-3:00 pm");
        categories1.add("3:00-6:00 pm");
        categories1.add("8:00-12:00 pm");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter1);


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        List<String> categories = new ArrayList<String>();
        if(adapterView.getItemAtPosition(i).toString().equals("Wedding")){

            categories.add("Wedding Bells");
            categories.add("IMSC Gardens");
            categories.add("US Club");}
        else {
            categories.add("Samudrika Hall");
            categories.add("US Club");
            categories.add("TX Convention Centre");
            categories.add("Mulla Auditorium");
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner2=(Spinner)getView().findViewById(R.id.spinner2);
        spinner2.setAdapter(dataAdapter);



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void loadfragment(Fragment frag) {
        FragmentTransaction trans = getFragmentManager().beginTransaction();

        trans.replace(R.id.main_fragment, frag);
        trans.addToBackStack(null);
        trans.commit();

    }
}
