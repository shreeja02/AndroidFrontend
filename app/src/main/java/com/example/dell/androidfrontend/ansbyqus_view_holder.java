package com.example.dell.androidfrontend;

import android.widget.TextView;

/**
 * Created by DELL on 6/5/2017.
 */

public class ansbyqus_view_holder {

    TextView txtusernameans;
    TextView txtdateans;
    TextView txtans;

    public ansbyqus_view_holder(TextView txtusernameans, TextView txtdateans, TextView txtans) {
        this.txtusernameans = txtusernameans;
        this.txtdateans = txtdateans;
        this.txtans = txtans;
    }

    public TextView getTxtusernameans() {
        return txtusernameans;
    }

    public void setTxtusernameans(TextView txtusernameans) {
        this.txtusernameans = txtusernameans;
    }

    public TextView getTxtdateans() {
        return txtdateans;
    }

    public void setTxtdateans(TextView txtdateans) {
        this.txtdateans = txtdateans;
    }

    public TextView getTxtans() {
        return txtans;
    }

    public void setTxtans(TextView txtans) {
        this.txtans = txtans;
    }
}
