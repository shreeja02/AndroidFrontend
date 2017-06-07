package com.example.dell.androidfrontend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL on 6/5/2017.
 */

public class ansbyqus_custom_adapter extends BaseAdapter {

    Context mContext;
    ArrayList<ansByQusIdClass> mArrayList;
    LayoutInflater mLayoutInflater;

    public ansbyqus_custom_adapter(Context mContext, ArrayList<ansByQusIdClass> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        this.mLayoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ansbyqus_view_holder mItem;
        if (convertView==null)
        {
            convertView=mLayoutInflater.inflate(R.layout.ansbyqus_view_holder,null);
            mItem=new ansbyqus_view_holder((TextView) convertView.findViewById(R.id.txtansviewholderuname),
                    (TextView) convertView.findViewById(R.id.txtansviewholderdate),
                    (TextView) convertView.findViewById(R.id.txtansviewholderans));
            convertView.setTag(mItem);
        }
        else
        {

            mItem= (ansbyqus_view_holder) convertView.getTag();
        }
        //mItem.tvcoll_name.setText(mArrayList.get(position).getColl_name());
        mItem.txtusernameans.setText(mArrayList.get(position).getFk_email_id());
        mItem.txtdateans.setText(mArrayList.get(position).getDate());
        mItem.txtans.setText(mArrayList.get(position).getAnswer());
        return convertView;
    }
}
