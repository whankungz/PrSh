package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Whankung on 16/1/2560.
 */

public class MainDisease extends android.support.v4.app.Fragment{
    private View rootView;
    private Typeface font;
    private TextView t_H, t_H2, t_H3, t_H4, t_H5, t_H6, t_H7,s,s2,s3,s4,s5,s6,s7,tb;
    private ImageView i_H, i_H2, i_H3, i_H4,i_H5,i_H6,i_H7, star, star2, star3, star4, star5, star6, star7;




    //    service
    public static final String BASE_URL = "http://localhost:8080/HerbServices/webresources/service.entityclass.admin";
    private static final String TAG = "log";
    private ArrayList<String> lottory = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_disease, container, false);
        setView();
        setShow();
        setServices();
        return rootView;
    }

    private void setServices() {
//        DRequest disease = new  DRequest();
//        Call<DModel> calls = Http.getInstance().getDisease().loadJson();
//        calls.enqueue(new Callback<DModel>()
//
//                      {
//                          @Override
//                          public void onResponse(Call<DModel> call, Response<DModel> response) {
//                              tv.setText(response.body().getDataD().get(0).getUsernameAd());
//                              tv.setText(response.body().getDataD().get(1).getPasswordAd());
//                          }
//
//                          @Override
//                          public void onFailure(Call<DModel> call, Throwable t) {
//                              Log.d(TAG, "onFailure:  " + t.toString());
//                          }
//                      });
    }



    private void setView() {
//        tb = (TextView) rootView.findViewById(R.id.toolbar_title);
//        tb.setText("อาการ/โรค");
        s= (TextView) rootView.findViewById(R.id.s);
        s2= (TextView) rootView.findViewById(R.id.s2);
        s3= (TextView) rootView.findViewById(R.id.s3);
        s4= (TextView) rootView.findViewById(R.id.s4);
        s5= (TextView) rootView.findViewById(R.id.s5);
        s6= (TextView) rootView.findViewById(R.id.s6);
        s7= (TextView) rootView.findViewById(R.id.s7);
        t_H = (TextView) rootView.findViewById(R.id.t_H);
        t_H2 = (TextView) rootView.findViewById(R.id.t_H2);
        t_H3 = (TextView) rootView.findViewById(R.id.t_H3);
        t_H4 = (TextView) rootView.findViewById(R.id.t_H4);
        t_H5 = (TextView) rootView.findViewById(R.id.t_H5);
        t_H6 = (TextView) rootView.findViewById(R.id.t_H6);
        t_H7 = (TextView) rootView.findViewById(R.id.t_H7);
        i_H = (ImageView) rootView.findViewById(R.id.i_H);
        i_H2 = (ImageView) rootView.findViewById(R.id.i_H2);
        i_H3 = (ImageView) rootView.findViewById(R.id.i_H3);
        i_H4 = (ImageView) rootView.findViewById(R.id.i_H4);
        i_H5 = (ImageView) rootView.findViewById(R.id.i_H5);
        i_H6 = (ImageView) rootView.findViewById(R.id.i_H6);
        i_H7 = (ImageView) rootView.findViewById(R.id.i_H7);
        star = (ImageView) rootView.findViewById(R.id.star);
        star2 = (ImageView) rootView.findViewById(R.id.star2);
        star3 = (ImageView) rootView.findViewById(R.id.star3);
        star4 = (ImageView) rootView.findViewById(R.id.star4);
        star5 = (ImageView) rootView.findViewById(R.id.star5);
        star6 = (ImageView) rootView.findViewById(R.id.star6);
        star7 = (ImageView) rootView.findViewById(R.id.star7);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        t_H.setTypeface(font);
        t_H2.setTypeface(font);
        t_H3.setTypeface(font);
        t_H4.setTypeface(font);
        t_H5.setTypeface(font);
        t_H6.setTypeface(font);
        t_H7.setTypeface(font);
        s.setTypeface(font);
        s2.setTypeface(font);
        s3.setTypeface(font);
        s4.setTypeface(font);
        s5.setTypeface(font);
        s6.setTypeface(font);
        s7.setTypeface(font);
//        tb.setTypeface(font);

        final EditText searchD = (EditText)rootView.findViewById(R.id.searchD);

        searchD.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                searchD.setImeOptions(EditorInfo.IME_ACTION_DONE);
                String strMsg = "ปวดฟัน";
                if (s.toString().equals(strMsg)) {
                    searchD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                            if (actionId == EditorInfo.IME_ACTION_DONE) {

                                FragmentManager m = getFragmentManager();
                                FragmentTransaction t = m.beginTransaction();
                                t.replace(R.id.container, new  SearchDisease());
                                t.commit();

                            }
                            return false;
                        }
                    });
                }
            }
        });
    }
//        searchD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//                    FragmentManager m =getFragmentManager();
//                    FragmentTransaction t =m.beginTransaction();
//                    t.replace(R.id.frgMain, new SearchDisease());
//                    t.commit();

//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.frgMain, new SearchHerb());
//                    transaction.commit();
//                    SearchHerb();
//                    return; true;
//                }
//                return false;
//            }
//        });
//    }

    private void setShow() {
        i_H.setImageResource(R.drawable.ic_dise);
        t_H.setText("ไข้เลือดออก");
        i_H2.setImageResource(R.drawable.ic_dise);
        t_H2.setText("ไข้หวัดใหญ่");
        i_H3.setImageResource(R.drawable.ic_dise);
        t_H3.setText("ท้องเสีย");
        i_H4.setImageResource(R.drawable.ic_dise);
        t_H4.setText("ปวดฟัน");
        i_H5.setImageResource(R.drawable.ic_dise);
        t_H5.setText("ตาแดง");
        i_H6.setImageResource(R.drawable.ic_dise);
        t_H6.setText("เหน็บชา");
        i_H7.setImageResource(R.drawable.ic_dise);
        t_H7.setText("กระเพาะอาหารอักเสบ");
        star.setImageResource(R.drawable.ic_star2);
        star2.setImageResource(R.drawable.ic_star2);
        star3.setImageResource(R.drawable.ic_star2);
        star4.setImageResource(R.drawable.ic_star2);
        star5.setImageResource(R.drawable.ic_star2);
        star6.setImageResource(R.drawable.ic_star2);
        star7.setImageResource(R.drawable.ic_star2);
    }
}
