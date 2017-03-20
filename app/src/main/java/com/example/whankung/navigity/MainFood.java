package com.example.whankung.navigity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Whankung on 31/1/2560.
 */
public class MainFood  extends Fragment {

    private Typeface font;
    TextView tv, im, im2, im3, im4, im5,im6,p,p2,p3,p4,p5,p6;
    ImageView img, i, i2, i3, i4, i5, i6;
    public static final String BASE_URL = "http://192.168.181.50:8080/Servies/webresources/";
    private static final String TAG = "log";
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_food, container, false);
        setView();

        setView();
        setData();

        return rootView;
    }

    private void setView() {
        tv = (TextView) rootView.findViewById(R.id.textView);
        img = (ImageView)rootView.findViewById(R.id.action_login);
        i = (ImageView) rootView.findViewById(R.id.img);
        i2 = (ImageView) rootView.findViewById(R.id.img2);
        i3 = (ImageView) rootView.findViewById(R.id.img3);
        i4 = (ImageView) rootView.findViewById(R.id.img4);

        im = (TextView) rootView.findViewById(R.id.im);
        im2 = (TextView)rootView. findViewById(R.id.im2);
        im3 = (TextView) rootView.findViewById(R.id.im3);
        im4 = (TextView) rootView.findViewById(R.id.im4);

        p = (TextView) rootView.findViewById(R.id.p);
        p2 = (TextView) rootView.findViewById(R.id.p2);
        p3 = (TextView) rootView.findViewById(R.id.p3);
        p4 = (TextView)rootView.findViewById(R.id.p4);


//        เปลี่ยนfont
        font = Typeface.createFromAsset(getActivity().getAssets(), "tmedium.ttf");

        im.setTypeface(font);
        im2.setTypeface(font);
        im3.setTypeface(font);
        im4.setTypeface(font);

        p.setTypeface(font);
        p2.setTypeface(font);
        p3.setTypeface(font);
        p4.setTypeface(font);





        i.setClickable(true);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container, new DataFood());
                transaction.commit();

            }
        });
    }

    private void setData() {
        i.setImageResource(R.drawable.img_f2);
        i2.setImageResource(R.drawable.img_f1);
        i3.setImageResource(R.drawable.img_f);
        i4.setImageResource(R.drawable.img_f3);

        im.setText("น้ำพริกผักลวก เพื่อสุขภาพ");
        im2.setText("ตำข้าวโพดใส่ไข่เค็ม");
        im3.setText("ก๋วยเตี๋ยวไก่ตุ๋นมะระ");
        im4.setText("แกงฮังเลไก่");

    }
}
