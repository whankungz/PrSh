package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 31/1/2560.
 */
public class MainFood  extends AppCompatActivity {

    private Typeface font;
    TextView tv, im, im2, im3, im4, im5,im6,p,p2,p3,p4,p5,p6;
    ImageView img, i, i2, i3, i4, i5, i6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stucture_food);
        ImageView img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือกเภสัช
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });
        setView();
        setData();


    }

    private void setView() {
        tv = (TextView) findViewById(R.id.textView);
        img = (ImageView) findViewById(R.id.action_login);
        i = (ImageView) findViewById(R.id.img);
        i2 = (ImageView) findViewById(R.id.img2);
        i3 = (ImageView) findViewById(R.id.img3);
        i4 = (ImageView) findViewById(R.id.img4);

        im = (TextView) findViewById(R.id.im);
        im2 = (TextView) findViewById(R.id.im2);
        im3 = (TextView) findViewById(R.id.im3);
        im4 = (TextView) findViewById(R.id.im4);

        p = (TextView) findViewById(R.id.p);
        p2 = (TextView) findViewById(R.id.p2);
        p3 = (TextView) findViewById(R.id.p3);
        p4 = (TextView)findViewById(R.id.p4);


//        เปลี่ยนfont
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        im.setTypeface(font);
        im2.setTypeface(font);
        im3.setTypeface(font);
        im4.setTypeface(font);

        p.setTypeface(font);
        p2.setTypeface(font);
        p3.setTypeface(font);
        p4.setTypeface(font);


        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });


        i.setClickable(true);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataFood.class);
                startActivity(intent);
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
