package com.example.dedeathshadow.home;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    AppCompatImageView imageView;
    RecyclerView recyclerView;
    ViewPager viewpager ;
    CirclePageIndicator indicator;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    ///////////
    private ViewPager vp_slider;
    private LinearLayout ll_dots;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<String> slider_image_list;
    private TextView[] dots;
    int page_position = 0;

    ///////////

    int[] resourceIDs = new int[]{R.drawable.homescreen,R.drawable.cattoybells,
            R.drawable.catball, R.drawable.cathome,R.drawable.cathat};
    ArrayList<Integer>images=new ArrayList<>();

    String name[]={"Toys","foArdenGrange ","Pet Caps","Drools","Arden Grange","Beaphar Cat Shampoo"};
    int image[]={R.drawable.catfencybelt, R.drawable.catfoodarden, R.drawable.cathat,
            R.drawable.catdrools,R.drawable.catfoodsalmon, R.drawable.catshmpoo};
    String desc[]={"Fancy Cat collars","Adult Chicken 400Gms-cat food","Fancy hat for dogs and cats",
                    "Drools adult mackerel food 3.0 kg for cats","Arden Grange Adult Salmon 2Kgs",
                    "Beaphar Cat Shampoo Macadamia Oil 250 ml"};
    String price[]={"Rs.70/pc", "475/-(FOOD)ods" ,"400/-" , "665/-" ,"1999/-(FOOD)","290/-" };

    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

    RecyclerAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        init();
        addBottomDots(0);

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                vp_slider.setCurrentItem(page_position, true);
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 3000);


        recyclerView=(RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        for(int i=0;i<name.length;i++){

            HashMap<String,String>hm=new HashMap<>();
            hm.put("name",name[i]);
            hm.put("image",image[i]+"");
            hm.put("price",price[i]);
            hm.put("desc",desc[i]);

            arrayList.add(hm);
        }

        adapter=new RecyclerAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void addBottomDots(int currentpage) {
        dots = new TextView[slider_image_list.size()];

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(25);
            dots[i].setTextColor(Color.parseColor("#000000"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentpage].setTextColor(Color.parseColor("#FFFFFF"));

    }

    private void init() {
        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        //getSupportActionBar().hide();
        vp_slider = (ViewPager) findViewById(R.id.vp_slider);
        ll_dots = (LinearLayout) findViewById(R.id.ll_dots);

        slider_image_list = new ArrayList<>();

//Add few items to slider_image_list ,this should contain url of images which should be displayed in slider
// here i am adding few sample image links, you can add your own

        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/mountain_bongo_animal_mammal_220289.jpg");
        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/bird_mountain_bird_animal_226401.jpg");
        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/mountain_bongo_animal_mammal_220289.jpg");
        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/bird_mountain_bird_animal_226401.jpg");


        sliderPagerAdapter = new SliderPagerAdapter(MainActivity.this, slider_image_list);
        vp_slider.setAdapter(sliderPagerAdapter);

        vp_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
