package com.example.whankung.navigity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.whankung.navigity.adapter.HideKeyboard;
import com.example.whankung.navigity.services.Disease.DRequest;
import com.example.whankung.navigity.services.Http;
import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by Whankung on 16/1/2560.
 */

public class MainDisease extends android.support.v4.app.Fragment{
    private View rootView;
    private Typeface font;

    private RecyclerView recyclerView;

    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;


    ArrayAdapter<String> adapter;
    ListView lv;

    //    service
    public static final String BASE_URL = "http://localhost:8080/HerbServices/webresources/";
    private static final String TAG = "log";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_disease, container, false);
        setView();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        HideKeyboard.hideKeyboard(getActivity());
        return rootView;
    }






    private void setView() {



        final EditText searchD = (EditText)rootView.findViewById(R.id.searchD);
        lv = (ListView) rootView.findViewById(R.id.list_view);

                    final String[] herbDi = new String[] {"ปวดท้อง", "ปวดหัว", "ข้อเท้าแพลง",
                            "แมลงกัดต่อย", "คลื่นไส้อาเจียน", "โรคผิวหนัง"};


        //Toast.makeText(MainActivity.this, movieArrayList.toString(), Toast.LENGTH_SHORT).show();

//        adapter = new CustomAdapter(getActivity(), herbs);
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_item_2, R.id.disease, herbDi);

        lv.setAdapter(adapter);
//        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager m = getFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                String title=herbDi[position];

                t.replace(R.id.container, new SearchDisease(title));
                t.commit();

//               Toast.makeText(getContext(), "CLICKED", Toast.LENGTH_SHORT).show();
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(searchD.getWindowToken(), 0);
            }
        });
        searchD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                HideKeyboard.hideKeyboard(getActivity());
            }
        });
        searchD.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                MainDisease.this.adapter.getFilter().filter(s);
                searchD.setImeOptions(EditorInfo.IME_ACTION_DONE);
                String strMsg = "ปวดฟัน";
//                if (s.toString().equals(strMsg)) {
//                    searchD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                        @Override
//                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                            if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//                                FragmentManager m = getFragmentManager();
//                                FragmentTransaction t = m.beginTransaction();
//                                t.replace(R.id.container, new  SearchDisease(t));
//                                t.commit();
//
//                            }
//                            return false;
//                        }
//                    });
//                }
            }
        });
    }
//        searchD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//                    FragmentManager m =getFragmentManager();
//                    FragmentTransaction t =m.beginTransaction();
//                    t.replace(R.id.frgMain, new SearchDisease());
//                    t.commit();

//                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.frgMain, new SearchHerb());
//                    transaction.commit();
//                    SearchHerb();
//                    return; true;
//                }
//                return false;
//            }
//        });
//    }




}
