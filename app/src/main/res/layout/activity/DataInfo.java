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
 * Created by Whankung on 24/1/2560.
 */

public class DataInfo extends AppCompatActivity {
    private View rootView;
    private Typeface font;
    private TextView tvI, nameI, namefI, frI, submitI, nm2, un2, date2;
    private ImageView i_Info,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_info);
        setView();
        setData();

    }

    private void setView() {
//        date2 = (TextView) findViewById(R.id.date2);
//        nm2 = (TextView) findViewById(R.id.nameMe2);
//        un2 = (TextView) findViewById(R.id.Uname2);
        tvI = (TextView) findViewById(R.id.textI);
        nameI = (TextView) findViewById(R.id.nameI);
        namefI = (TextView)findViewById(R.id.namefI);
        frI = (TextView) findViewById(R.id.frI);
        submitI = (TextView) findViewById(R.id.submitI);
        i_Info = (ImageView) findViewById(R.id.i_Info);

        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tvI.setTypeface(font);
        nameI.setTypeface(font);
        namefI.setTypeface(font);
        frI.setTypeface(font);
        submitI.setTypeface(font);
//        nm2.setTypeface(font);
//        un2.setTypeface(font);
//        date2.setTypeface(font);

        img= (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.MainInfo.class);
                startActivity(intent);

            }
        });
    }

    private void setData() {
        i_Info.setImageResource(R.drawable.img_in_big);
        nameI.setText("7 ข้อที่ชาวไร่ยาสูบ ยังได้รับ-ทำได้");
        frI.setText("http://www.thaihealth.or.th/Infographic/detail/");
    }
}
