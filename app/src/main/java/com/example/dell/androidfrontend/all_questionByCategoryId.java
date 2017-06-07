package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class all_questionByCategoryId extends AppCompatActivity {

    ListView lstquetitle;
    ArrayList<questionByCategoryId> mArrayList;
    String y;
    int temp1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_question_by_category_id);

        lstquetitle= (ListView) findViewById(R.id.lstquetitle);

        mArrayList=new ArrayList<questionByCategoryId>();
        AsyncHttpClient mClient=new AsyncHttpClient();

        Intent it=getIntent();
        y= it.getStringExtra("category_id");
        temp1=Integer.parseInt(y);
    //System.out.println("preshita"+temp1);
        //Toast.makeText(all_questionByCategoryId.this,temp+"",Toast.LENGTH_LONG).show();
        setTitle("Questions");


        mClient.get(all_questionByCategoryId.this,"https://androidbackenddemo.herokuapp.com/questionbycatid/"+temp1,new JsonHttpResponseHandler(){

            ProgressDialog mProgress;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try
                {
                    JSONArray mJSONArray=response;
                    JSONObject mJSONObject;

                    System.out.println(response);

                    for(int i=0;i<mJSONArray.length();i++)
                    {
                        mJSONObject=mJSONArray.getJSONObject(i);
                        mArrayList.add(new questionByCategoryId(Integer.parseInt(mJSONObject.getString("question_id")),
                                mJSONObject.getString("question_title"),
                                mJSONObject.getString("question_desc"),
                                (Integer.parseInt(mJSONObject.getString("fk_category_id"))),
                                mJSONObject.getString("date"),
                                mJSONObject.getString("apporve"),
                                mJSONObject.getString("fk_email_id")

                        ));

                    }


                }
                catch (JSONException e) {
                    e.printStackTrace();


                }

               lstquetitle.setAdapter(new questionByCategoryId_custom_adapter(all_questionByCategoryId.this,mArrayList));

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();
                mProgress=ProgressDialog.show(all_questionByCategoryId.this,"Loading","Please wait",true,false);
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
