package com.example.whankung.navigity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by Whankung on 16/1/2560.
 */

public class MainFavorite extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private TextView fav;
    ArrayAdapter<String> adapter;
    ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_favorite, container, false);
        setView();
        return rootView;
    }

    private void setView() {
        fav = (TextView) rootView.findViewById(R.id.textF);
//
//        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
//        t_H.setTypeface(font);
//        t_H2.setTypeface(font);
////        tb.setTypeface(font);
////        t_H3.setTypeface(font);
////        t_H4.setTypeface(font);

        lv = (ListView) rootView.findViewById(R.id.list_view);
        //   lv.setAdapter(AppState.getSingleInstance().getDataHerb());

//        final String[] herbs = new String[]{"ทับทิม", "มะนาว", "มะเขือ",
//                "ชมพู่", "กา", "ว่านหาง", "กระชายดำ", "ขิง",
//                "ตะไคร้หอม", "พริก"};


        final String[] herbs = new String[]{AppState.getSingleInstance().getDataHerb()};
        if (AppState.getSingleInstance().isDataHerb2(true)) {
          //  fav.setText(AppState.getSingleInstance().getNameH());
//            fav.setText(AppState.getSingleInstance().getNamePhama());
            adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_item, R.id.product_name, herbs);
            lv.setAdapter(adapter);
            lv.getAdapter().getCount();
            lv.setTextFilterEnabled(true);
//            fav.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    FragmentManager m = getFragmentManager();
//                    FragmentTransaction t = m.beginTransaction();
//                    t.replace(R.id.container, new SearchHerb());
//                    t.commit();
//
//                }
//            });
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    FragmentManager m = getFragmentManager();
                    FragmentTransaction t = m.beginTransaction();
                    t.replace(R.id.container, new SearchHerb());
                    t.commit();

                }
            });
        }
    }
}
