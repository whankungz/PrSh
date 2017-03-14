package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Whankung on 22/1/2560.
 */
public class ResearchHerbFragment extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private TextView re, fromre, link, flink;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.research_herb, container, false);
        setView();
        setData();

        return rootView;
    }


    private void setView() {
        re = (TextView) rootView.findViewById(R.id.research);
        fromre = (TextView) rootView.findViewById(R.id.fromre);
        link = (TextView) rootView.findViewById(R.id.link);
        flink = (TextView) rootView.findViewById(R.id.fromlink);
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        re.setTypeface(font);
        fromre.setTypeface(font);
        link.setTypeface(font);
        flink.setTypeface(font);
    }

    private void setData() {
        link.setText("สารสกัดละลายน้ำต้านจุลชีพจากเปลือกผลทับทิม:องค์ประกอบในยาบ้วนปากฆ่าเชื้อ");
        flink.setText("คุณมาลิน จุลศิริ และคณะ");
    }
}
