package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class QuestionIdActivity extends AppCompatActivity {

    TextView tvquesidactivityname,tvquesidactivitydate,tvquesidactivitydescription,tvquesidactivitytitle;
    ArrayList<QuestionbyQuesId> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_id);

        mArrayList=new ArrayList<QuestionbyQuesId>();
        tvquesidactivityname= (TextView) findViewById(R.id.tvquesidactivityname);
       tvquesidactivitydate= (TextView) findViewById(R.id.tvquesidactivitydate);
        tvquesidactivitydescription=(TextView) findViewById(R.id.tvquesidactivitydescription);
        tvquesidactivitytitle=(TextView) findViewById(R.id.tvquesidactivitytitle);

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.get(QuestionIdActivity.this,"https://androidbackenddemo.herokuapp.com/qususer/12",new JsonHttpResponseHandler(){

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
                        mArrayList.add(new QuestionbyQuesId(Integer.parseInt(mJSONObject.getString("question_id")),mJSONObject.getString("question_title"),mJSONObject.getString("question_desc"),Integer.parseInt(mJSONObject.getString("fk_category_id")),mJSONObject.getString("date"),mJSONObject.getString("apporve"),mJSONObject.getString("fk_email_id"),mJSONObject.getString("user_name")));

                    }
                    tvquesidactivitydate.setText(mArrayList.get(0).date);
                    tvquesidactivityname.setText(mArrayList.get(0).user_name+"");
                    tvquesidactivitydescription.setText(mArrayList.get(0).question_desc+"");
                    tvquesidactivitytitle.setText(mArrayList.get(0).question_title+"");

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
                mProgressDialog=ProgressDialog.show(QuestionIdActivity.this,"Loading","Please Wait",true,false);
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
