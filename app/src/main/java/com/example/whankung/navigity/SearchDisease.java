package com.example.whankung.navigity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.whankung.navigity.adapter.AppState;
import com.example.whankung.navigity.db.DBHandler;
import com.example.whankung.navigity.services.Disease.DRequest;
import com.example.whankung.navigity.services.Http;


import com.example.whankung.navigity.services.rating;
import com.sromku.simple.storage.SimpleStorage;

import com.sromku.simple.storage.Storable;
import com.sromku.simple.storage.Storage;


import org.parceler.Parcels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by Whankung on 22/1/2560.
 */

public class SearchDisease extends Fragment {
    //@butterknife.Bind(R.id.rat) AppCompatRatingBar rata;
    private static final String TABLE_CONTACTS = "Disease";
    private static final String KEY_NAME_D = "dName";
    private static final String KEY_NAME_H = "hName";
    private View rootView;
    private TabLayout tabLayout;
    private Typeface font;
    private TextView t, t2, t3, t4, t5, t6, t7, t8, t9, nm, un, date, ratT;
    private RatingBar rata;
    private RelativeLayout rat;
    private String title, d1, d2, d3, d4;
    //        service
    public static final String BASE_URL = "http://192.168.43.68:8080/Servies/webresources/";
    private static final String TAG = "log";
    private List<DRequest> disease;
    private Button b;

    public SearchDisease(String title) {
        this.title = title;
    }

    private Storage storage, storage2;
    private OkHttpClient client;
    //    SQLiteDatabase db;
    private String content;
    private Call<List<DRequest>> calls;
    private rating rating;
    private ConnectionClass connectionClass;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_disease, container, false);
//        if( AppState.getFirstOpenApp()){
            connectionClass = new ConnectionClass();
            setView();
            setRating();
            setServices();
            setSearch(getContext());
//            AppState.setFirstOpenApp(true);
//        }

        //rating = Parcels.unwrap(getArguments().getParcelable("rating"));


        //  ButterKnife.bind(this, rootView);

        // rata.setRating((float)rating.rating );


        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Contact("Ravi", "9100000000"));
//        db.addContact(new Contact("Srinivas", "9199999999"));
//        db.addContact(new Contact("Tommy", "9522222222"));
//        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<DRequest> contacts = db.addContact();
//        for (DRequest cn : contacts) {
//            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        if(AppState.getSingleInstance().isNetworkAvailable(getActivity())) {
//            setServices();
//        } else {
//            setNoServices();
//        }


        // AppState.getSingleInstance().setFirstOpenApp(false);


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
        // ratT = (TextView) rootView.findViewById(R.id.ratT);
        rata = (RatingBar) rootView.findViewById(R.id.rat);
        b = (Button) rootView.findViewById(R.id.submit2);
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection con = connectionClass.connection();
                Statement statement = getStatement((Connection) con);
                String now = AppState.getSingleInstance().getNamePhama();

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
                       rs = statement.executeQuery("INSERT INTO DiseaseRating "
                                + "  VALUES ('" + null + "','" + String.valueOf(rata.getRating()) + "','" + null + "','" + AppState.getSingleInstance().getNamePhama() + "')");
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

            }
        });

        // Toast.makeText(getActivity().getApplicationContext(), String.valueOf(rata.getRating()), Toast.LENGTH_LONG).show();
