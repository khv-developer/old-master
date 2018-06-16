package com.example.dedeathshadow.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etemail, etpassword;
    Button btnlogin;
    String semail, spassword,email,password;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail=(EditText)findViewById(R.id.ema);
        etpassword=(EditText)findViewById(R.id.password);
        btnlogin=(Button)findViewById(R.id.btnlogin);
      //  txtsign=(TextView)findViewById(R.id.txtsign);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email=etemail.getText().toString();
                password=etpassword.getText().toString();

                pref=getSharedPreferences("MyApp", Context.MODE_PRIVATE);
                semail=pref.getString("Email",null);
                spassword=pref.getString("Password",null);

                Log.e("Email & Pass==",semail+""+spassword);



                if(email.matches(semail) && email.equals(semail))
                {
                    if (password.matches(spassword) && password.equals(spassword))
                    {
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                        SharedPreferences preferences=getSharedPreferences("MyApp", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed=preferences.edit();
                        ed.putBoolean("islogin",true);
                        ed.commit();
                        Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    else {

                        Toast.makeText(LoginActivity.this, "Email Or Password are not match to registration detail", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
