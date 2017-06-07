package com.example.dell.androidfrontend;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 6/3/2017.
 */

public class category_custom_adapter extends BaseAdapter {

    Context mContext;
    ArrayList<category> mArrayList;
    LayoutInflater mLayoutInflater;

    public category_custom_adapter(Context mContext, ArrayList<category> mArrayList) {
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

        category_viewholder mItem;

       // int color; // Transparent

        if (convertView==null)
        {
            convertView=mLayoutInflater.inflate(R.layout.category_view_holder,null);
            mItem=new category_viewholder((TextView) convertView.findViewById(R.id.lblcatname));
            convertView.setTag(mItem);
            //color = 0x00FF00 ; // Opaque Blue
            convertView.setBackgroundColor(Color.CYAN);


        }
        else
        {
            mItem= (category_viewholder) convertView.getTag();
        }
        mItem.lblcatname.setText(mArrayList.get(position).getCategory_name()+"");

        return convertView;
    }
}
