package com.example.dell.androidfrontend;

import android.widget.TextView;

/**
 * Created by Meet on 05-Jun-17.
 */

public class homePageDisplay_view_holder {

    TextView txtusername;
    TextView txtdate;
    TextView txtquestion;

    public homePageDisplay_view_holder(TextView txtusername, TextView txtdate, TextView txtquestion) {
        this.txtusername = txtusername;
        this.txtdate = txtdate;
        this.txtquestion = txtquestion;
    }

    public TextView getTxtusername() {
        return txtusername;
    }

    public void setTxtusername(TextView txtusername) {
        this.txtusername = txtusername;
    }

    public TextView getTxtdate() {
        return txtdate;
    }

    public void setTxtdate(TextView txtdate) {
        this.txtdate = txtdate;
    }

    public TextView getTxtquestion() {
        return txtquestion;
    }

    public void setTxtquestion(TextView txtquestion) {
        this.txtquestion = txtquestion;
    }
}
