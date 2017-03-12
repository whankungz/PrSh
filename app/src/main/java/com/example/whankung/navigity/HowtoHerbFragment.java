package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;



/**
 * Created by Whankung on 22/1/2560.
 */
public class HowtoHerbFragment extends android.support.v4.app.Fragment {
    private Typeface font;
    private View rootView;
    private TextView p, pdata, h, hdata, t, tdata, ment, sub, nm, un, date;
    private RatingBar rat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.howto_herb, container, false);
        setView();
        setData();
//        setRating();
        rat = (RatingBar) rootView.findViewById(R.id.rat);

//        if (AppState.getSingleInstance().isLogin()) {
//            rat.setVisibility(View.VISIBLE);
//            AppState.getSingleInstance().setLogin(false);
//        }
        return rootView;
    }

    private void setRating() {
//        rat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//
//                String rateValue = String.valueOf(rat.getRating());
//                System.out.println("Rate for Module is"+rateValue);
//            }
//        });
    }

    private void setView() {
        date = (TextView) rootView.findViewById(R.id.date);
        nm = (TextView) rootView.findViewById(R.id.nameMe);
        un = (TextView) rootView.findViewById(R.id.Uname);
        p = (TextView) rootView.findViewById(R.id.proper);
        pdata = (TextView) rootView.findViewById(R.id.properdata);
        h = (TextView) rootView.findViewById(R.id.how);
        hdata = (TextView) rootView.findViewById(R.id.howdata);
        t = (TextView) rootView.findViewById(R.id.t);
        tdata = (TextView) rootView.findViewById(R.id.tdata);
        ment = (TextView) rootView.findViewById(R.id.ment);
        sub = (TextView) rootView.findViewById(R.id.submit);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        p.setTypeface(font);
        pdata.setTypeface(font);
        h.setTypeface(font);
        hdata.setTypeface(font);
        t.setTypeface(font);
        tdata.setTypeface(font);
        ment.setTypeface(font);
        sub.setTypeface(font);
        nm.setTypeface(font);
        un.setTypeface(font);
        date.setTypeface(font);
    }

    private void setData() {
        pdata.setText("เปลือก – รักษาอาการท้องเสีย");
        hdata.setText("1.นำเปลือกทับทิมมาต้มกับน้ำจนเดือดให้เด็กดื่มน้ำทับทิมครั้งละ1-2 ช้อนชา ทุก 4 ชั่วโมงและ1 ช้อนโต๊ะสำหรับผู้ใหญ่\n" +
                "2.ใช้เปลือกแห้งฝนน้ำรับประทาน");
        tdata.setText("คนที่แพ้ทับทิมจะเกิดอาการเป็นผื่นลมพิษ การบวมที่ลิ้น ริมฝีปาก มือ แขน ใบหน้า คันตา ตาแดง ระคายเคืองจูก หายใจลำบาก และเกิดภาวะแพ้รุนแรง(anaphylactic) และยังมีรายงานว่าเด็กที่รับประทานเมล็ดทับทิมแล้วเกิดอาการหอบหืดชนิดที่เกี่ยวข้องกับ IgE ขึ้น นอกจากนี้การทดสอบการแพ้ทางผิวหนังของผลสด พบว่ามีอาการแพ้");
    }
}
