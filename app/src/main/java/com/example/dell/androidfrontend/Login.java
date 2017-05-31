package com.example.dell.androidfrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity
{
    Button mButton;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mButton= (Button) findViewById(R.id.btnlogin);
        mEditText= (EditText) findViewById(R.id.txtname);
        mEditText= (EditText) findViewById(R.id.txtpassword);

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.v("EditText",mEditText.getText().toString());
                    }
                });
    }
}
