package com.example.dedeathshadow.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText ef, el, e3, e4, e5, e6;
    Button b2;
    SharedPreferences pref;
    String fname, lname, email, password, mobile;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ef = (EditText) findViewById(R.id.fname);
        el = (EditText) findViewById(R.id.lname);
        e3 = (EditText) findViewById(R.id.email);
        e4 = (EditText) findViewById(R.id.password);
        e6 = (EditText) findViewById(R.id.mobile);
        b2 = (Button) findViewById(R.id.signup);

        final String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String MobilePattern = "[0-9]{10}";

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname = ef.getText().toString();
                lname = el.getText().toString();
                email = e3.getText().toString();
                password = e4.getText().toString();
                mobile = e6.getText().toString();


                if (fname.isEmpty() && fname.matches("")) {
                    ef.setError("First name not entered");
                    ef.requestFocus();
                } else if (lname.isEmpty() && lname.matches("")) {
                    el.setError("Last name not entered");
                    el.requestFocus();
                }else if (email.isEmpty() && email.matches("")) {
                    e3.setError("Email not entered");
                    e3.requestFocus();
                } else if (!email.matches(EmailPattern)) {
                    e3.setError("Invalid Email");
                } else if (password.isEmpty() && password.matches("") && password.contains(" ") && password.startsWith(" ") && password.endsWith(" ")) {
                    e4.setError("Password not entered");
                    e4.requestFocus();
                } else if (!mobile.matches(MobilePattern) && mobile.length()>10 && mobile.length()<10) {
                    e6.setError("Invalid Mobile Number");
                    e6.requestFocus();
                }else
                {
                    pref=getSharedPreferences("MyApp", Context.MODE_PRIVATE);

                    SharedPreferences.Editor ed=pref.edit();
                    ed.putString("fname",fname);
                    ed.putString("lname",lname);
                    ed.putString("Email",email);
                    ed.putString("Password",password);
                    ed.putString("Mobile",mobile);
                    ed.putBoolean("isregis",true);
                    ed.commit();
                    Log.e("name & Email & Pass==",fname+""+email+""+password);

                    Toast.makeText(RegistrationActivity.this, "SuccessFully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
