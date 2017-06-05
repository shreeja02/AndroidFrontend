package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class answerbyqus extends AppCompatActivity {
    TextView tvAnsByQusTitle,tvAnsDesc;
    String ans,ans1;
    PopupWindow pwindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerbyqus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvAnsByQusTitle= (TextView) findViewById(R.id.lblAnsByQusTitle);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();




            }
        });

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.get(answerbyqus.this,"https://androidbackenddemo.herokuapp.com/question/4",new JsonHttpResponseHandler(){

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
                        //mArrayList.add(new viewprofile(mJSONObject.getString("email_id"),mJSONObject.getString("user_name"),mJSONObject.getString("password"),mJSONObject.getString("user_photo"),mJSONObject.getString("mobile_no"),mJSONObject.getString("gender")));
                        //System.out.println(mArrayList.get(i).email_id+"");
                        ans=mJSONObject.getString("question_title");
                    }

                    tvAnsByQusTitle.setText(ans);




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
                mProgressDialog=ProgressDialog.show(answerbyqus.this,"Loading","Please Wait",true,false);
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

        mClient.get(answerbyqus.this,"https://androidbackenddemo.herokuapp.com/answerbyquestid/4",new JsonHttpResponseHandler(){

            ProgressDialog mProgressDialog;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray mJSONArray=response;
                    JSONObject mJSONObject;

                    for (int i=0;i<mJSONArray.length();i++)
                    {
                        tvAnsDesc= (TextView) findViewById(R.id.lblAnsDesc);
                        mJSONObject=mJSONArray.getJSONObject(i);

                        //mArrayList.add(new collection (Integer.parseInt(mJSONObject.getString("coll_id")),mJSONObject.getString("coll_name"),mJSONObject.getString("profile_photo"),mJSONObject.getString("cover_photo"),mJSONObject.getString("date"),mJSONObject.getString("description")));
                        //mArrayList.add(new viewprofile(mJSONObject.getString("email_id"),mJSONObject.getString("user_name"),mJSONObject.getString("password"),mJSONObject.getString("user_photo"),mJSONObject.getString("mobile_no"),mJSONObject.getString("gender")));
                        //System.out.println(mArrayList.get(i).email_id+"");
                        ans1=mJSONObject.getString("answer");
                        tvAnsDesc.setText(ans1);
                    }

                    //tvAnsDesc.setText(ans1);




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
                mProgressDialog=ProgressDialog.show(answerbyqus.this,"Loading","Please Wait",true,false);
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
