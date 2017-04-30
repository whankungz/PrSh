package com.example.whankung.navigity.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.whankung.navigity.R;

import java.util.ArrayList;

import static com.example.whankung.navigity.R.id.textView;


public class CustomAdapterMent extends BaseAdapter {

    Context mContext;
    String[] strName;
    String[] resId;

    public CustomAdapterMent(Context context, String[] strName, String[] resId) {
        this.mContext = context;
        this.strName = strName;
        this.resId = resId;
    }

    public CustomAdapterMent(Context applicationContext, ArrayList<String> arrayList, ArrayList<String> arrayTime) {

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

            view = mInflater.inflate(R.layout.list_item_ment, parent, false);
        TextView ment= (TextView) view.findViewById(R.id.mentP);
        Typeface font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");
        ment.setTypeface(font);
        //TextClock time = (TextClock) view.findViewById(R.id.tClock);
      // String ments = time.getText().toString();


       ment.setText(strName[position]);
       // time.setText(ments);
      //  img.setBackgroundResource(resId[position]);

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




