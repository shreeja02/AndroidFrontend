package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class AddQuestionActivity extends AppCompatActivity {

    EditText txttitle,txtdesc;
    Spinner subject;
    Button btnadd;
    AsyncHttpClient mClient;
    RequestParams params;
    JSONObject mJsonobject;
    String cat_id;
    List<String> c_name;
    List<String> c_id;
    ProgressDialog mProgress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        txttitle= (EditText) findViewById(R.id.txtaddquestion_title);
        txtdesc= (EditText) findViewById(R.id.txtaddquestion_description);
        btnadd= (Button) findViewById(R.id.btnaddquestion_add);
        subject= (Spinner) findViewById(R.id.spinneraddquestion_subject);
        mClient=new AsyncHttpClient();
        c_name = new ArrayList<String>();
        c_id=new ArrayList<String>();

        setTitle("Add Question");


        mClient.get(AddQuestionActivity.this,"https://androidbackenddemo.herokuapp.com/category",new JsonHttpResponseHandler()
        {


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                JSONArray mJsonarray=response;
                try {


                for(int i=0;i<mJsonarray.length();i++) {

                    mJsonobject = mJsonarray.getJSONObject(i);
                    String name=mJsonobject.getString("category_name");
                    String id=mJsonobject.getString("category_id");


                    c_name.add(name);
                    c_id.add(id);

                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AddQuestionActivity.this, android.R.layout.simple_spinner_item, c_name);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    subject.setAdapter(dataAdapter);


                }

                    subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                    {
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                        {
                            String selectedItem = parent.getItemAtPosition(position).toString();

                            cat_id=c_id.get(position);

                           // Toast.makeText(AddQuestionActivity.this,cat_id+"",Toast.LENGTH_LONG).show();


                        } // to close the onItemSelected
                        public void onNothingSelected(AdapterView<?> parent)
                        {

                        }
                    });

                } catch (JSONException e) {
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
                mProgress= ProgressDialog.show(AddQuestionActivity.this,"Please wait","Loading",true,false);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if(mProgress.isShowing()){
                    mProgress.dismiss();
                }
            }
        });





        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(txttitle.length()==0 || txtdesc.length()==0  )
                {
                    Toast.makeText(AddQuestionActivity.this,"not empty",Toast.LENGTH_SHORT).show();
                }
                else {


                    mClient = new AsyncHttpClient();

                    params = new RequestParams();
                    params.add("question_title", txttitle.getText() + "");
                    params.add("question_desc", txtdesc.getText() + "");
                    params.add("fk_category_id", cat_id);
                    params.add("apporve", "yes");
                    params.add("fk_email_id", GlobalVariables.uname);
                    mClient.post("https://androidbackenddemo.herokuapp.com/question", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            super.onSuccess(statusCode, headers, response);
                            Toast.makeText(AddQuestionActivity.this, "Question Added", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                            Toast.makeText(AddQuestionActivity.this, "failed", Toast.LENGTH_LONG).show();
                        }
                    });

                }
                }

        });

    }







}
