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
public class AboutcategoryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapterCategory adapterCategory;

       int image[]={R.drawable.catbelt, R.drawable.catfoodarden, R.drawable.cathat,R.drawable.catoilsoap,R.drawable.catpetbrand,
                R.drawable.catdrools,R.drawable.catfoodsalmon, R.drawable.catshmpoo,R.drawable.catacces,R.drawable.catbeltxss,
                R.drawable.catball,R.drawable.catcaps,R.drawable.catbetuna,R.drawable.catfoodjelly,R.drawable.catcarrybag,
                R.drawable.catdelitekitkat,R.drawable.catemily,R.drawable.catfood,R.drawable.catvirbac,R.drawable.catfurglow,
               R.drawable.catpetwips};

    String name[]={"Cat belt","Cat Foodarden","Cat Hat","Cat Oil Soap","Cat Pet Brand","Cat Drools","Cat food salmon","Cat Shampoo",
                    "Cat Ball", "Cat Caps","Cat Betuna","Cat Food Jelly","Cat CarryBag","Cat Delite Kitkat,","Cat emilty","Cat Food",
                        "Cat Virbac","Cat Furglow","CatPetWipes"};
      String price[]={"Rs.70/pc", "475/-(FOOD)ods" ,"400/-","76/-","240/-" , "665/-" ,"1999/-(FOOD)","290/-","295/-",
                    "80/-","330/-","285/-","90/-","90/-","1425/-","225/-","335/-","275/-","389/-","430/-","342/-"};

    String desc[]={"Fancy Cat collars","Adult Chicken 400Gms-cat food","Fancy hat for dogs and cats","BI Tea Oil Soap",
            "Pet Brand Cat toys Three big mice",
            "Drools adult mackerel food 3.0 kg for cats","Arden Grange Adult Salmon 2Kgs",
            "Beaphar Cat Shampoo Macadamia Oil 250 ml","accessories","cat belts xss size","snack Ball for cat","caps for dog and cats"
            ,"Chicken Jelly 185 gms-cat wet food","Chicken Jelly 185 gms-cat wet food","Cat carry bag","Delite kit cat litter 5 kg",
            "Emily pets premium cat liter Strawberry","PetBrands Refill Pack","Virbac Sebolytic shampoo",
            "Himalaya Furglow-oral glow conditionor",
                "Petkin value-pek petwipes"};

     ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

    public AboutcategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_aboutcategory, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        for(int i=0;i<name.length;i++){

            HashMap<String,String>hm=new HashMap<>();
            hm.put("price",price[i]);
            hm.put("image",image[i]+"");
            hm.put("name",name[i]);
            hm.put("desc",desc[i]);
            arrayList.add(hm);
        }

        adapterCategory=new RecyclerAdapterCategory(getActivity(),arrayList);
        recyclerView.setAdapter(adapterCategory);

        return view;
    }

}
