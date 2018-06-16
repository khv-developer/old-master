package com.example.dedeathshadow.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutdogFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapterCategory adapterCategory;

    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();


    String price[]={"80/- ","1757/-","575/-","7600/-","6,550/-","1125/-","1325/-"," 6800/-","670/-","150/-","190/-","261","190/-"," 213/-"
            ,"50/-","99/-","114/-","625/-","152/-"," 759/-"," 569/-","152/-"," 114/-","50/-","50/-","665/-","120/-","99/-"};

    String desc[]={"Big Boss-3/4 Iinch- Nylon Collars (Double Strong) - RS.80/Pc","My Beau Bone and joint - for dogs 300 ml",
            "Bayer kiltix collar - flea and tick collar for medium size dogs","Arden Grange Adult Premium 15 Kgs",
            "Arden Grange Adult Prestige 12 Kgs","Arden Grange Adult Large Breed 2 Kgs,","Arden Grange Adult Salmon & Rice 2 Kgs ",
            "Arden Grange Adult Salmon & Rice 12 Kgs","Bayer Kiltix collar - flea and tick collar for large size dogs",
            "BIG BOSS - Dog collar choke Belt (small)","BIG BOSS - Dog collar choke Belt -","Big Boss - Dog muzzle (available in all sizes)",
            "BIG BOSS - Dog collar choke Belt - Rs.190","Super Fun Dog & puppy Toy - Squeeze Bone (Orange)",
            "JerHigh chicken grilled in gravy 120 gms - dog wet food","Kennel kitchen chicken and vegetables - dog food for adult" +
            " large breeds ( > 30 kg)","Big Boss - Squeaky Dog Toys – Green","Petsport Giant Tuff ball tug 4 inch ",
            "Pet fun - Dog toys - leg piece yellow colour","Petkin petwipes for Dogs and cats","Petkin Jumbo eye wipes for " +
            "Dogs and cats","Pet fun - Dog toys - leg piece yellow colour","Big Boss - Squeaky Dog Toys – Pink",
            "JerHigh Chicken and vegetable in gravy 120 gms- dog wet food","JerHigh chicken grilled in gravy 120 gms - dog wet food",
            "Petkin plaque spray 120 ml for dogs and cats ","BIG BOSS - 1inch width and 4 ft lenght - Nylon Leashes",
            "Kennel kitchen chicken and vegetables - dog food for adult large breeds ( > 30 kg)99/-"};

    int image[]={R.drawable.dogbigboss,R.drawable.dogbeaubone,R.drawable.dogbayermedium,R.drawable.dogardengrangetwelvekg,
            R.drawable.dogardengrangetwelvekg,R.drawable.dogardensalmon,R.drawable.dogbigbossretractable,
            R.drawable.dogbayer,R.drawable.dogbigbossblack,R.drawable.dogbigbosscollar,R.drawable.dogbigbossmuzzle,R.drawable.dogbogbossq,
            R.drawable.dogtoynine,R.drawable.jerhighchickenn,R.drawable.kennelchickenn,R.drawable.dogtoytwo,R.drawable.dogtoyseven,
            R.drawable.dogtoysix,R.drawable.dogpetkinwipes,R.drawable.dogpetkineyewipe,R.drawable.dogtoyfive,R.drawable.dogtoythree,
            R.drawable.jerhighmg,R.drawable.jerhighchickenn,R.drawable.dogpetkinspray,R.drawable.dogbogbossw,R.drawable.kennelchickenn};

    public AboutdogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_aboutdog, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        for(int i=0;i<image.length;i++){

            HashMap<String,String>hm=new HashMap<>();
            hm.put("price",price[i]);
            hm.put("image",image[i]+"");
            hm.put("desc",desc[i]);
            arrayList.add(hm);
        }

        adapterCategory=new RecyclerAdapterCategory(getActivity(),arrayList);
        recyclerView.setAdapter(adapterCategory);

        return view;
    }

}
