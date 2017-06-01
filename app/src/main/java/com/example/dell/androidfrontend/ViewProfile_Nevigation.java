package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ViewProfile_Nevigation extends AppCompatActivity {

    TextView mTextView;
    TextView tvViewProfileEmailId;
    TextView tvViewProfileMobileNo;
    TextView tvViewProfileGender;
    ArrayList<viewprofile> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile__nevigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent it=new Intent(ViewProfile_Nevigation.this,EditUserProfileActivity.class);
                startActivity(it);
            }
        });
        mArrayList=new ArrayList<viewprofile>();
        mTextView= (TextView) findViewById(R.id.lblViewProfileUsername);
        tvViewProfileEmailId= (TextView) findViewById(R.id.lblViewProfileEmailId);
        tvViewProfileMobileNo= (TextView) findViewById(R.id.lblViewProfileMobileNo);
        tvViewProfileGender= (TextView) findViewById(R.id.lblViewProfileGender);

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.get(ViewProfile_Nevigation.this,"https://androidbackenddemo.herokuapp.com/users/"+GlobalVariables.uname,new JsonHttpResponseHandler(){

            ProgressDialog mProgressDialog;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray mJSONArray=response;
                    JSONObject mJSONObject;

                    for (int i=0;i<mJSONArray.length();i++)
                    {
                        mJSONObject=mJSONArray.getJSONObject(i);

                        //mArrayList.add(new collection (Integer.parseInt(mJSONObject.getString("coll_id")),mJSONObject.getString("coll_name"),mJSONObject.getString("profile_photo"),mJSONObject.getString("cover_photo"),mJSONObject.getString("date"),mJSONObject.getString("description")));
                        mArrayList.add(new viewprofile(mJSONObject.getString("email_id"),mJSONObject.getString("user_name"),mJSONObject.getString("password"),mJSONObject.getString("user_photo"),mJSONObject.getString("mobile_no"),mJSONObject.getString("gender")));
                        System.out.println(mArrayList.get(i).email_id+"");
                    }

                    mTextView.setText(mArrayList.get(0).user_name);
                    tvViewProfileEmailId.setText(mArrayList.get(0).email_id);
                    tvViewProfileMobileNo.setText(mArrayList.get(0).mobile_no);
                    tvViewProfileGender.setText(mArrayList.get(0).gender);



                }
                catch (JSONException e) {
                    e.printStackTrace();
                }




            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();
                mProgressDialog=ProgressDialog.show(ViewProfile_Nevigation.this,"Loading","Please Wait",true,false);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if(mProgressDialog.isShowing())
                {
                    mProgressDialog.dismiss();
                }
            }

        });
    }

}
