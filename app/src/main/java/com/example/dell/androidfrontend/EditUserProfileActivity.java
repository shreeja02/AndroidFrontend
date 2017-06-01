package com.example.dell.androidfrontend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class EditUserProfileActivity extends AppCompatActivity {

    EditText txtname,txtmobile,txtphoto;
    Button btnsave;
    RadioButton btnmale,btnfemale;
    AsyncHttpClient mclient;
    ProgressDialog mProgressDialog;
    JSONObject mJsonObject;
    ArrayList<User> mArraylist;
    ProgressDialog mProgress;
    String gen;

   RadioButton rbtnmale,rbtnfemale;



    public void onRadioButtonClicked(View view) {

        switch(view.getId()) {
            case R.id.radiobutton_editprofile_male:
                gen="M";

                break;
            case R.id.radiobutton_editprofile_female:
                gen="F";

                break;


        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);

        setTitle("Edit Profile");

        btnsave= (Button) findViewById(R.id.btnedituserprofile_save);
        txtname= (EditText) findViewById(R.id.txtedituserprofile_name);
        txtmobile= (EditText) findViewById(R.id.txtedituserprofile_mobileno);
        rbtnmale= (RadioButton) findViewById(R.id.radiobutton_editprofile_male);
        rbtnfemale= (RadioButton) findViewById(R.id.radiobutton_editprofile_female);
        txtphoto= (EditText) findViewById(R.id.txtedituserprofile_photo);


        mclient=new AsyncHttpClient();
        mArraylist=new ArrayList<User>();







        mclient.get(EditUserProfileActivity.this, "https://androidbackenddemo.herokuapp.com/users/abc@gmail.com", new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                JSONArray mJsonarray=response;
                try {
                for(int i=0;i<mJsonarray.length();i++)
                {

                        mJsonObject=mJsonarray.getJSONObject(i);
                    mArraylist.add(new User(mJsonObject.getString("email_id"),mJsonObject.getString("user_name"),mJsonObject.getString("password"),mJsonObject.getString("user_photo"),mJsonObject.getString("mobile_no"),mJsonObject.getString("gender")));
                    txtname.setText(mArraylist.get(i).user_name);
                    txtmobile.setText(mArraylist.get(i).mobile_no);
                    gen=mArraylist.get(i).gender;
                    txtphoto.setText(mArraylist.get(i).user_photo);


                   // Toast.makeText(EditUserProfileActivity.this,mArraylist.get(i).user_name+"",Toast.LENGTH_LONG).show();
                    //Toast.makeText(EditUserProfileActivity.this,mArraylist.get(i).mobile_no+"",Toast.LENGTH_LONG).show();
                }

                    if(gen.equalsIgnoreCase("M"))
                    {
                        rbtnmale.setChecked(true);
                    }
                    else
                    {
                        rbtnfemale.setChecked(true);
                    }


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
                mProgress=ProgressDialog.show(EditUserProfileActivity.this,"Please wait","Loading",true,false);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if(mProgress.isShowing()){
                    mProgress.dismiss();
                }

            }



        });




        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RequestParams params=new RequestParams();
                params.add("user_name",txtname.getText().toString());
                params.add("mobile_no",txtmobile.getText().toString());
                params.add("user_photo",txtphoto.getText().toString());
                params.add("gender",gen);

                mclient.put("https://androidbackenddemo.herokuapp.com/users/abc@gmail.com",params,new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Toast.makeText(EditUserProfileActivity.this,"Updated Successfully",Toast.LENGTH_SHORT).show();
                        Intent it=new Intent(EditUserProfileActivity.this,ViewprofileActivity.class);
                        startActivity(it);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mProgress=ProgressDialog.show(EditUserProfileActivity.this,"Please wait","Loading",true,false);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if(mProgress.isShowing()){
                            mProgress.dismiss();
                        }
                    }
                });

               // Toast.makeText(EditUserProfileActivity.this,txtname.getText().toString(),Toast.LENGTH_LONG).show();

            }
        });

        }

}
