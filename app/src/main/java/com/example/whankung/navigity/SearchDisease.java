package com.example.whankung.navigity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whankung.navigity.adapter.AppState;
import com.example.whankung.navigity.services.Disease.DRequest;
import com.example.whankung.navigity.services.Http;
import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storable;
import com.sromku.simple.storage.Storage;
import com.sromku.simple.storage.helpers.OrderType;


import java.io.File;
import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Whankung on 22/1/2560.
 */

public class SearchDisease extends Fragment {
    private View rootView;
    private TabLayout tabLayout;
    private Typeface font;
    private TextView t, t2, t3, t4, t5, t6, t7, t8, t9, nm, un, date;
    private RatingBar rata;
    private RelativeLayout rat;
    private String title;
    //        service
    public static final String BASE_URL = "http://192.168.181.103:8080/Servies/webresources/";
    private static final String TAG = "log";

    public SearchDisease(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_disease, container, false);
        AppState.getSingleInstance().getFirstOpenApp();

        setRating();
        setView();
        setSearch();

        setServices();

        AppState.getSingleInstance().setFirstOpenApp(false);


        return rootView;
    }


    private void setView() {
//        date = (TextView) rootView.findViewById(R.id.date);
//        nm = (TextView) rootView.findViewById(R.id.nameMe);
//        un = (TextView) rootView.findViewById(R.id.Uname);
        t = (TextView) rootView.findViewById(R.id.nameD);
        t2 = (TextView) rootView.findViewById(R.id.nameDdata);
        t3 = (TextView) rootView.findViewById(R.id.nameOther);
        t4 = (TextView) rootView.findViewById(R.id.nameOtherda);
        t5 = (TextView) rootView.findViewById(R.id.namewhy);
        t6 = (TextView) rootView.findViewById(R.id.namewhyda);
        t7 = (TextView) rootView.findViewById(R.id.namehow);
        t8 = (TextView) rootView.findViewById(R.id.namehowda);
        t9 = (TextView) rootView.findViewById(R.id.submit);
        rata = (RatingBar) rootView.findViewById(R.id.rat);
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        t.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);
        t7.setTypeface(font);
        t8.setTypeface(font);
        t9.setTypeface(font);
//        nm.setTypeface(font);
//        un.setTypeface(font);
//        date.setTypeface(font);
    }

    private void setSearch() {
//        t2.setText("ปวดฟัน");
//        t4.setText("กานพลู ดาวเรือง เมล็ดผักชี ผักบุ้งนา มะระ ว่านหางจระเข้ น้ำมันกระเทียม ใบชา เมล็ดกุยช่าย");
//        t6.setText("เวลากินของเย็น ของหวาน หรือเมื่อตอนเคี้ยวอาหารและอาการเหล่านี้จะหายไปเมื่อหยุดกินอาหารดังกล่าวภายในไม่กี่นาึ่งลักษณะของอาการปวดเช่นนี้มักเกิดจากฟันผุหรือฟันบิ่นจนถึงเนื้อฟันชั้นในจึงทำให้ความเย็นหรือแรงจากการเคี้ยวอาหารมีโอกาสกระตุ้นเส้นประสาทที่อยู่ในโพรงประสาทใต้เนื้อฟันได้มากกว่าปกติ จึงทำให้เกิดความรู้สึกเสียวฟันทุกครั้งเมื่อกินอาหาร ส่วนอาการปวดฟันอีกประเภทหนึ่ง ซึ่งจะมีความรุนแรงกว่า คือ การปวดเป็นจังหวะ ตุ้บ ๆ ซึ่งอาจปวดโดยอยู่เฉย ๆ ก็ปวด หรืออาจปวดมากขึ้นเวลากินของเย็นหรือของร้อน หรือเวลาเคี้ยวอาหาร และอาการปวดนี้จะไม่หายไปแม้จะเลิกกินอาหารเหล่านี้แล้วก็ตาม");
//        t8.setText("หลีกเลี่ยงอาหารประเภทดังกล่าวพร้อมกับการรับประทานยาแก้ปวด");


    }

    private void setRating() {

        rat = (RelativeLayout) rootView.findViewById(R.id.relarat);
        if (AppState.getSingleInstance().isRating(true)) {
            rat.setVisibility(View.VISIBLE);
        } else if (AppState.getSingleInstance().isRating(false)) {
            rat.setVisibility(View.GONE);
        }
    }

    private void setServices() {
        final Storage storage = SimpleStorage.getExternalStorage();
        final DRequest disease = new DRequest();
        Call<List<DRequest>> calls = Http.getInstance().getDisease().loadJson();
        calls.enqueue(new Callback<List<DRequest>>()

        {
            @Override
            public void onResponse(Call<List<DRequest>> call, Response<List<DRequest>> response) {

                if (response.isSuccessful()) {
                    List<DRequest> disease = response.body();
                   // List<File> disease = storage.getNestedFiles("MyDirName");
//                    Storage storage = null;
//                    if (SimpleStorage.isExternalStorageWritable()) {
//                        storage = SimpleStorage.getExternalStorage();
//                    } else {
//                        storage = SimpleStorage.getInternalStorage(getContext());
//                    }

                    // Can iterate through list and grab Getters from POJO
                    for (DRequest d : disease) {

                        List<File> files = storage.getNestedFiles("d");

//                        storage.createDirectory("MyDirName", true);
                        // storage.createFile("MyDirName", "fileName", d.getDiseaseName());


                        //   storage.createDirectory("MyDirName/MySubDirectory");

//                storage.createFile("MyDirName", "fileName", "some content of the file");


                        if (d.getDiseaseName().equals(title)) {


                            //String content = storage.readTextFile("MyDirName", "fileName");
                            Log.d(TAG, "qqq" + d.getSymptom());
//t2.setText(storage);
//                            t4.setText(d.getHerb());
//                            t6.setText(d.getSymptom());
//                            t8.setText(d.getHowtoRelief());
                            t2.setText(d.getDiseaseName());
                            t4.setText(d.getHerb());
                            t6.setText(d.getSymptom());
                            t8.setText(d.getHowtoRelief());
                        }

                    }

                } else {
                    // Error response...
                }
//                t2.setText(response.body().getHerb().get(0));
//                t4.setText(response.body().getDiseaseName().get(0));

//                t2.setText(response.body().getPasswordAd());
//                t4.setText(response.body().getUsernameAd());


            }

            @Override
            public void onFailure(Call<List<DRequest>> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });
    }

}
