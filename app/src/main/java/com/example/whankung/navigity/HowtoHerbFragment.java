package com.example.whankung.navigity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whankung.navigity.adapter.AppState;
import com.example.whankung.navigity.services.Herb.HRequest;
import com.example.whankung.navigity.services.Http;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.whankung.navigity.Register.*;


/**
 * Created by Whankung on 22/1/2560.
 */
public class HowtoHerbFragment extends android.support.v4.app.Fragment {
    private Typeface font;
    private View rootView;
    private TextView p, pdata, h, hdata, t, tdata, sub, nm, un, date,post;
    private RatingBar rat;
    private EditText ment;
    private Register register;
    public static final String BASE_URL = "http://192.168.181.1:8080/Servies/webresources/";
    private static final String TAG = "log";
    private String title,cMent;
    private String titleid;
    private ConnectionClass connectionClass;


    public HowtoHerbFragment(String titleid,String title) {
        this.title = title;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.howto_herb, container, false);
        connectionClass = new ConnectionClass();
        setView();
     //   setData();
//        setRating();
        setServices();
        return rootView;
    }







    private void setRating() {
//        rat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//
//                String rateValue = String.valueOf(rat.getRating());
//                System.out.println("Rate for Module is"+rateValue);
//            }
//        });
    }

    private void setView() {
        rat = (RatingBar) rootView.findViewById(R.id.rat);
        date = (TextView) rootView.findViewById(R.id.date);
        nm = (TextView) rootView.findViewById(R.id.nameMe);
        un = (TextView) rootView.findViewById(R.id.Uname);
        p = (TextView) rootView.findViewById(R.id.proper);
        pdata = (TextView) rootView.findViewById(R.id.properdata);
        h = (TextView) rootView.findViewById(R.id.how);
        hdata = (TextView) rootView.findViewById(R.id.howdata);
        t = (TextView) rootView.findViewById(R.id.t);
        tdata = (TextView) rootView.findViewById(R.id.tdata);
        ment = (EditText) rootView.findViewById(R.id.ment);
        sub = (TextView) rootView.findViewById(R.id.submit);
        post = (TextView) rootView.findViewById(R.id.post);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        p.setTypeface(font);
        pdata.setTypeface(font);
        h.setTypeface(font);
        hdata.setTypeface(font);
        t.setTypeface(font);
        tdata.setTypeface(font);
        ment.setTypeface(font);
        sub.setTypeface(font);
        nm.setTypeface(font);
        un.setTypeface(font);
        date.setTypeface(font);
        rat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float touchPositionX = event.getX();
                    float width = rat.getWidth();
                    float starsf = (touchPositionX / width) * 5.0f;
                    int stars = (int)starsf + 1;
                    rat.setRating(stars);

                    Toast.makeText(getActivity(), String.valueOf("test"), Toast.LENGTH_SHORT).show();
                    v.setPressed(false);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setPressed(true);
                }

                if (event.getAction() == MotionEvent.ACTION_CANCEL) {
                    v.setPressed(false);
                }




                return true;
            }});

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cMent = ment.getText().toString();
                if(ment!=null){
                    post.setText(cMent);

                }


            }
        });


//        sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Connection con = connectionClass.connection();
//                String ments = ment.getText().toString();
//
//                Statement statement = getStatement((Connection) con);
//
//                try {
//                    ResultSet rs =statement.executeQuery("SELECT * FROM HerbComment");
//                    rs.next();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    Object o = null;
//
//                    ResultSet rs = statement.executeQuery("INSERT INTO HerbComment "
//                            + "  VALUES ('1','hhh','hhhhh','uuuu','123456')");
//                    rs.close();
//                    statement.close();
//
//                } catch (SQLException e) {
//
//                    e.printStackTrace();
//
//                }
//
//
//
//
//                Intent intent = new Intent(getActivity(), GeneralHerbFragment.class);
//                startActivity(intent);
//
//
//            }
//        });

    }
    private void setServices() {
        Call<List<HRequest>> call = Http.getInstance().getHerb().loadJson();
//        Call<List<HRequest>> call2 = Http.getInstance().getHerbimg().loadJson();
        //  call = Http.getInstance().getHerbre().loadJson();
        call.enqueue(new Callback<List<HRequest>>()
        {
            @Override
            public void onResponse(Call<List<HRequest>> call, Response<List<HRequest>> response) {

                if (response.isSuccessful()) {
                    List<HRequest> herb = response.body();

                    // Can iterate through list and grab Getters from POJO
                    for (HRequest h : herb) {

                        if (h.getHerbName().equals(title)) {
                            Log.d(TAG,"oooooooooooooo"+h.getHowto());
                            hdata.setText(h.getHowto());
                            tdata.setText(h.getWarning());
                            //  data.setText(h.getLeaf());
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
        pdata.setText("เปลือก – รักษาอาการท้องเสีย");
        hdata.setText("1.นำเปลือกทับทิมมาต้มกับน้ำจนเดือดให้เด็กดื่มน้ำทับทิมครั้งละ1-2 ช้อนชา ทุก 4 ชั่วโมงและ1 ช้อนโต๊ะสำหรับผู้ใหญ่\n" +
                "2.ใช้เปลือกแห้งฝนน้ำรับประทาน");
        tdata.setText("คนที่แพ้ทับทิมจะเกิดอาการเป็นผื่นลมพิษ การบวมที่ลิ้น ริมฝีปาก มือ แขน ใบหน้า คันตา ตาแดง ระคายเคืองจูก หายใจลำบาก และเกิดภาวะแพ้รุนแรง(anaphylactic) และยังมีรายงานว่าเด็กที่รับประทานเมล็ดทับทิมแล้วเกิดอาการหอบหืดชนิดที่เกี่ยวข้องกับ IgE ขึ้น นอกจากนี้การทดสอบการแพ้ทางผิวหนังของผลสด พบว่ามีอาการแพ้");
    }
//    private Statement getStatement(Connection connection) {
//
//        try {
//
//            return connection.createStatement();
//
//        } catch (Exception e) {
//
//            throw new RuntimeException(e);
//
//        }
//    }
}
