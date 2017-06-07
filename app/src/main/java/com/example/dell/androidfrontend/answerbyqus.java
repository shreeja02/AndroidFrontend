package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class answerbyqus extends AppCompatActivity {

    String ans,ans1;
    TextView tvQusTitle;
    ListView lstAnsDesc;
    ArrayList<ansByQusIdClass> mArrayList;
    EditText anspost;
    Button btnpost;
    String answer;
    AsyncHttpClient mClient;
    RequestParams params;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerbyqus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mArrayList=new ArrayList<ansByQusIdClass>();
        tvQusTitle= (TextView) findViewById(R.id.lblQusTitle);
        lstAnsDesc= (ListView) findViewById(R.id.lstAnsDesc);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      //  .setAction("Action", null).show();
                anspost= (EditText) findViewById(R.id.etanspost);
                btnpost= (Button) findViewById(R.id.btnanspost);

                anspost.setVisibility(view.VISIBLE);
                btnpost.setVisibility(view.VISIBLE);
                anspost.requestFocus();
                InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                btnpost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer=anspost.getText()+"";
                        AsyncHttpClient mClient=new AsyncHttpClient();
                        params = new RequestParams();
                        params.put("answer",answer);
                        params.put("fk_que_id","4");
                        params.put("fk_email_id","het@gmail.com");

                        mClient.post("https://androidbackenddemo.herokuapp.com/answer", params, new JsonHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                super.onSuccess(statusCode, headers, response);
                                Toast.makeText(answerbyqus.this, "Answer Added", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                super.onFailure(statusCode, headers, throwable, errorResponse);
                                Toast.makeText(answerbyqus.this, "failed", Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                });




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
                    tvQusTitle.setText(ans);






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
                       // tvAnsDesc= (TextView) findViewById(R.id.lblAnsDesc);
                        mJSONObject=mJSONArray.getJSONObject(i);

                        //mArrayList.add(new collection (Integer.parseInt(mJSONObject.getString("coll_id")),mJSONObject.getString("coll_name"),mJSONObject.getString("profile_photo"),mJSONObject.getString("cover_photo"),mJSONObject.getString("date"),mJSONObject.getString("description")));
                        //mArrayList.add(new viewprofile(mJSONObject.getString("email_id"),mJSONObject.getString("user_name"),mJSONObject.getString("password"),mJSONObject.getString("user_photo"),mJSONObject.getString("mobile_no"),mJSONObject.getString("gender")));
                        //System.out.println(mArrayList.get(i).email_id+"");
                       mArrayList.add(new ansByQusIdClass(Integer.parseInt(mJSONObject.getString("answer_id")),mJSONObject.getString("answer"),Integer.parseInt(mJSONObject.getString("fk_que_id")),mJSONObject.getString("fk_email_id"),mJSONObject.getString("date"),mJSONObject.getString("email_id"),mJSONObject.getString("user_name"),mJSONObject.getString("password"),mJSONObject.getString("user_photo"),mJSONObject.getString("mobile_no"),mJSONObject.getString("gender")));

                    }

                    //tvAnsDesc.setText(ans1);




                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

                lstAnsDesc.setAdapter(new ansbyqus_custom_adapter(answerbyqus.this,mArrayList));




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
