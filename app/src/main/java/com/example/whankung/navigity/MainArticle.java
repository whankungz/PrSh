package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.navigity.services.Article.ArRequest;
import com.example.whankung.navigity.services.Http;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainArticle extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private ImageView i1, i2, i3, i4, i5, star, star2, star3, star4,star5;
    private TextView im, im2,im3,im4,im5,p,p2,p3,p4,p5,tb,s,s2,s3,s4,s5;
    public static final String BASE_URL = "http://192.168.181.50:8080/Servies/webresources/";
    private static final String TAG = "log";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_article, container, false);
        setView();
        setArticle();

        return rootView;
    }


    private void setView() {
//        tb = (TextView) rootView.findViewById(R.id.toolbar_title);
//        tb.setText("บทความ");
        s= (TextView) rootView.findViewById(R.id.s);
        s2= (TextView) rootView.findViewById(R.id.s2);
        s3= (TextView) rootView.findViewById(R.id.s3);
        s4= (TextView) rootView.findViewById(R.id.s4);
        s5= (TextView) rootView.findViewById(R.id.s5);
        im = (TextView) rootView.findViewById(R.id.im);
        im2 = (TextView) rootView.findViewById(R.id.im2);
        im3 = (TextView) rootView.findViewById(R.id.im3);
        im4 = (TextView) rootView.findViewById(R.id.im4);
        im5 = (TextView) rootView.findViewById(R.id.im5);
        p = (TextView) rootView.findViewById(R.id.p);
        p2 = (TextView) rootView.findViewById(R.id.p2);
        p3 = (TextView) rootView.findViewById(R.id.p3);
        p4 = (TextView) rootView.findViewById(R.id.p4);
        p5 = (TextView) rootView.findViewById(R.id.p5);

        star = (ImageView) rootView.findViewById(R.id.star);
        star2 = (ImageView) rootView.findViewById(R.id.star2);
        star3 = (ImageView) rootView.findViewById(R.id.star3);
        star4 = (ImageView) rootView.findViewById(R.id.star4);
        star5 = (ImageView) rootView.findViewById(R.id.star5);


        i1 = (ImageView) rootView.findViewById(R.id.imageView2);
        i2 = (ImageView) rootView.findViewById(R.id.imageView3);
        i3 = (ImageView) rootView.findViewById(R.id.imageView4);
        i4 = (ImageView) rootView.findViewById(R.id.imageView5);
        i5 = (ImageView) rootView.findViewById(R.id.imageView6);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        im.setTypeface(font);
        im2.setTypeface(font);
        im3.setTypeface(font);
        im4.setTypeface(font);
        im5.setTypeface(font);
        p.setTypeface(font);
        p2.setTypeface(font);
        p3.setTypeface(font);
        p4.setTypeface(font);
        p5.setTypeface(font);
//        tb.setTypeface(font);

        s.setTypeface(font);
        s2.setTypeface(font);
        s3.setTypeface(font);
        s4.setTypeface(font);
        s5.setTypeface(font);


        i1.setClickable(true);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager m = getFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                String a=null;
                t.replace(R.id.container, new DataArticle(a));
                t.commit();
            }
        });


        i2.setClickable(true);
//        i2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager m = getFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                t.replace(R.id.container, new DataArticle2());
//                t.commit();
//            }
//        });

    }


    private void setArticle() {

        Call<List<ArRequest>> calls = Http.getInstance().getArticle().loadJson();
        calls.enqueue(new Callback<List<ArRequest>>()

        {
            @Override
            public void onResponse(Call<List<ArRequest>> call, Response<List<ArRequest>> response) {

                if (response.isSuccessful()) {
                    List<ArRequest> article = response.body();

                    for (ArRequest a : article) {
                      if(a.getArticleID().equals("1")){
                          im.setText(a.getArticleName());
                      }else if(a.getArticleID().equals("2")){
                          im2.setText(a.getArticleName());
                      } else if(a.getArticleID().equals("3")){
                        im3.setText(a.getArticleName());
                    } else if(a.getArticleID().equals("4")){
                        im4.setText(a.getArticleName());
                    } else if(a.getArticleID().equals("5")){
                        im5.setText(a.getArticleName());
                    }
                    }

                } else {
                }

            }

            @Override
            public void onFailure(Call<List<ArRequest>> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });
        star.setImageResource(R.drawable.ic_star2);
        star2.setImageResource(R.drawable.ic_star2);
        star3.setImageResource(R.drawable.ic_star2);
        star4.setImageResource(R.drawable.ic_star2);
        star5.setImageResource(R.drawable.ic_star2);

        i1.setImageResource(R.drawable.img_a);
//        im.setText("‘โรคอ้วน’ มหันตภัยมืดมนุษย์เมือง");
        i2.setImageResource(R.drawable.img_a2);
//        im2.setText("ส้มซ่า และ ส้มสา");
        i3.setImageResource(R.drawable.img_a5);
//        im3.setText("คอเรสเตอรอลในไข่ไก่");
        i4.setImageResource(R.drawable.img_a4);
//        im4.setText("‘กล้วย’อาหารสุขภาพทุกเพศทุกวัย");
        i5.setImageResource(R.drawable.img_a3);
//        im5.setText("กินยาเยอะ ทำให้ตับไตพังจริงหรือ?");
    }



}
