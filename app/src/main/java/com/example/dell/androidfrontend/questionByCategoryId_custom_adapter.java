package com.example.dell.androidfrontend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 6/5/2017.
 */

public class questionByCategoryId_custom_adapter extends BaseAdapter {

    Context mContext;
    ArrayList<questionByCategoryId> mArrayList;
    LayoutInflater mLayoutInflater;

    public questionByCategoryId_custom_adapter(Context mContext, ArrayList<questionByCategoryId> mArrayList) {
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

        questionByCategoryId_viewholder mItem;

        if(convertView==null)
        {
            convertView=mLayoutInflater.inflate(R.layout.questionbycategoryid_view_holder,null);
            mItem=new questionByCategoryId_viewholder((TextView) convertView.findViewById(R.id.lblquetiontitle));
            convertView.setTag(mItem);
        }
        else
        {
            mItem= (questionByCategoryId_viewholder) convertView.getTag();
        }

        mItem.lblquestiontitle.setText(mArrayList.get(position).getQuestion_title()+"");

        return convertView;
    }
}
