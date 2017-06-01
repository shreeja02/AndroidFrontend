package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
public class Login extends AppCompatActivity
{
    Button btnlogin;
    EditText txtloginemail,txtloginpassword;

    AsyncHttpClient mClient;
    ArrayList<ULogin> mArrayList;
    String email,password;
   // mArrayList=new ArrayList<ULogin>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mArrayList=new ArrayList<ULogin>();
        btnlogin= (Button) findViewById(R.id.btnlogin);
        txtloginemail= (EditText) findViewById(R.id.txtloginemail);
        txtloginpassword= (EditText) findViewById(R.id.txtloginpassword);

        mClient=new AsyncHttpClient();
        mClient.get(Login.this,"https://androidbackenddemo.herokuapp.com/users/demo@gmail.com",new JsonHttpResponseHandler(){
                ProgressDialog mProgress;

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                    JSONArray mJsonArray;
                    JSONObject mJsonObject;
                    mJsonArray=response;
                    try {
                        for(int i=0;i<mJsonArray.length();i++){

                            mJsonObject=mJsonArray.getJSONObject(i);
                            mArrayList.add(new ULogin(mJsonObject.getString("email_id"),mJsonObject.getString("password")));
                            System.out.println(mJsonObject+"");
                            System.out.println(mArrayList.get(i).password);


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    email=mArrayList.get(0).email_id;
                    password=mArrayList.get(0).password;
                    //Toast.makeText(Login.this,email+"", Toast.LENGTH_LONG).show();
                   // Toast.makeText(Login.this,password+"", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }

                @Override
                public void onStart() {
                    super.onStart();
                    mProgress=ProgressDialog.show(Login.this,"Please wait","Checking",true,false);
                }

                @Override
                public void onFinish() {
                    super.onFinish();
                    if(mProgress.isShowing()){
                        mProgress.dismiss();
                    }

                }
            });

        btnlogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if((txtloginemail.getText().length() != 0) && (txtloginpassword.getText().length() != 0))
                        {
                            String emailid=txtloginemail.getText().toString();
                            String pass=txtloginpassword.getText().toString();
                           // Toast.makeText(Login.this,email+"", Toast.LENGTH_LONG).show();
                           // Toast.makeText(Login.this,pass+"", Toast.LENGTH_LONG).show();
                            if(emailid.equals(email) && pass.equals(password))
                            {
                                Toast.makeText(Login.this,"Match Found Successfully", Toast.LENGTH_LONG).show();
                            }
                            else if(emailid!=(email) && pass.equals(password))
                            {
                                Toast.makeText(Login.this,"Email Address Not Found", Toast.LENGTH_LONG).show();
                            }

                            else if(emailid.equals(email) && pass!=(password))
                            {
                                Toast.makeText(Login.this,"Incorrect Password", Toast.LENGTH_LONG).show();
                            }

                            else
                            {
                                Toast.makeText(Login.this,"Match Not Found", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Login.this,"Please Fill Out Necessary Fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

