package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by Whankung on 22/1/2560.
 */
public class GeneralHerbFragment extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private EditText search;
    private TextView herb, herb2, other, other2, see, see2, t, t2, t3, t4, t5, t6, data, data2, data3, data4, data5, data6;
    private ImageView i1, i2, i3, i4, i5, i6, i7,fav;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.general_herb, container, false);
        setView();
        setSearch();

        return rootView;
    }


    private void setView() {
        search = (EditText) rootView.findViewById(R.id.search);
        herb = (TextView) rootView.findViewById(R.id.nameH);
        herb2 = (TextView) rootView.findViewById(R.id.nameH2);
        other = (TextView) rootView.findViewById(R.id.nameOther);
        other2 = (TextView) rootView.findViewById(R.id.nameOther2);
        see = (TextView) rootView.findViewById(R.id.nameSee);
        see2 = (TextView) rootView.findViewById(R.id.nameSee2);
        t = (TextView) rootView.findViewById(R.id.tree);
        t2 = (TextView) rootView.findViewById(R.id.tree2);
        t3 = (TextView) rootView.findViewById(R.id.tree3);
        t4 = (TextView) rootView.findViewById(R.id.tree4);
        t5 = (TextView) rootView.findViewById(R.id.tree5);
        t6 = (TextView) rootView.findViewById(R.id.tree6);
        data = (TextView) rootView.findViewById(R.id.tree_t);
        data2 = (TextView) rootView.findViewById(R.id.tree_t2);
        data3 = (TextView) rootView.findViewById(R.id.tree_t3);
        data4 = (TextView) rootView.findViewById(R.id.tree_t4);
        data5 = (TextView) rootView.findViewById(R.id.tree_t5);
        data6 = (TextView) rootView.findViewById(R.id.tree_t6);
        i1 = (ImageView) rootView.findViewById(R.id.imageView2);
        i2 = (ImageView) rootView.findViewById(R.id.imageView3);
        i3 = (ImageView) rootView.findViewById(R.id.imageView4);
        i4 = (ImageView) rootView.findViewById(R.id.imageView5);
        i5 = (ImageView) rootView.findViewById(R.id.imageView6);
        i6 = (ImageView) rootView.findViewById(R.id.imageView7);
        i7 = (ImageView) rootView.findViewById(R.id.imageView8);

        fav = (ImageView) rootView.findViewById(R.id.favo);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager m = getFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                t.replace(R.id.container, new MainFavorite());
                t.commit();
            }
        });


        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        herb.setTypeface(font);
        other.setTypeface(font);
        herb2.setTypeface(font);
        other2.setTypeface(font);
        see.setTypeface(font);
        see2.setTypeface(font);
        t.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);
        data.setTypeface(font);
        data2.setTypeface(font);
        data3.setTypeface(font);
        data4.setTypeface(font);
        data5.setTypeface(font);
        data6.setTypeface(font);
    }


    private void setSearch() {
        herb2.setText("ทับทิม");
        other2.setText("เซี๊ยะลิ้ว, พิลา, พิลาขาว, มะก่องแก้ว, มะเก๊าะ, หมากจัง");
        i1.setImageResource(R.drawable.img_ruby);
        see2.setText("ไม้พุ่ม ปลายกิ่งอ่อนโค้งเล็กและมักมีหนามแหลม");
        i2.setImageResource(R.drawable.img_ruby3);
        data.setText("ใบเดี่ยว ออกเป็นคู่ตรงข้ามกัน รูปรีแกมขอบขนาน โคนใบสอบแคบ ปลายใบกว้าง เนื้อใบบางและเป็นมัน");
     //   i3.setImageResource(Integer.parseInt(""));
        data2.setText("");
        i4.setImageResource(R.drawable.img_ruby2);
        data3.setText("ดอกเดี่ยวหรือช่อ ออกตามปลายกิ่ง กลีบดอกสีส้มแดง ร่วงง่าย กลีบรองดอกหนาแข็ง สีส้มแกมเหลือง โคนกลีบเชื่อมติดกันเป็นหลอด ปลายหลอดจักเป็นฟันเลื่อยและโค้งออก กลีบดอกจำนวนเท่าๆ กับกลีบรอง");
        i5.setImageResource(R.drawable.img_ruby4);
        data4.setText("ผลกลมโต ผิวนอกแข็งเป็นมัน สีเขียวอมเหลือง สีแดงอมน้ำตาล หรือสีทับทิม เมื่อแก่จะแตกอ้าออก");
     //   i6.setImageResource(Integer.parseInt(""));
        data5.setText("");
        i7.setImageResource(R.drawable.img_ruby5);
        data6.setText("เมล็ดมีเนื้อเยื่อใสสีขาวอมชมพูหรือสีแดงหุ้มอยู่");
    }

}

