package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainFavorite extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private TextView t_H, t_H2, t_H3, t_H4, p, p2, p3, p4, s, s2, s3, s4,tb;
    private ImageView i_H, i_H2, i_H3, i_H4, star, star2, star3, star4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_favorite, container, false);
        setView();
        setShow();
        AppState.getSingleInstance().getDataHerb();
        return rootView;
    }

    private void setView() {
//        tb = (TextView) rootView.findViewById(R.id.toolbar_title);
//        tb.setText("รายการโปรด");
        t_H = (TextView) rootView.findViewById(R.id.t_H);
        t_H2 = (TextView) rootView.findViewById(R.id.t_H2);
//        t_H3 = (TextView) rootView.findViewById(R.id.t_H3);
//        t_H4 = (TextView) rootView.findViewById(R.id.t_H4);
        i_H = (ImageView) rootView.findViewById(R.id.i_H);
        i_H2 = (ImageView) rootView.findViewById(R.id.i_H2);
//        i_H3 = (ImageView) rootView.findViewById(R.id.i_H3);
//        i_H4 = (ImageView) rootView.findViewById(R.id.i_H4);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        t_H.setTypeface(font);
        t_H2.setTypeface(font);
//        tb.setTypeface(font);
//        t_H3.setTypeface(font);
//        t_H4.setTypeface(font);

    }

    private void setShow() {
        i_H.setImageResource(R.drawable.img_grass2);
        t_H.setText("ตะไคร้");
        i_H2.setImageResource(R.drawable.img_ruby);
        t_H2.setText("ทับทิม");
//        i_H3.setImageResource(R.drawable.img_lemon2);
//        t_H3.setText("มะนาว");
//        i_H4.setImageResource(R.drawable.img_fa);
//        t_H4.setText("ฟ้าทะลายโจร");

    }
}
