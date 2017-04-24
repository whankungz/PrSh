package com.example.whankung.navigity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
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


/**
 * Created by Whankung on 16/1/2560.
 */

public class MainDisease extends android.support.v4.app.Fragment{
    private View rootView;
    private Typeface font;
    private TextView t_H, t_H2, t_H3, t_H4, t_H5, t_H6, t_H7,s,s2,s3,s4,s5,s6,s7,tb;
    private ImageView i_H, i_H2, i_H3, i_H4,i_H5,i_H6,i_H7, star, star2, star3, star4, star5, star6, star7;


    ArrayAdapter<String> adapter;
    ListView lv;

    //    service
    public static final String BASE_URL = "http://localhost:8080/HerbServices/webresources/service.entityclass.admin";
    private static final String TAG = "log";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_disease, container, false);
        setView();
        setShow();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        HideKeyboard.hideKeyboard(getActivity());
        return rootView;
    }





    private void setView() {

//        tb = (TextView) rootView.findViewById(R.id.toolbar_title);
//        tb.setText("อาการ/โรค");
//        s= (TextView) rootView.findViewById(R.id.s);
//        s2= (TextView) rootView.findViewById(R.id.s2);
//        s3= (TextView) rootView.findViewById(R.id.s3);
//        s4= (TextView) rootView.findViewById(R.id.s4);
//        s5= (TextView) rootView.findViewById(R.id.s5);
//        s6= (TextView) rootView.findViewById(R.id.s6);
//        s7= (TextView) rootView.findViewById(R.id.s7);
//        t_H = (TextView) rootView.findViewById(R.id.t_H);
//        t_H2 = (TextView) rootView.findViewById(R.id.t_H2);
//        t_H3 = (TextView) rootView.findViewById(R.id.t_H3);
//        t_H4 = (TextView) rootView.findViewById(R.id.t_H4);
//        t_H5 = (TextView) rootView.findViewById(R.id.t_H5);
//        t_H6 = (TextView) rootView.findViewById(R.id.t_H6);
//        t_H7 = (TextView) rootView.findViewById(R.id.t_H7);
//        i_H = (ImageView) rootView.findViewById(R.id.i_H);
//        i_H2 = (ImageView) rootView.findViewById(R.id.i_H2);
//        i_H3 = (ImageView) rootView.findViewById(R.id.i_H3);
//        i_H4 = (ImageView) rootView.findViewById(R.id.i_H4);
//        i_H5 = (ImageView) rootView.findViewById(R.id.i_H5);
//        i_H6 = (ImageView) rootView.findViewById(R.id.i_H6);
//        i_H7 = (ImageView) rootView.findViewById(R.id.i_H7);
//        star = (ImageView) rootView.findViewById(R.id.star);
//        star2 = (ImageView) rootView.findViewById(R.id.star2);
//        star3 = (ImageView) rootView.findViewById(R.id.star3);
//        star4 = (ImageView) rootView.findViewById(R.id.star4);
//        star5 = (ImageView) rootView.findViewById(R.id.star5);
//        star6 = (ImageView) rootView.findViewById(R.id.star6);
//        star7 = (ImageView) rootView.findViewById(R.id.star7);
//
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
//        t_H.setTypeface(font);
//        t_H2.setTypeface(font);
//        t_H3.setTypeface(font);
//        t_H4.setTypeface(font);
//        t_H5.setTypeface(font);
//        t_H6.setTypeface(font);
//        t_H7.setTypeface(font);
//        s.setTypeface(font);
//        s2.setTypeface(font);
//        s3.setTypeface(font);
//        s4.setTypeface(font);
//        s5.setTypeface(font);
//        s6.setTypeface(font);
//        s7.setTypeface(font);
//        tb.setTypeface(font);

        final EditText searchD = (EditText)rootView.findViewById(R.id.searchD);
        final String[] herbDi = new String[] {"ปวดท้อง", "ปวดหัว", "ข้อเท้าแพลง",
                "แมลงกัดต่อย", "คลื่นไส้อาเจียน", "โรคผิวหนัง"};
        lv = (ListView) rootView.findViewById(R.id.list_view);



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

                t.replace(R.id.container, new  SearchDisease(title));
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

    private void setShow() {
//        i_H.setImageResource(R.drawable.ic_dise);
//        t_H.setText("ไข้เลือดออก");
//        i_H2.setImageResource(R.drawable.ic_dise);
//        t_H2.setText("ไข้หวัดใหญ่");
//        i_H3.setImageResource(R.drawable.ic_dise);
//        t_H3.setText("ท้องเสีย");
//        i_H4.setImageResource(R.drawable.ic_dise);
//        t_H4.setText("ปวดฟัน");
//        i_H5.setImageResource(R.drawable.ic_dise);
//        t_H5.setText("ตาแดง");
//        i_H6.setImageResource(R.drawable.ic_dise);
//        t_H6.setText("เหน็บชา");
//        i_H7.setImageResource(R.drawable.ic_dise);
//        t_H7.setText("กระเพาะอาหารอักเสบ");
//        star.setImageResource(R.drawable.ic_star2);
//        star2.setImageResource(R.drawable.ic_star2);
//        star3.setImageResource(R.drawable.ic_star2);
//        star4.setImageResource(R.drawable.ic_star2);
//        star5.setImageResource(R.drawable.ic_star2);
//        star6.setImageResource(R.drawable.ic_star2);
//        star7.setImageResource(R.drawable.ic_star2);
    }
}
