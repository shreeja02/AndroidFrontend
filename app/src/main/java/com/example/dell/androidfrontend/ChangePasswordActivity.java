package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText etchangepassoldpass,etchangepassnewpass,etchangepassconfirmnewpass;
    Button btnchangepass;
    AsyncHttpClient mClient;
    ArrayList<User> mArrayList;
    String oldPassword,newPassword,cofirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        mArrayList=new ArrayList<User>();
        etchangepassoldpass=(EditText)findViewById(R.id.etchangepassoldpass);
        etchangepassnewpass=(EditText)findViewById(R.id.etchangepassnewpass);
        etchangepassconfirmnewpass=(EditText)findViewById(R.id.etchangepassconfirmnewpass);



        mClient=new AsyncHttpClient();
        mClient.get(ChangePasswordActivity.this,"https://androidbackenddemo.herokuapp.com/users/abc@gmail.com",new JsonHttpResponseHandler(){
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
                        mArrayList.add(new User(mJsonObject.getString("email_id"),mJsonObject.getString("user_name"),mJsonObject.getString("password"),mJsonObject.getString("user_photo"),mJsonObject.getString("mobile_no"),mJsonObject.getString("gender")));
                        System.out.println(mJsonObject+"");
                        System.out.println(mArrayList.get(i).password);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                oldPassword=mArrayList.get(0).password;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();
                mProgress=ProgressDialog.show(ChangePasswordActivity.this,"Please wait","Checking",true,false);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if(mProgress.isShowing()){
                    mProgress.dismiss();
                }

            }
        });



        btnchangepass=(Button)findViewById(R.id.btnchangepass);

        btnchangepass.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

               // etchangepassoldpass.setText(etchangepassoldpass.getText() + "");

                if((etchangepassoldpass.getText().length() != 0) && (etchangepassnewpass.getText().length() != 0) && (etchangepassconfirmnewpass.getText().length() != 0))
                {


                    String newpass=etchangepassnewpass.getText().toString();
                    String cnewpass=etchangepassconfirmnewpass.getText().toString();
                    String oldPass=etchangepassoldpass.getText().toString();

                    System.out.println(oldPass+"hello");
                    System.out.println(oldPassword+"bye");
                    if(oldPass.equals(oldPassword)) {
                        //isEmpty(),matches()
                        if (newpass.equals(cnewpass)) {

                            mClient=new AsyncHttpClient();
                            RequestParams params=new RequestParams();
                            params.add("password",newpass);
                            mClient.post("https://androidbackenddemo.herokuapp.com/changepassword/abc@gmail.com",params,new JsonHttpResponseHandler(){


                                ProgressDialog mProgress;

                                @Override
                                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                    super.onSuccess(statusCode, headers, response);
                                    Toast.makeText(ChangePasswordActivity.this, "Updated successfully", Toast.LENGTH_LONG).show();
                                    Intent it=new Intent(ChangePasswordActivity.this,SignupActivity.class);
                                    startActivity(it);
                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                    super.onFailure(statusCode, headers, throwable, errorResponse);
                                }

                                @Override
                                public void onStart() {
                                    super.onStart();
                                    mProgress=ProgressDialog.show(ChangePasswordActivity.this,"Please wait","Checking",true,false);
                                }

                                @Override
                                public void onFinish() {
                                    super.onFinish();
                                    if(mProgress.isShowing()){
                                        mProgress.dismiss();
                                    }

                                }
                            });

                        } else {
                            Toast.makeText(ChangePasswordActivity.this, "New and Confirm Password didnt Matched", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(ChangePasswordActivity.this, "Old Password didnt Matched", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(ChangePasswordActivity.this, "You need to enter password", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
