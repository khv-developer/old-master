package com.example.dedeathshadow.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class DogFragment extends Fragment {



    public DogFragment() {
        // Required empty public constructor
    }

    LinearLayout ll_food,ll_access,ll_supp,ll_toys,ll_health,ll_fashion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_dog, container, false);
        ll_access=(LinearLayout)view.findViewById(R.id.ll_acces);
        ll_fashion=(LinearLayout)view.findViewById(R.id.ll_fashion);
        ll_food=(LinearLayout)view.findViewById(R.id.ll_food);
        ll_toys=(LinearLayout)view.findViewById(R.id.ll_toys);
        ll_health=(LinearLayout)view.findViewById(R.id.ll_health);
        ll_supp=(LinearLayout)view.findViewById(R.id.ll_suppl);

        ll_supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutdogFragment fragment=new AboutdogFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();

            }
        });

        ll_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutdogFragment fragment=new AboutdogFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();
            }
        });
        ll_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AboutdogFragment fragment=new AboutdogFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();
            }
        });

        ll_toys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AboutdogFragment fragment=new AboutdogFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();
            }
        });

        ll_access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AboutdogFragment fragment=new AboutdogFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();
            }
        });

        ll_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AboutdogFragment fragment=new AboutdogFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();
            }
        });


        return view;
    }

}
