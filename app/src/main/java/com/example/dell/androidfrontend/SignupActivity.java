package com.example.dell.androidfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class SignupActivity extends AppCompatActivity {

    String gen,emailid,username,passwd,passwd1,mobileno,pic;
    Button register;
    int flag=0;
    EditText email,name,pass,pass1,mobile,photo;
    AsyncHttpClient mClient;
    RequestParams params;
    String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public void onRadioButtonClicked(View view) {
        boolean checked=((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButtonSignupFemale:
              gen="Female";
               // Toast.makeText(SignupActivity.this,gen,Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButtonSignupMale:
                gen="Male";
              //  Toast.makeText(SignupActivity.this,gen,Toast.LENGTH_SHORT).show();
                break;


        }}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        register= (Button) findViewById(R.id.btnSignupRegister);
        email= (EditText) findViewById(R.id.txtSignupEmail);
        name= (EditText) findViewById(R.id.txtSignupName);
        pass= (EditText) findViewById(R.id.txtSignupPassword);
        pass1= (EditText) findViewById(R.id.txtSignupPassword1);
        photo= (EditText) findViewById(R.id.txtSignupPhoto);
        mobile= (EditText) findViewById(R.id.txtSignupMobile);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailid=email.getText()+"";
                username=name.getText()+"";
                passwd=pass.getText()+"";
                passwd1=pass1.getText()+"";
                pic=photo.getText()+"";
                mobileno=mobile.getText()+"";

                if(emailid.matches("")){
                    Toast.makeText(SignupActivity.this,"You did not enter your email id",Toast.LENGTH_LONG).show();
                    flag=1;
                }
                    else
                {
                    if(!emailid.matches(emailPattern)){
                        Toast.makeText(SignupActivity.this,"Inalid email id",Toast.LENGTH_LONG).show();
                        flag=1;
                    }

                }

                if(username.matches("")){
                    Toast.makeText(SignupActivity.this,"You did not enter username",Toast.LENGTH_LONG).show();
                    flag=1;
                }
                if(passwd.matches("") || passwd1.matches("") ){
                    Toast.makeText(SignupActivity.this,"Please enter password",Toast.LENGTH_LONG).show();
                    flag=1;
                }
                else {
                    if (!passwd.matches(passwd1)) {
                        Toast.makeText(SignupActivity.this, "Passwords does not match", Toast.LENGTH_LONG).show();
                        flag=1;
                    }
                }
                if(mobileno.matches("")){
                    Toast.makeText(SignupActivity.this,"You did not enter mobile number",Toast.LENGTH_LONG).show();
                    flag=1;
                }
                else {
                    if (mobileno.length() != 10) {
                        Toast.makeText(SignupActivity.this, "Mobile number should be of 10 digits", Toast.LENGTH_LONG).show();
                        flag=1;
                    }
                }
                if (flag == 0) {

                    mClient = new AsyncHttpClient();

                    params = new RequestParams();
                    params.put("email_id", emailid);
                    params.put("user_name", username);
                    params.put("password", passwd);
                    params.put("user_photo", pic);
                    params.put("mobile_no", mobileno);
                    params.put("gender", gen);
                    mClient.post("https://androidbackenddemo.herokuapp.com/users", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);
                            Toast.makeText(SignupActivity.this, "User Added", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            Toast.makeText(SignupActivity.this, "failed", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });
    }
}
