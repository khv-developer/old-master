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
public class BirdFragment extends Fragment {


    int image[]={R.drawable.birdeconomicfoodforbudgie,R.drawable.birdeconomicsmakersforbudgie,R.drawable.birdexoticfruit,
            R.drawable.birdparrots_prestige,
            R.drawable.birdexoticnuts,R.drawable.birdparrotsprestige,
            R.drawable.birdsmartheartbirdfoodcockatiellovebird,
            R.drawable.birdsmybeauavianforbirds,
            R.drawable.birdtropicalversel,
            R.drawable.birdverselelagawhitesunflowerseeds,
            R.drawable.birdvitapoleconomicfoodforcanary,
            R.drawable.birdvitapoleconomicfoodforcanaryyy,
            R.drawable.birdvitapoleconomicfoodforcockatiel,
            R.drawable.birdvitapolfoodforbudgie,R.drawable.birdvitapollargeparrorfood};

    String price[]={"350/-","159/-","631/-","498/-","641/-","1377/-","329/-","1399/-","346/-","370","427/-","450/-","403/-","175/-","660/-","875/-","795/-"};

    String desc[]={"Bird food - economic food for budgie","food for bird economic smakers for budgie","bird exotic fruit","bird parrots_prestige",
                    "bird exotic nuts","bird parrots prestige 3 Kg","bird smart heart bird food cockatiel lovebird","Birds my beauvian for birds",
                    "bird tropical versel","bird verselelaga white sun flowerseeds","bird vitapol economic food for canary",
            "bird vitapol economic food for canaryyy","bird vitapol economic food for cockatiel","bird vitapol food for budgie",
            "bird vitapol large parrot food"};


    String name[]={"Bird economic food for budgie","bird economicsmakers","bird exotic fruit","Bird parrots_prestige",
            "Bird exotic nuts","bird parrots prestige",
            "bird smart","Love Birds","bird tropical","bird verselelaga white","bird vitapol","bird vitapol","bird vitapol",
           "bird vitapol food for budgie" ,"bird vitapol large parrot food"};
    public BirdFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    RecyclerAdapterCategory adapterCategory;
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bird, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        for(int i=0;i<image.length;i++){

            HashMap<String,String>hm=new HashMap<>();
            hm.put("price",price[i]);
            hm.put("image",image[i]+"");
            hm.put("desc",desc[i]);
            hm.put("name",name[i]);
            arrayList.add(hm);
        }

        adapterCategory=new RecyclerAdapterCategory(getActivity(),arrayList);
        recyclerView.setAdapter(adapterCategory);

        return view;
    }

}
