package com.example.dedeathshadow.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kina on 19-03-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    Context context;
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    MainActivity activity;

    public RecyclerAdapter(Context context, ArrayList<HashMap<String, String>> arrayList) {

        this.context=context;
        this.arrayList=arrayList;
        activity= (MainActivity) context;

    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_items,parent,false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
      AppCompatTextView txtname  , txtprice;
        AppCompatImageView images;
        AppCompatImageButton imagebtn;
        CardView cv;

       public MyViewHolder(View itemView) {
            super(itemView);

           txtname=(AppCompatTextView)itemView.findViewById(R.id.tv_name);
           txtprice=(AppCompatTextView)itemView.findViewById(R.id.tv_mrp);
           images=(AppCompatImageView)itemView.findViewById(R.id.imageview);
           imagebtn=(AppCompatImageButton)itemView.findViewById(R.id.imgbtncart);
           cv=(CardView)itemView.findViewById(R.id.cv_1);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, final int position) {

            holder.txtname.setText(arrayList.get(position).get("name"));
            holder.txtprice.setText("INR : "+arrayList.get(position).get("price"));
            holder.images.setImageResource(Integer.parseInt(arrayList.get(position).get("image")));

            holder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DescriptionFragment descriptionFragment=new DescriptionFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("txtname",arrayList.get(position).get("name"));
                    bundle.putString("image",arrayList.get(position).get("image"));
                    bundle.putString("desc",arrayList.get(position).get("desc"));
                    bundle.putString("price",arrayList.get(position).get("price"));
                    descriptionFragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_main,descriptionFragment).addToBackStack(null).commit();

                }
            });
        holder.imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartFragment fragment=new CartFragment();
                Bundle bundle=new Bundle();
                bundle.putString("txtname",arrayList.get(position).get("name"));
                bundle.putString("image",arrayList.get(position).get("image"));
                bundle.putString("desc",arrayList.get(position).get("desc"));
                bundle.putString("price",arrayList.get(position).get("price"));
                fragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).addToBackStack(null).commit();


            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
