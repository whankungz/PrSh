package com.example.whankung.navigity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by macbookpro on 4/12/2017 AD.
 */

public class MainOffice extends Fragment {
    private Typeface font;
    public static final String BASE_URL = "http://192.168.181.50:8080/Servies/webresources/";
    private static final String TAG = "log";
    private View rootView;
    ArrayAdapter<String> adapter;
    ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.main_office, container, false);
        setView();


        return rootView;
    }

    private void setView() {
//        เปลี่ยนfont
        font = Typeface.createFromAsset(getActivity().getAssets(), "tmedium.ttf");

        final String[] office = new String[] {"สถาบันวิจัยสมุนไพร"};
        lv = (ListView) rootView.findViewById(R.id.list_view);



//        adapter = new CustomAdapter(getActivity(), herbs);
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_item_4, R.id.disease, office);

        lv.setAdapter(adapter);
//        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager m = getFragmentManager();
                FragmentTransaction t = m.beginTransaction();
                String title=office[position];
                t.replace(R.id.container, new DataOffice(title));
                t.commit();
            }
        });
    }

}
