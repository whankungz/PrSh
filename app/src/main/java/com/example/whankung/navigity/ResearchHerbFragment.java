package com.example.whankung.navigity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.whankung.navigity.services.Herb.HRequest;
import com.example.whankung.navigity.services.Http;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Whankung on 22/1/2560.
 */
public class ResearchHerbFragment extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private TextView re, fromre, link, flink;
    public static final String BASE_URL = "http://192.168.181.1:8080/Servies/webresources/";
    private static final String TAG = "log";
    private String title;
    private String titleid;


    public ResearchHerbFragment(String titleid, String title) {
        this.title = title;
        this.titleid=titleid;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.research_herb, container, false);
        setView();
       // setData();
       setServices();
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

    private void setServices() {
        Call<List<HRequest>> call = Http.getInstance().getHerbre().loadJson();
        call.enqueue(new Callback<List<HRequest>>() {
            @Override
            public void onResponse(Call<List<HRequest>> call, Response<List<HRequest>> response) {

                if (response.isSuccessful()) {
                    List<HRequest> herb = response.body();

                    // Can iterate through list and grab Getters from POJO
                    for (HRequest h : herb) {

                        if (h.getHerbIdRe().equals(titleid)) {
//                            try {
//
//                                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getContext().openFileOutput("d.txt", Context.MODE_PRIVATE));
//
//
//
//                                outputStreamWriter.write(h.getResearchName());
//                                outputStreamWriter.write(h.getCreditRe());
//
//                                outputStreamWriter.close();
//
//                            } catch (IOException e) {
//                                Log.e("Exception", "File write failed: " + e.toString());
//                            }
                            link.setText(h.getResearchName());
                            flink.setText(h.getCreditRe());

                        }

                    }

                } else {
                }
            }

            @Override
            public void onFailure(Call<List<HRequest>> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });
    }

    private void setData() {
        link.setText("สารสกัดละลายน้ำต้านจุลชีพจากเปลือกผลทับทิม:องค์ประกอบในยาบ้วนปากฆ่าเชื้อ");
        flink.setText("คุณมาลิน จุลศิริ และคณะ");
    }
}
