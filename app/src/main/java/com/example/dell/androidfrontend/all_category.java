package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class all_category extends AppCompatActivity {

    //int random_student;
    GridView gvcategory;
    ArrayList<category> mArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        gvcategory= (GridView) findViewById(R.id.gvcategory);


        mArrayList=new ArrayList<category>();
        AsyncHttpClient mClient=new AsyncHttpClient();

        setTitle("Category");
        mClient.get(all_category.this,"https://androidbackenddemo.herokuapp.com/category/",new JsonHttpResponseHandler(){

            ProgressDialog mProgress;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                try
                {
                    JSONArray mJSONArray=response;
                    JSONObject mJSONObject;

                    for(int i=0;i<mJSONArray.length();i++)
                    {
                        mJSONObject=mJSONArray.getJSONObject(i);
                        mArrayList.add(new category(Integer.parseInt(mJSONObject.getString("category_id")),
                                mJSONObject.getString("category_name")



                        ));


                       // cat_id=mArrayList.get(i).getCategory_id();

                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();


                }

                gvcategory.setAdapter(new category_custom_adapter(all_category.this,mArrayList));

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();
                mProgress=ProgressDialog.show(all_category.this,"Loading","Please wait",true,false);
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


        gvcategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                category mCategory= (category) parent.getItemAtPosition(position);

                String x= (mCategory.getCategory_id()+"");
                System.out.println(mCategory.getCategory_id());

               Intent it=new Intent(all_category.this,all_questionByCategoryId.class);

                it.putExtra("category_id",x);

                startActivity(it);
                //Toast.makeText(all_category.this,x+"",Toast.LENGTH_LONG).show();

            }
        });
    }
}
