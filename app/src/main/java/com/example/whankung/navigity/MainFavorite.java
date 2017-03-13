package com.example.whankung.navigity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainFavorite extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private TextView t_H, t_H2, t_H3, t_H4, p, p2, p3, p4, s, s2, s3, s4, tb;
    ArrayAdapter<String> adapter;
    ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_favorite, container, false);
        setView();
//       setShow();

        return rootView;
    }

    private void setView() {
////        tb = (TextView) rootView.findViewById(R.id.toolbar_title);
////        tb.setText("รายการโปรด");
//        t_H = (TextView) rootView.findViewById(R.id.t_H);
//        t_H2 = (TextView) rootView.findViewById(R.id.t_H2);
////        t_H3 = (TextView) rootView.findViewById(R.id.t_H3);
////        t_H4 = (TextView) rootView.findViewById(R.id.t_H4);
//        i_H = (ImageView) rootView.findViewById(R.id.i_H);
//        i_H2 = (ImageView) rootView.findViewById(R.id.i_H2);
////        i_H3 = (ImageView) rootView.findViewById(R.id.i_H3);
////        i_H4 = (ImageView) rootView.findViewById(R.id.i_H4);
//
//        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
//        t_H.setTypeface(font);
//        t_H2.setTypeface(font);
////        tb.setTypeface(font);
////        t_H3.setTypeface(font);
////        t_H4.setTypeface(font);


        if (AppState.getSingleInstance().isDataHerb2(true)) {
            final String[] herbs = new String[]{AppState.getSingleInstance().getDataHerb()};
            lv = (ListView) rootView.findViewById(R.id.list_view);
            adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_item, R.id.product_name, herbs);
            //   lv.setAdapter(AppState.getSingleInstance().getDataHerb());
            lv.setAdapter(adapter);
            lv.getAdapter().getCount();
            lv.setTextFilterEnabled(true);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    FragmentManager m = getFragmentManager();
                    FragmentTransaction t = m.beginTransaction();
                    t.replace(R.id.container, new SearchHerb());
                    t.commit();

               //    Toast.makeText(getContext(), "CLICKED", Toast.LENGTH_SHORT).show();
//                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(search.getWindowToken(), 0);
                }
            });

        }

    }

    private void setShow() {
//        i_H.setImageResource(R.drawable.img_grass2);
//        t_H.setText("ตะไคร้");
//        i_H2.setImageResource(R.drawable.img_ruby);
        // t_H2.setText((CharSequence) AppState.getSingleInstance().getData());
//        i_H3.setImageResource(R.drawable.img_lemon2);
//        t_H3.setText("มะนาว");
//        i_H4.setImageResource(R.drawable.img_fa);
//        t_H4.setText("ฟ้าทะลายโจร");

    }
}
