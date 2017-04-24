package com.example.whankung.navigity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.whankung.navigity.adapter.CustomAdapterH;
import com.example.whankung.navigity.adapter.HideKeyboard;

/**
 * Created by Whankung on 16/1/2560.
 */

public class MainHerb extends android.support.v4.app.Fragment {
    private View rootView;
    private TabLayout tabLayout;
    private Typeface font;
    private EditText search;
    private TextView t_H, t_H2, t_H3, t_H4, p, p2, p3, p4, s, s2, s3, s4, tb;
    private ImageView i_H, i_H2, i_H3, i_H4, star, star2, star3, star4;
   // ArrayAdapter<String> adapter;
    ListView lv;
    private String title;
    private String[] herbs;
    private CustomAdapterH adapter;
    // private String[] herbs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_herb, container, false);
        setView();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        HideKeyboard.hideKeyboard(getActivity());
        int[] resId = { R.drawable.img_ruby
                , R.drawable.img_herb, R.drawable.img_lemon
                , R.drawable.img_ruby2, R.drawable.img_lemon5};
        final String[] herbs = new String[]{"ทับทิม", "ตะไคร้หอม", "มะนาว",
                "ฟ้าทะลายโจร", "พญายอ"};
        final String[] idH = new String[]{"1", "2", "3",
                "4", "5"};
        lv = (ListView) rootView.findViewById(R.id.list_view);

       // adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_item, R.id.product_name,herbs);
        adapter = new CustomAdapterH(getActivity().getApplicationContext(), herbs, resId);
        lv.setAdapter(adapter);
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                FragmentManager m = getFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                title = herbs[position];
                String titleid = idH[position];
                t.replace(R.id.container, new SearchHerb(title, titleid));
                t.commit();

//               Toast.makeText(getContext(), "CLICKED", Toast.LENGTH_SHORT).show();
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(search.getWindowToken(), 0);
            }
        });


        return rootView;
    }


    private void setView() {
        //  tb = (TextView) rootView.findViewById(R.id.toolbar_title);
        //  tb.setText("สมุนไพร");
//        s = (TextView) rootView.findViewById(R.id.s);
//        s2 = (TextView) rootView.findViewById(R.id.s2);
//        s3 = (TextView) rootView.findViewById(R.id.s3);
//        s4 = (TextView) rootView.findViewById(R.id.s4);
//        p = (TextView) rootView.findViewById(R.id.p);
//        p2 = (TextView) rootView.findViewById(R.id.p2);
//        p3 = (TextView) rootView.findViewById(R.id.p3);
//        p4 = (TextView) rootView.findViewById(R.id.p4);
//        t_H = (TextView) rootView.findViewById(R.id.t_H);
//        t_H2 = (TextView) rootView.findViewById(R.id.t_H2);
//        t_H3 = (TextView) rootView.findViewById(R.id.t_H3);
//        t_H4 = (TextView) rootView.findViewById(R.id.t_H4);
//        i_H = (ImageView) rootView.findViewById(R.id.i_H);
//        i_H2 = (ImageView) rootView.findViewById(R.id.i_H2);
//        i_H3 = (ImageView) rootView.findViewById(R.id.i_H3);
//        i_H4 = (ImageView) rootView.findViewById(R.id.i_H4);
//        star = (ImageView) rootView.findViewById(R.id.star);
//        star2 = (ImageView) rootView.findViewById(R.id.star2);
//        star3 = (ImageView) rootView.findViewById(R.id.star3);
//        star4 = (ImageView) rootView.findViewById(R.id.star4);
//
//        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
//        t_H.setTypeface(font);
//        t_H2.setTypeface(font);
//        t_H3.setTypeface(font);
//        t_H4.setTypeface(font);
//        p.setTypeface(font);
//        p2.setTypeface(font);
//        p3.setTypeface(font);
//        p4.setTypeface(font);
//        s.setTypeface(font);
//        s2.setTypeface(font);
//        s3.setTypeface(font);
//        s4.setTypeface(font);
        // tb.setTypeface(font);
        search = (EditText) rootView.findViewById(R.id.search);
        search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                HideKeyboard.hideKeyboard(getActivity());
            }
        });
        search.addTextChangedListener(new TextWatcher() {


            @Override
            public void afterTextChanged(Editable arg0) {
//                String text = search.getText().toString().toLowerCase(Locale.getDefault());
//                adapter.getFilter().filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

               // adapter.getFilter().filter(s);


                search.setImeOptions(EditorInfo.IME_ACTION_DONE);
                final String strMsg = "ทับทิม";
                String strMsg2 = "มะนาว";


//                if (s.toString().equals(strMsg)) {
//                    search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                        @Override
//                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                                //  AppState.getSingleInstance().setDataHerb(strMsg);
//                                FragmentManager m = getFragmentManager();
//                                FragmentTransaction t = m.beginTransaction();
//                                t.replace(R.id.container, new SearchHerb());
//                                t.commit();
//
//
//                            }
//                            return false;
//                        }
//                    });
//                } else if (s.toString().equals(strMsg2)) {
//                    search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                        @Override
//                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                            if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//                                FragmentManager m = getFragmentManager();
//                                FragmentTransaction t = m.beginTransaction();
//                                t.replace(R.id.container, new SearchHerb());
//                                t.commit();
//
//
//                            }
//                            return false;
//                        }
//                    });
//
//                }
            }
        });
    }
    //                    FragmentManager manager = getSupportFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.replace(R.id.frgMain, new SearchHerb());
//                    transaction.commit();
//                    SearchHerb();
//                    return; true;


    private void setShowHerb() {
        i_H.setImageResource(R.drawable.img_grass);
        t_H.setText("ตะไคร้");
        i_H2.setImageResource(R.drawable.img_ruby4);
        t_H2.setText("ทับทิม");
        i_H3.setImageResource(R.drawable.img_lemon2);
        t_H3.setText("มะนาว");
        i_H4.setImageResource(R.drawable.img_fa);
        t_H4.setText("ฟ้าทะลายโจร");
        star.setImageResource(R.drawable.ic_star2);
        star2.setImageResource(R.drawable.ic_star2);
        star3.setImageResource(R.drawable.ic_star2);
        star4.setImageResource(R.drawable.ic_star2);

    }

}

