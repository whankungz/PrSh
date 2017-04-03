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


public class CustomAdapterF extends BaseAdapter {

    Context mContext;
    String[] strName;
    int[] resId;

    public CustomAdapterF(Context context, String[] strName, int[] resId) {
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

            view = mInflater.inflate(R.layout.list_item_food, parent, false);
        TextView textView = (TextView) view.findViewById(R.id.article);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Typeface font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");
        textView.setTypeface(font);


        textView.setText(strName[position]);
        img.setBackgroundResource(resId[position]);

        if (position % 2 == 0) {

            //   view.setBackgroundResource(R.color.colorTop);

        } else {

            //    view.setBackgroundResource(R.color.color_bg_table);

        }

        View.OnClickListener yourClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                //put your desired action here

            }
        };


        return view;
    }
}




