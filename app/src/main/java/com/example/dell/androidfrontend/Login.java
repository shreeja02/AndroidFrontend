package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin= (Button) findViewById(R.id.btnlogin);
        txtloginemail= (EditText) findViewById(R.id.txtloginemail);
        txtloginpassword= (EditText) findViewById(R.id.txtloginpassword);


        btnlogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if((txtloginemail.getText().length() != 0) && (txtloginpassword.getText().length() != 0))
                        {
                            mClient=new AsyncHttpClient();
                            RequestParams params=new RequestParams();
                            params.add("email_id",txtloginemail.getText()+"");
                            params.add("password",txtloginpassword.getText()+"");
                            mClient.post(Login.this,"https://androidbackenddemo.herokuapp.com/login",params,new JsonHttpResponseHandler(){

                                ProgressDialog mProgress;

                                @Override
                                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                                    super.onSuccess(statusCode, headers, response);
                                    JSONArray mJsonArray=response;
                                    if(mJsonArray.length()==1){
                                            GlobalVariables.uname=txtloginemail.getText()+"";
                                        Intent it=new Intent(Login.this,HomePageActivity.class);
                                        startActivity(it);
                                    }
                                    else
                                    {
                                        Toast.makeText(Login.this,"Invalid",Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                                    super.onFailure(statusCode, headers, throwable, errorResponse);
                                }

                                @Override
                                public void onStart() {
                                    super.onStart();
                                    mProgress=ProgressDialog.show(Login.this,"Loading","Please wait",true,false);
                                }

                                @Override
                                public void onFinish() {
                                    super.onFinish();
                                    if(mProgress.isShowing()){
                                        mProgress.dismiss();
                                    }
                                }
                            });

                        }
                        else
                        {
                            Toast.makeText(Login.this,"Please Fill Out Necessary Fields", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

