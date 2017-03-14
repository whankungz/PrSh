package com.example.whankung.navigity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;


import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Whankung on 22/1/2560.
 */

public class SearchHerb extends android.support.v4.app.Fragment {
    private View rootView;
    private TabLayout tabLayout;
    private RatingBar rat;
    private RelativeLayout ment;
    private String title;
    private String titleid;

    public SearchHerb(String titleid, String title) {
        this.title = title;
        this.titleid = titleid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_herb, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        viewPager.setAdapter(new SampleFragmentPagerAdapterHerb(getChildFragmentManager(),
                getFragments()));
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ment = (RelativeLayout) rootView.findViewById(R.id.relament);
                rat = (RatingBar) rootView.findViewById(R.id.rat);
                if (AppState.getSingleInstance().isRating(true)) {
                    rat.setVisibility(VISIBLE);
                    ment.setVisibility(VISIBLE);
                } else if (AppState.getSingleInstance().isRating(false)) {
                    rat.setVisibility(GONE);
                    ment.setVisibility(GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        เปลี่ยน font tab
        SampleFragmentPagerAdapterHerb.applyFontedTab(getActivity().getApplicationContext(), viewPager, tabLayout);

    }


    private List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(new GeneralHerbFragment(title,titleid));
        fList.add(new HowtoHerbFragment(title,titleid));
        fList.add(new ResearchHerbFragment(title,titleid));
        return fList;
    }

}
