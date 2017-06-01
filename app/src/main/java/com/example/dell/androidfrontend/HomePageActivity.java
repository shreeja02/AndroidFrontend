package com.example.dell.androidfrontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {


    Button btnsignup,btnlogin,btnviewprofile,btneditprofile,btnchangepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnsignup= (Button) findViewById(R.id.btnhomepagesignup);
        btnviewprofile= (Button) findViewById(R.id.btnhomepageviewprofile);
        btnlogin= (Button) findViewById(R.id.btnhomepagelogin);
        btneditprofile= (Button) findViewById(R.id.btnhomepageeditprofile);
        btnchangepassword= (Button) findViewById(R.id.btnhomepagechangepassword);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itsignup=new Intent(HomePageActivity.this,SignupActivity.class);
                startActivity(itsignup);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itlogin=new Intent(HomePageActivity.this,Login.class);
                startActivity(itlogin);
            }
        });

        btnviewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itviewprofile=new Intent(HomePageActivity.this,ViewprofileActivity.class);
                startActivity(itviewprofile);
            }
        });

        btneditprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iteditprofile=new Intent(HomePageActivity.this,EditUserProfileActivity.class);
                startActivity(iteditprofile);
            }
        });

        btnchangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itchangepass=new Intent(HomePageActivity.this,ChangePasswordActivity.class);
                startActivity(itchangepass);
            }
        });

    }
}
