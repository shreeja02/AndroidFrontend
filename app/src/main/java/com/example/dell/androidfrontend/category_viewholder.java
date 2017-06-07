package com.example.dell.androidfrontend;

import android.widget.TextView;

/**
 * Created by Dell on 6/3/2017.
 */

public class category_viewholder {

    TextView  lblcatname;

    public category_viewholder(TextView lblcatname) {
        this.lblcatname = lblcatname;
    }

    public TextView getLblcatname() {
        return lblcatname;
    }

    public void setLblcatname(TextView lblcatname) {
        this.lblcatname = lblcatname;
    }
}
