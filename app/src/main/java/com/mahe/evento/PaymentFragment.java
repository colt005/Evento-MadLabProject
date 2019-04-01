package com.mahe.evento;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PaymentFragment extends Fragment {
    private EditText card;
    private EditText cvv;
    private EditText name;
    private EditText expiry;
    private Button p;
    Fragment invoiceFragment = new InvoiceFragment();



    public PaymentFragment() {
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
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        card=(EditText)view.findViewById(R.id.editText);
        cvv=(EditText)view.findViewById(R.id.editText2);
        name=(EditText)view.findViewById(R.id.editText3);
        expiry=(EditText)view.findViewById(R.id.editText4);
        p=(Button) view.findViewById(R.id.pay);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(card.getText().toString().isEmpty() ||cvv.getText().toString().isEmpty()||name.getText().toString().isEmpty() ||expiry.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Fill all details!!!",Toast.LENGTH_LONG).show();
                }
                else{

                           //open Invoice
                    loadfragment(invoiceFragment);


                }
            }
        });


        return inflater.inflate(R.layout.fragment_payment, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
    private void loadfragment(Fragment frag) {
        FragmentTransaction trans = getFragmentManager().beginTransaction();

        trans.replace(R.id.main_fragment, frag);
        trans.addToBackStack(null);
        trans.commit();

    }


}
