package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.whankung.navigity.adapter.AppState;
import com.example.whankung.navigity.services.DRating.DRatRequest;
import com.example.whankung.navigity.services.Http;
import com.example.whankung.navigity.services.InRating.InRatRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Whankung on 13/3/2560.
 */
public class DataInfo extends Fragment {
    private View rootView;
    private Typeface font;
    private TextView tvI, nameI, namefI, frI, submitI, nm2, un2, date2,ratS;
    private ImageView i_Info, img;
    private RelativeLayout rat;
    private String title;
    private RatingBar rating;
    public DataInfo(String title) {
        this.title = title;

    }
    private ConnectionClass connectionClass;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.data_info, container, false);
        setView();
        setData();
        setRat();
        connectionClass = new ConnectionClass();

        return rootView;
    }

    private void setRat() {

        Call<List<InRatRequest>> call = Http.getInstance().getInrating().loadJson();
        call.enqueue(new Callback<List<InRatRequest>>() {
            public static final String TAG = "";

            @Override
            public void onResponse(Call<List<InRatRequest>> call, Response<List<InRatRequest>> response) {

                if (response.isSuccessful()) {
                    List<InRatRequest> rating = response.body();
                    for (InRatRequest r : rating) {

                        if (r.getInfoID().equals(title)) {

                            //   ratS=new String[]{String.valueOf(r.getRatingHerb())};
                            //p.setText(String.valueOf(r.getRatingHerb()));
                            ratS.setText("Rating: "+String.valueOf(r.getRatingInfo()));
                            Log.d("RSSSSSSSSSSSSSSSS", "555555 " + String.valueOf(r.getRatingInfo()));
                        }

                    }

                } else {
                }
            }

            @Override
            public void onFailure(Call<List<InRatRequest>> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });

    }
    private void setView() {

        rating=(RatingBar) rootView.findViewById(R.id.rat);
//        date2 = (TextView) findViewById(R.id.date2);
//        nm2 = (TextView) findViewById(R.id.nameMe2);
//        un2 = (TextView) findViewById(R.id.Uname2);
        ratS = (TextView) rootView.findViewById(R.id.ratS);
        nameI = (TextView) rootView.findViewById(R.id.nameI);
        namefI = (TextView) rootView.findViewById(R.id.namefI);
        frI = (TextView) rootView.findViewById(R.id.frI);
        submitI = (TextView) rootView.findViewById(R.id.submitI);
        i_Info = (ImageView) rootView.findViewById(R.id.i_Info);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        nameI.setTypeface(font);
        namefI.setTypeface(font);
        frI.setTypeface(font);
        submitI.setTypeface(font);
        submitI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection con = connectionClass.connection();
                Statement statement = getStatement((Connection) con);
                String now = AppState.getSingleInstance().getNamePhama();

                ResultSet rs = null;
//                try {
//                    rs = statement.executeQuery("SELECT usernameDi FROM InfographicRating");
//                    Log.e("RSSSSSSSSSSSSSSSS", "555555 " + rs.toString());
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    rs.next();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                // if (rs.getArray()!=AppState.getSingleInstance().getNamePhama() )
                try {
                    Object o = null;
//                ResultSet rs = statement.executeQuery("INSERT INTO Pharmacist "
//                        + "  VALUES ('',"+u+" ,"+p+" , "+m+")");
                    rs = statement.executeQuery("INSERT INTO InfographicRating "
                            + "  VALUES ('" + null + "','" + String.valueOf(rating.getRating()) + "','" + title + "','" + AppState.getSingleInstance().getNamePhama() + "')");
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

//        nm2.setTypeface(font);
//        un2.setTypeface(font);
//        date2.setTypeface(font);

//        img = (ImageView) rootView.findViewById(R.id.action_login);
//        img.setVisibility(View.VISIBLE);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(getActivity(), MainInfo.class);
//                startActivity(intent);
//
//            }
//        });
        rat = (RelativeLayout) rootView.findViewById(R.id.relarat);
        if (AppState.getSingleInstance().isRating(true)) {
            rat.setVisibility(View.VISIBLE);
            rating.setVisibility(View.VISIBLE);
        } else if (AppState.getSingleInstance().isRating(false)) {
            rat.setVisibility(View.GONE);
            rating.setVisibility(View.GONE);
        }

    }

    private void setData() {
        i_Info.setImageResource(R.drawable.img_in_big);
        nameI.setText("7 ข้อที่ชาวไร่ยาสูบ ยังได้รับ-ทำได้");
        frI.setText("http://www.thaihealth.or.th/Infographic/detail/");
    }
}
