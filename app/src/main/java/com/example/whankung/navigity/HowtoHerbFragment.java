package com.example.whankung.navigity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.whankung.navigity.adapter.AppState;
import com.example.whankung.navigity.adapter.CustomAdapterF;
import com.example.whankung.navigity.adapter.CustomAdapterMent;
import com.example.whankung.navigity.services.Disease.DRequest;
import com.example.whankung.navigity.services.Hcomment.CRequest;
import com.example.whankung.navigity.services.Herb.HRequest;
import com.example.whankung.navigity.services.HerbRating.RatRequest;
import com.example.whankung.navigity.services.Http;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.whankung.navigity.Register.*;
import static java.util.Calendar.AM;


/**
 * Created by Whankung on 22/1/2560.
 */
public class HowtoHerbFragment extends android.support.v4.app.Fragment {
    private Typeface font;
    private View rootView;
    private TextView p, pdata, h, hdata, t, tdata, sub, nm, un, date, times,t9;
    private ListView post;
    private RatingBar rat;
    private EditText ment;
    private Register register;
    public static final String BASE_URL = "http://192.168.181.1:8080/Servies/webresources/";
    private static final String TAG = "log";
    private String title, cMent, tC;
    private String titleid;
    private ConnectionClass connectionClass;
    private TextClock time;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList, arrayTime;
    // private CustomAdapterMent adapter;

    public HowtoHerbFragment(String titleid, String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.howto_herb, container, false);
        connectionClass = new ConnectionClass();
        setView();

          setData();
//        setRating();
        setServices();
        if (AppState.getSingleInstance().isRating(true)) {
            t9.setVisibility(View.VISIBLE);
            // t9.setVisibility(View.VISIBLE);
        } else if (AppState.getSingleInstance().isRating(false)) {
            t9.setVisibility(View.GONE);
            //   t9.setVisibility(View.GONE);
        }
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
        times = (TextView) rootView.findViewById(R.id.setTime);
        post = (ListView) rootView.findViewById(R.id.post);

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
        t9 = (TextView) rootView.findViewById(R.id.submit2);
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection con = connectionClass.connection();
                Statement statement = getStatement((Connection) con);
                String now = AppState.getSingleInstance().getNamePhama();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = df.format(c.getTime());
                ResultSet rs = null;
                try {
                    rs = statement.executeQuery("SELECT usernameDi FROM DiseaseRating");
                    Log.e("RSSSSSSSSSSSSSSSS", "555555 " + rs.toString());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    rs.next();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // if (rs.getArray()!=AppState.getSingleInstance().getNamePhama() )
                try {
                    Object o = null;
//                ResultSet rs = statement.executeQuery("INSERT INTO Pharmacist "
//                        + "  VALUES ('',"+u+" ,"+p+" , "+m+")");
                    rs = statement.executeQuery("INSERT INTO HerbRating "
                            + "  VALUES ('" + null + "','" + String.valueOf(rat.getRating()) + "','" + title + "','" + AppState.getSingleInstance().getNamePhama() + "','"+formattedDate+"')");
//                   rs=statement.executeQuery(("UPDATE Herb" +
//                           "SET herbRate = '"+String.valueOf(rat.getRating())+
//                           "WHERE herbName = '"+title));
                    rs.close();
                    statement.close();

                } catch (SQLException e) {

                    e.printStackTrace();


                }


            }

