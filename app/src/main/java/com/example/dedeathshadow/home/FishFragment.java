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
public class FishFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapterCategory adapterCategory;


    int image[]={R.drawable.fishalcoalamp,R.drawable.fishaquadene,R.drawable.fishaquafinmicro,R.drawable.fishgeneeleven,
            R.drawable.fishhikaricichlid,R.drawable.fishhikaritropical,R.drawable.fishhikarimarine,R.drawable.fishgenericaquarium,
            R.drawable.fishjainsonsaquarium,R.drawable.fishpearlshellaquarium,R.drawable.fishplasticplantgreen,
            R.drawable.fishsridecorative,R.drawable.fishtetrabitscomplete,R.drawable.fishtropicakoi,R.drawable.fishtropicalcichlid,
            R.drawable.fishtropicalflower, R.drawable.fishvasuworldaquarium};

    String price[]={"2320/-","976/-","220/-","268/-","565/-","240/-","329/-","1295/-","250/-","375","350/-","450/-","800/-","870/-","878/-","875/-","795/-"};

    String desc[]={"48cm length fishAlcoalamp","Acqadene ruby Red 2000ml","AcquafinMicro pellet 250 ml",
                    "Fish Gene Eleven Micro pellete 100 gms"
                    ,"Fish Hikari Chichild Excel Floating Pellets 250 gms","Hikari Tropical micro Pellets Tetra 22gm",
                        "Hikari Marine Aquairium fish food 50 gms","fish Generic Aquarium",
                        "JainSons Aquairium Decorative Ornaments 22x20x10",
                "Pearl and Shell Aquarium Ornaments 3-3.5 inch","Artificial Plastic Plant heigth 9 inches",
            "Fish Sri Aquraium Decorative Cave Ornaments -3 x 7.5 inch","Tetra bits complete fishfood 300 gms",
            "Tropical koi Growth and Color small pellete 1000 ml","Tropical Cichlid Omnivore 1000ml",
            "Tropical Flower Horn Young Pellete 380gms",
            "VasuWorld Aquairium Accessories Pipe joint Connector"};


   String name[]={"Fish Alcoalamp","Acquadene Ruby","AcquaFin Micro","Fish Gene","Fish Hikari Chichild","Hikari Tropical","Hikari Marine",
                    "Fish Generic","Jain Sons Aquarium","Pearl and Shell","Artificial Plastic","Fish Sri Aquarium","Tetra Bits",
                        "Tropical Koi Growth"," Tropical CiChlid","Tropical Flower","Vasu World"};

    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

    public FishFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fish, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        for(int i=0;i<price.length;i++){

            HashMap<String,String>hm=new HashMap<>();
            hm.put("price",price[i]);
            hm.put("image",image
                    [i]+"");
            hm.put("desc",desc[i]);
            hm.put("name",name[i]);
            arrayList.add(hm);
        }

        adapterCategory=new RecyclerAdapterCategory(getActivity(),arrayList);
        recyclerView.setAdapter(adapterCategory);

        return view;
    }

}
