package com.example.whankung.navigity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Whankung on 13/3/2560.
 */
public class DataInfo extends Fragment {
    private View rootView;
    private Typeface font;
    private TextView tvI, nameI, namefI, frI, submitI, nm2, un2, date2;
    private ImageView i_Info, img;
    private RelativeLayout rat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.data_info, container, false);
        setView();
        setData();

        rat = (RelativeLayout) rootView.findViewById(R.id.relarat);
        if (AppState.getSingleInstance().isRating(true)) {
            rat.setVisibility(View.VISIBLE);
        } else if (AppState.getSingleInstance().isRating(false)) {
            rat.setVisibility(View.GONE);
        }

        return rootView;
    }

    private void setView() {
//        date2 = (TextView) findViewById(R.id.date2);
//        nm2 = (TextView) findViewById(R.id.nameMe2);
//        un2 = (TextView) findViewById(R.id.Uname2);

        nameI = (TextView) rootView.findViewById(R.id.nameI);
        namefI = (TextView) rootView.findViewById(R.id.namefI);
        frI = (TextView) rootView.findViewById(R.id.frI);
        submitI = (TextView) rootView.findViewById(R.id.submitI);
        i_Info = (ImageView) rootView.findViewById(R.id.i_Info);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        nameI.setTypeface(font);
        namefI.setTypeface(font);
        frI.setTypeface(font);
        submitI.setTypeface(font);
//        nm2.setTypeface(font);
//        un2.setTypeface(font);
//        date2.setTypeface(font);

//        img = (ImageView) rootView.findViewById(R.id.action_login);
//        img.setVisibility(View.VISIBLE);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(getActivity(), MainInfo.class);
//                startActivity(intent);
//
//            }
//        });
    }

    private void setData() {
        i_Info.setImageResource(R.drawable.img_in_big);
        nameI.setText("7 ข้อที่ชาวไร่ยาสูบ ยังได้รับ-ทำได้");
        frI.setText("http://www.thaihealth.or.th/Infographic/detail/");
    }
}
