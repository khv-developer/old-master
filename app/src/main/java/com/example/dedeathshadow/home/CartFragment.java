package com.example.dedeathshadow.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    ImageView imgview;
    TextView txtname,txtprice,txtprc;
    Button btnchck,btnconti;

    public CartFragment() {
        // Required empty public constructor
    }

    String name,desc,image,price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);
        imgview=(ImageView)view.findViewById(R.id.img);
        txtname=(TextView)view.findViewById(R.id.txtname);
        txtprc=(TextView)view.findViewById(R.id.price2);
        txtprice=(TextView)view.findViewById(R.id.txtprice);
        btnchck=(Button)view.findViewById(R.id.btnchck);
        btnconti=(Button)view.findViewById(R.id.conti);

        Bundle b=getArguments();
        name=b.getString("txtname");
        image=b.getString("image");
        price=b.getString("price");

        txtprice.setText(price);
        txtprc.setText(price);
        txtname.setText(name);
        //Picasso.with(getActivity()).load(image).into(imgview);
        imgview.setImageResource(Integer.parseInt(image));

        btnchck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Your Order Will reach soon", Toast.LENGTH_SHORT).show();

            }
        });

        btnconti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeFragment fragment=new HomeFragment();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
