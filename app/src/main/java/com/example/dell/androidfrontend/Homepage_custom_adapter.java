package com.example.dell.androidfrontend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Meet on 05-Jun-17.
 */

public class Homepage_custom_adapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<QuestionTable> mArrayList;

    public Homepage_custom_adapter(Context mContext, ArrayList<QuestionTable> mArrayList) {
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


        homePageDisplay_view_holder mItem;

        if(convertView==null)
        {
            convertView=mLayoutInflater.inflate(R.layout.homepage_view_holder,null);
            mItem=new homePageDisplay_view_holder((TextView) convertView.findViewById(R.id.txtquestionviewholderuname),
                    (TextView) convertView.findViewById(R.id.txtquestionviewholderdate),
                    (TextView) convertView.findViewById(R.id.txtquestionviewholderquestion));
                    convertView.setTag(mItem);
        }
        else {
            mItem= (homePageDisplay_view_holder) convertView.getTag();
        }
        mItem.txtusername.setText(mArrayList.get(position).getFk_email_id());
        mItem.txtdate.setText(mArrayList.get(position).getDate());
        mItem.txtquestion.setText(mArrayList.get(position).getQuestion_title());

        return convertView;
    }
}