//        rata.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    float touchPositionX = event.getX();
//                    float width = rata.getWidth();
//                    int starsf = (int) ((touchPositionX / width) * 5);
//                    int stars = (int) starsf + 1;
//                    rata.setRating(stars);
//                    rata.getNumStars();
//                    Log.e("rating", "rating" + starsf);
////                    int textRat=starsf;
////                    ratT.setText(textRat);
//                    Toast.makeText(getActivity(), String.valueOf("test"), Toast.LENGTH_SHORT).show();
//                    v.setPressed(false);
//                }
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    //  Toast.makeText(getActivity(), String.valueOf("test2"), Toast.LENGTH_SHORT).show();
//                    v.setPressed(true);
//                }
//
//                if (event.getAction() == MotionEvent.ACTION_CANCEL) {
//                    v.setPressed(false);
//                }
//
//
//                return true;
//            }
//        });

        //  rating.setRating((float) rating);

        //  rata.getRating();
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


    private void setRating() {

        rat = (RelativeLayout) rootView.findViewById(R.id.relarat);
        if (AppState.getSingleInstance().isRating(true)) {
            rat.setVisibility(View.VISIBLE);
            // t9.setVisibility(View.VISIBLE);
        } else if (AppState.getSingleInstance().isRating(false)) {
            rat.setVisibility(View.GONE);
            //   t9.setVisibility(View.GONE);
        }
    }


    public void setServices() {
        storage = null;
        if (SimpleStorage.isExternalStorageWritable()) {

            storage = SimpleStorage.getExternalStorage();
        } else {
            storage = SimpleStorage.getInternalStorage(getActivity());
        }
        //  storage = SimpleStorage.getExternalStorage();
        //   final DRequest disease = new DRequest();

        calls = Http.getInstance().getDisease().loadJson();
        calls.request();

        calls.enqueue(new Callback<List<DRequest>>() {
            @Override
            public void onResponse(Call<List<DRequest>> call, Response<List<DRequest>> response) {

                if (response.isSuccessful()) {
                    disease = response.body();
                    DBHandler db = new DBHandler(getActivity());

                    //  disease = db.addContact();


                    for (DRequest d : disease) {

//                        storage.createDirectory("MyDirName");
//                        storage.createDirectory("MyDirName/MySubDirectory");
//                        storage.createDirectory("MyDirName", true);
//                        storage.createFile("MyDirName", "fileName", d.getDiseaseName());
//
//                        db.addContact(new DRequest(d.getDiseaseName(), d.getHerb()));
//                        db.getAllShops();


                        if (d.getDiseaseName().equals(title)) {
                            try {

                                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getContext().openFileOutput("d.txt", Context.MODE_PRIVATE));
                                outputStreamWriter.write(d.getDiseaseName());


                                outputStreamWriter.write(d.getHerb());
//                                outputStreamWriter.write(d.getSymptom());
//                                outputStreamWriter.write(d.getHowtoRelief());
                                outputStreamWriter.close();

                            } catch (IOException e) {
                                Log.e("Exception", "File write failed: " + e.toString());
                            }
                            try {

                                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getContext().openFileOutput("db.txt", Context.MODE_PRIVATE));
                                outputStreamWriter.write(d.getHerb());


//
                                outputStreamWriter.close();

                            } catch (IOException e) {
                                Log.e("Exception", "File write failed: " + e.toString());
                            }
                        }
                        if (d.getDiseaseName().equals(title)) {

                            t2.setText(d.getDiseaseName());
//                            byte[] bytes = storage.readFile("MyDirName", "fileName");
//                            content = storage.readTextFile("MyDirName", "fileName");
                            // t2.setText(content);
                            // t2.setText(d.getDiseaseName());


                            t4.setText(d.getHerb());
                            t6.setText(d.getSymptom());
                            t8.setText(d.getHowtoRelief());


                        }
                    }

                } else {


                }

            }

            @Override
            public void onFailure(Call<List<DRequest>> call, Throwable t) {


                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });
        //rata.setRating((float)rating.rating );
        //  rata.getRating();
    }

    private void setSearch(Context context) {

//        d1 = "";
//
//
////    d2 = "";
////    d3 = "";
////    d4 = "";
//        try {
//            InputStream inputStream = getContext().openFileInput("d.txt");
//
//            if (inputStream != null) {
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                String receiveString = "";
//                StringBuilder stringBuilder = new StringBuilder();
//
//                while ((receiveString = bufferedReader.readLine()) != null) {
//                    stringBuilder.append(receiveString);
//
//                }
//
//                inputStream.close();
//                d1 = stringBuilder.toString();
//
//                t2.setText(d1);
////                t4.setText(d2);
////                t6.setText(d3);
////                t8.setText(d4);
//            }
//        } catch (FileNotFoundException e) {
//            Log.e("login activity", "File not found: " + e.toString());
//        } catch (IOException e) {
//            Log.e("login activity", "Can not read file: " + e.toString());
//
//            d2 = "";
//
//
////    d2 = "";
////    d3 = "";
////    d4 = "";
//            try {
//                InputStream inputStream = getContext().openFileInput("db.txt");
//
//                if (inputStream != null) {
//                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                    String receiveString = "";
//                    StringBuilder stringBuilder = new StringBuilder();
//
//                    while ((receiveString = bufferedReader.readLine()) != null) {
//                        stringBuilder.append(receiveString);
//
//                    }
//
//                    inputStream.close();
//                    d2 = stringBuilder.toString();
//
//                    t4.setText(d2);
////                t4.setText(d2);
////                t6.setText(d3);
////                t8.setText(d4);
//                }
//            } catch (FileNotFoundException e2) {
//                Log.e("login activity", "File not found: " + e.toString());
//            } catch (IOException e2) {
//                Log.e("login activity", "Can not read file: " + e.toString());
//
//            }


//        content = storage.readTextFile("MyDirName", "fileName");
        //   t2.setText(content);

//        }


//    private void writeToFile(List<DRequest> data, Context context) {
//        try {
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("d", Context.MODE_PRIVATE));
//            outputStreamWriter.write(String.valueOf(data));
//            t2.setText((CharSequence) data);
//            outputStreamWriter.close();
//        } catch (IOException e) {
//            Log.e("Exception", "File write failed: " + e.toString());
//        }
//    }
//
//    private String readFromFile(Context context) {
//
//        String ret = "";
//
//        try {
//            InputStream inputStream = context.openFileInput("d");
//
//            if (inputStream != null) {
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                String receiveString = "";
//                StringBuilder stringBuilder = new StringBuilder();
//
//                while ((receiveString = bufferedReader.readLine()) != null) {
//                    stringBuilder.append(receiveString);
//                }
//
//                inputStream.close();
//                ret = stringBuilder.toString();
//            }
//        } catch (FileNotFoundException e) {
//            Log.e("login activity", "File not found: " + e.toString());
//        } catch (IOException e) {
//            Log.e("login activity", "Can not read file: " + e.toString());
//        }
//
//        return ret;
//    }
    }
}
