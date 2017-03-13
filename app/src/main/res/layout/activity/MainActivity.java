package com.example.whankung.socialherb.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.Start.MyPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends FragmentActivity {
    MyPagerAdapter adapter;
    ViewPager pager;
    CirclePageIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyPagerAdapter(getSupportFragmentManager());

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

    }


    public void setSelect(int position) {

        pager.setCurrentItem(position);
    }

}
