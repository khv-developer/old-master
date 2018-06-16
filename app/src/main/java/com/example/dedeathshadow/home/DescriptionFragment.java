package com.example.dedeathshadow.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {

     TextView txtname,txtprice,txtdesc;
    ImageView imageView;
    Button btncart;
    public DescriptionFragment() {
        // Required empty public constructor
    }
    String name,image,price,desc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_description, container, false);

        txtname=(TextView)view.findViewById(R.id.txtName);
        txtdesc=(TextView)view.findViewById(R.id.txtdesc);
        txtprice=(TextView)view.findViewById(R.id.txtPrice);
        imageView= (ImageView) view.findViewById(R.id.image_description);
        btncart=(Button)view.findViewById(R.id.btnaddcart);

        Bundle bundle=getArguments();
         name=bundle.getString("txtname");
        image=bundle.getString("image");
        price=bundle.getString("price");
         desc=bundle.getString("desc");


        imageView.setImageResource(Integer.parseInt(image));
        txtname.setText(name);
        txtprice.setText(price);
        txtdesc.setText(desc);

        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartFragment fragment=new CartFragment();
                Bundle b=new Bundle();
                b.putString("txtname",name);
                b.putString("image",image);
                b.putString("price",price);
                fragment.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();

            }
        });
        return view;
    }

}
