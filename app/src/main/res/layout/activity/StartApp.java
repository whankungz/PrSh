package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 16/1/2560.
 */

public class StartApp extends Fragment {
    private View rootView;
    private Typeface font;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_start, container, false);
        setView();
//        setBottomBar();
        return rootView;
    }

    private void setView() {

//        ImageView image = (ImageView) rootView.findViewById(R.id.imageView2);
//        image.setImageResource(R.drawable.ic_tri);


        TextView tv = (TextView) rootView.findViewById(R.id.textView);
        TextView tv2 = (TextView) rootView.findViewById(R.id.textView2);
        TextView social = (TextView) rootView.findViewById(R.id.social);
        TextView th = (TextView) rootView.findViewById(R.id.TH);


//        เปลี่ยนfont
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        tv2.setTypeface(font);
        social.setTypeface(font);
        th.setTypeface(font);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Intent i = new Intent(getActivity(), Menu.class);
//                startActivity(i);
//                getActivity().finish();
//                Intent intent = new Intent(getActivity(), Menu.class);
//                startActivity(intent);

                Intent intent = new Intent(getActivity(), com.example.whankung.socialherb.activity.Menu.class);
                startActivity(intent);
                getActivity().finish();


            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), com.example.whankung.socialherb.activity.Login.class);
                startActivity(intent);
                getActivity().finish();


            }
        });
    }

//    private void setBottomBar() {
//        final BottomBar bottomBar = (BottomBar) rootView.findViewById(R.id.bottomBar);
//        final TextView tv = (TextView) rootView.findViewById(R.id.toolbar_title);
//
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//
////            ImageView img = (ImageView) findViewById(R.id.action);
//
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//
//                if (tabId == R.id.tab_herb) {
//
//                    // Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getActivity(), MainHerb.class);
//                    startActivity(intent);
//                    getActivity().finish();
//                    tv.setText("สมุนไพร");
//                    tv.setTextColor(Color.parseColor("#ffffff"));
//                    tv.setTypeface(font);
//                    //   img.setVisibility(View.INVISIBLE);
//
//                } else if (tabId == R.id.tab_disease) {
//                    Intent intent2 = new Intent(getActivity(), MainDisease.class);
//                    startActivity(intent2);
//                    getActivity().finish();
//                    tv.setText("อาการ/โรค");
////                    tv.setTextColor(Color.parseColor("#B22222"));
//                    // img.setVisibility(View.INVISIBLE);
//                } else if (tabId == R.id.tab_aritcle) {
//                    Intent intent3 = new Intent(getActivity(), MainArticle.class);
//                    startActivity(intent3);
//                    getActivity().finish();
//                    tv.setText("บทความ");
////                    tv.setTextColor(Color.parseColor("#20B2AA"));
//                    //  img.setVisibility(View.INVISIBLE);
//                } else if (tabId == R.id.tab_favorite) {
//                    Intent intent4 = new Intent(getActivity(), MainFavorite.class);
//                    startActivity(intent4);
//                    getActivity().finish();
//                    tv.setText("รายการโปรด");
////                    tv.setTextColor(Color.parseColor("#20B2AA"));
//                    // img.setVisibility(View.INVISIBLE);
//                }
//            }
//
//
//        });
//
//    }
//

}
