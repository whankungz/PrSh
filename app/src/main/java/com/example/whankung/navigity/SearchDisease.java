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
import com.example.whankung.navigity.db.DBHandler;
import com.example.whankung.navigity.services.Disease.DRequest;
import com.example.whankung.navigity.services.Http;


import com.google.appengine.repackaged.com.google.common.base.Flag;
import com.koushikdutta.async.util.FileCache;
import com.sromku.simple.storage.SimpleStorage;

import com.sromku.simple.storage.Storable;
import com.sromku.simple.storage.Storage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.List;


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
    private static final String TABLE_CONTACTS = "Disease";
    private static final String KEY_NAME_D = "dName";
    private static final String KEY_NAME_H = "hName";
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
    private List<DRequest> disease;

    public SearchDisease(String title) {
        this.title = title;
    }

    private Storage storage, storage2;
    private OkHttpClient client;
    //    SQLiteDatabase db;
    private String content;
    private Call<List<DRequest>> calls;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.search_disease, container, false);
        // AppState.getSingleInstance().getFirstOpenApp();
        storage2 = SimpleStorage.getInternalStorage(getActivity().getApplicationContext());
        setRating();
        setView();
        writeToFile(disease, getActivity().getApplicationContext());
        readFromFile(getActivity().getApplicationContext());
        setServices();
        setSearch();

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


    private void setRating() {

        rat = (RelativeLayout) rootView.findViewById(R.id.relarat);
        if (AppState.getSingleInstance().isRating(true)) {
            rat.setVisibility(View.VISIBLE);
        } else if (AppState.getSingleInstance().isRating(false)) {
            rat.setVisibility(View.GONE);
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
                    Log.d("Reading: ", "Reading all contacts..");
                    //  disease = db.addContact();


                    for (DRequest d : disease) {

                        try {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getContext().openFileOutput("d.txt", Context.MODE_PRIVATE));
                           // outputStreamWriter.write(d.getDiseaseName());
                            outputStreamWriter.write(d.getDiseaseName());
                            outputStreamWriter.close();
                        } catch (IOException e) {
                            Log.e("Exception", "File write failed: " + e.toString());
                        }

                        storage.createDirectory("MyDirName");
                        storage.createDirectory("MyDirName/MySubDirectory");
                        storage.createDirectory("MyDirName", true);
                        storage.createFile("MyDirName", "fileName", d.getDiseaseName());

                        db.addContact(new DRequest(d.getDiseaseName(), d.getHerb()));
                        db.getAllShops();
                        String log = d.getDiseaseName();
                        Log.d("Name: ", log);

                        if (d.getDiseaseName().equals(title)) {
                            String ret = "";

                            try {
                                InputStream inputStream = getContext().openFileInput("d.txt");

                                if (inputStream != null) {
                                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                    String receiveString = "";
                                    StringBuilder stringBuilder = new StringBuilder();

                                    while ((receiveString = bufferedReader.readLine()) != null) {
                                        stringBuilder.append(receiveString);

                                    }

                                    inputStream.close();
                                    ret = stringBuilder.toString();
                                    t2.setText(ret);
                                }
                            } catch (FileNotFoundException e) {
                                Log.e("login activity", "File not found: " + e.toString());
                            } catch (IOException e) {
                                Log.e("login activity", "Can not read file: " + e.toString());

                            }
                            byte[] bytes = storage.readFile("MyDirName", "fileName");
                            content = storage.readTextFile("MyDirName", "fileName");
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
    }

    private void setSearch() {
//        content = storage.readTextFile("MyDirName", "fileName");
     //   t2.setText(content);


    }

    private void writeToFile(List<DRequest> data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("d", Context.MODE_PRIVATE));
            outputStreamWriter.write(String.valueOf(data));
            t2.setText((CharSequence) data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("d");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
