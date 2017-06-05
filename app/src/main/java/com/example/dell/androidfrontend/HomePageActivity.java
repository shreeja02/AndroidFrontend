package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class HomePageActivity extends AppCompatActivity {


    ListView mquestionListview;
    ArrayList<QuestionTable> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mquestionListview= (ListView) findViewById(R.id.lstallquestiondisplay);
        mArrayList=new ArrayList<QuestionTable>();

        AsyncHttpClient mClient=new AsyncHttpClient();

        mClient.get(HomePageActivity.this,"https://androidbackenddemo.herokuapp.com/question",new JsonHttpResponseHandler(){


            ProgressDialog mProgress;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                JSONArray mJSONArray = response;
                JSONObject mJsonObject;
                try {

                    for (int i = 0; i < mJSONArray.length(); i++) {

                        mJsonObject = mJSONArray.getJSONObject(i);
                        mArrayList.add(new QuestionTable(Integer.parseInt(mJsonObject.getString("question_id")),
                                mJsonObject.getString("question_title"),
                                mJsonObject.getString("question_desc"),
                                Integer.parseInt(mJsonObject.getString("fk_category_id")),
                                mJsonObject.getString("date"),
                                mJsonObject.getString("apporve"),
                                mJsonObject.getString("fk_email_id"),
                                mJsonObject.getString("user_name"),
                                mJsonObject.getString("user_photo"),
                                mJsonObject.getString("category_name"),
                                Integer.parseInt(mJsonObject.getString("category_id"))));
                    }
                }

                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                mquestionListview.setAdapter(new Homepage_custom_adapter(HomePageActivity.this,mArrayList));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();

                mProgress=ProgressDialog.show(HomePageActivity.this,"Loading","Please Wait",true,false);

            }

            @Override
            public void onFinish() {
                super.onFinish();

                if(mProgress.isShowing())
                {
                    mProgress.dismiss();
                }

            }
        });

    }
}
