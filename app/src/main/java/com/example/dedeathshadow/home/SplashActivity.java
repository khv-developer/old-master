package com.example.dedeathshadow.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        preferences=getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        final boolean islogin = preferences.getBoolean("islogin",false);
        final boolean isregis =preferences.getBoolean("isregis",false);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(isregis){

                    if(islogin)
                    {

                        Intent i=new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(i);
                    }
                    else {

                        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(i);
                    }
                }
                else {
                    Intent i=new Intent(SplashActivity.this,RegistrationActivity.class);
                    startActivity(i);
                }

            }
        },3000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SplashActivity.this.finish();
    }
}
