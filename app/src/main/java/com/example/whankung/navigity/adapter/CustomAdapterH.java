package com.example.whankung.navigity.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.navigity.R;
import com.example.whankung.navigity.services.HerbRating.RatRequest;
import com.example.whankung.navigity.services.Http;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 8/9/2559.
 */

public class CustomAdapterH extends BaseAdapter {

    Context mContext;
    String[] strName;
    int[] resId;
    String[] rating;
    private TextView textView, ratS;
    private String title;
    public CustomAdapterH(String title) {
        this.title = title;
    }

    public CustomAdapterH(Context context, String[] strName, int[] resId, String[] rating) {
        this.mContext = context;
        this.strName = strName;
        this.resId = resId;
        this.rating = rating;
    }

    public int getCount() {
        return strName.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (view == null)
            view = mInflater.inflate(R.layout.list_item, null);
        textView = (TextView) view.findViewById(R.id.herb);
        ratS = (TextView) view.findViewById(R.id.ratingS);
        ImageView img = (ImageView) view.findViewById(R.id.img);

        Typeface font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");
        textView.setTypeface(font);
        Call<List<RatRequest>> call = Http.getInstance().getRating().loadJson();
        call.enqueue(new Callback<List<RatRequest>>() {
            public static final String TAG = "";

            @Override
            public void onResponse(Call<List<RatRequest>> call, Response<List<RatRequest>> response) {

                if (response.isSuccessful()) {
                    List<RatRequest> rating = response.body();
                    for (RatRequest r : rating) {

                        if (r.getHerbIdRat().equals(title)) {

                            //   ratS=new String[]{String.valueOf(r.getRatingHerb())};
                            //p.setText(String.valueOf(r.getRatingHerb()));
                            ratS.setText(String.valueOf(r.getRatingHerb()));
                        }

                    }

                } else {
                }
            }

            @Override
            public void onFailure(Call<List<RatRequest>> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });

        textView.setText(strName[position]);
       // ratS.setText(String.valueOf(r));
       // ratS.setText(String.valueOf(rating.clone()));
        img.setBackgroundResource(resId[position]);


        return view;
    }
}




