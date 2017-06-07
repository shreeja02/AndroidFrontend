package com.example.dell.androidfrontend;

import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Dell on 6/5/2017.
 */

public class questionByCategoryId_viewholder {

    TextView lblquestiontitle;

    public questionByCategoryId_viewholder(TextView lblquestiontitle) {
        this.lblquestiontitle = lblquestiontitle;
    }

    public TextView getLblquestiontitle() {
        return lblquestiontitle;
    }

    public void setLblquestiontitle(TextView lblquestiontitle) {
        this.lblquestiontitle = lblquestiontitle;
    }


}
