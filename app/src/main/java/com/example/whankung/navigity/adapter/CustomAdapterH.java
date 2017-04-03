package com.example.whankung.navigity.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.navigity.R;

/**
 * Created by Admin on 8/9/2559.
 */

public class CustomAdapterH extends BaseAdapter {

    Context mContext;
    String[] strName;
    int[] resId;

    public CustomAdapterH(Context context, String[] strName, int[] resId) {
        this.mContext = context;
        this.strName = strName;
        this.resId = resId;
    }

    public int getCount() {
        return strName.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (view == null)
            view = mInflater.inflate(R.layout.list_item, null);
        TextView textView = (TextView) view.findViewById(R.id.herb);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Typeface font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");
        textView.setTypeface(font);


        textView.setText(strName[position]);
        img.setBackgroundResource(resId[position]);


        return view;
    }
}