            private Statement getStatement(Connection connection) {

                try {

                    return connection.createStatement();

                } catch (Exception e) {

                    throw new RuntimeException(e);


                }
                // Toast.makeText(getActivity().getApplicationContext(), String.valueOf(rata.getRating()), Toast.LENGTH_LONG).show();



               // Toast.makeText(getActivity().getApplicationContext(), String.valueOf(rat.getRating()), Toast.LENGTH_LONG).show();

            }
        });

        String[] m = {"ความคิดเห็นของเภสัชกร"};
        String[] t = {"time"};


        arrayList = new ArrayList<>(Arrays.asList(m));
        //   arrayTime = new ArrayList<>(Arrays.asList(t));
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_item_ment, R.id.mentP, arrayList);
        // adapter = new CustomAdapterMent(getActivity().getApplicationContext(), arrayList,arrayTime);
        post.setAdapter(adapter);





    }





    private void setServices() {
        Call<List<HRequest>> call = Http.getInstance().getHerb().loadJson();
//        Call<List<HRequest>> call2 = Http.getInstance().getHerbimg().loadJson();
        //  call = Http.getInstance().getHerbre().loadJson();
        call.enqueue(new Callback<List<HRequest>>() {
            @Override
            public void onResponse(Call<List<HRequest>> call, Response<List<HRequest>> response) {

                if (response.isSuccessful()) {
                    List<HRequest> herb = response.body();

                    // Can iterate through list and grab Getters from POJO
                    for (HRequest h : herb) {

                        if (h.getHerbName().equals(title)) {
                            try {

                                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getContext().openFileOutput("d.txt", Context.MODE_PRIVATE));

                                outputStreamWriter.write("วิธีใช้      "+h.getHowto()+"\n");


                                outputStreamWriter.write(h.getWarning());

//                                outputStreamWriter.write(d.getSymptom());
//                                outputStreamWriter.write(d.getHowtoRelief());
                                outputStreamWriter.close();

                            } catch (IOException e) {
                                Log.e("Exception", "File write failed: " + e.toString());
                            }
                            Log.d(TAG, "oooooooooooooo" + h.getHowto());
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
        Call<List<CRequest>> call = Http.getInstance().getComment().loadJson();
        call.enqueue(new Callback<List<CRequest>>() {
            @Override
            public void onResponse(Call<List<CRequest>> call, Response<List<CRequest>> response) {

                if (response.isSuccessful()) {
                    List<CRequest> comment = response.body();
                    for (CRequest c : comment) {

                        if (c.getHerbIdCom().equals(title)) {
                            arrayList.add(c.getHerbComment()+"\n\n"+"username :"+c.getUsernameHerbCom());
                            sub.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cMent = ment.getText().toString();
                                    //   time = (TextClock) rootView.findViewById(R.id.tClock);
                                    //  tC = time.getText().toString();

                                    //  times.setText(tC);

                                    Connection con = connectionClass.connection();
                                    Statement statement = getStatement((Connection) con);
                                    String now = AppState.getSingleInstance().getNamePhama();
                                    Calendar c = Calendar.getInstance();
                                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                    String formattedDate = df.format(c.getTime());

                                //    arrayList.add("  "+"username : "+AppState.getSingleInstance().getNamePhama()+"       "+   formattedDate+"\n"+cMent);
                                    ResultSet rs = null;
                                    try {
                                        rs = statement.executeQuery("SELECT usernameDi FROM DiseaseRating");
                                        Log.e("RSSSSSSSSSSSSSSSS", "555555 " + rs.toString());
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        rs.next();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    // if (rs.getArray()!=AppState.getSingleInstance().getNamePhama() )
                                    try {
                                        Object o = null;
//                ResultSet rs = statement.executeQuery("INSERT INTO Pharmacist "
//                        + "  VALUES ('',"+u+" ,"+p+" , "+m+")");
                                        rs = statement.executeQuery("INSERT INTO HerbComment "
                                                + "  VALUES ('" + null + "','" + cMent + "','" + title + "','" +  AppState.getSingleInstance().getNamePhama() + "','"+ formattedDate+"')");
                                        rs.close();
                                        statement.close();

                                    } catch (SQLException e) {

                                        e.printStackTrace();


                                    }

                                    adapter.notifyDataSetChanged();
                                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(ment.getWindowToken(), 0);
                                    ment.getText().clear();

                                }

                                private Statement getStatement(Connection connection) {

                                    try {

                                        return connection.createStatement();

                                    } catch (Exception e) {

                                        throw new RuntimeException(e);


                                    }

                                }

                            });

                            p.setText(String.valueOf(c.getHerbComment()+c.getUsernameHerbCom()));
                        }

                    }

                } else {
                }
            }

            @Override
            public void onFailure(Call<List<CRequest>> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });
    }

}
