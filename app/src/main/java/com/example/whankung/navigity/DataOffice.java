package com.example.whankung.navigity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.navigity.services.Herb.HRequest;
import com.example.whankung.navigity.services.Http;
import com.example.whankung.navigity.services.Office.OfRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataOffice extends Fragment {
    private Typeface font;
    TextView tv, nameOf, addr, addrdata, call, fax, mailOf, whyOf, whyOfdata, web;
    ImageView img, i, i2, i3, i4, i5, i6;
    public static final String BASE_URL = "http://192.168.181.50:8080/Servies/webresources/";
    private static final String TAG = "log";
    private View rootView;
    private String title;
    public DataOffice(String title) {
        this.title=title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_office, container, false);
        setView();
        setServices();
      //  setData();

        return rootView;
    }

    private void setView() {
        nameOf = (TextView) rootView.findViewById(R.id.nameOf);
        addr = (TextView) rootView.findViewById(R.id.addr);
        addrdata = (TextView) rootView.findViewById(R.id.addrdata);
        call = (TextView) rootView.findViewById(R.id.call);
        fax = (TextView) rootView.findViewById(R.id.fax);
        mailOf = (TextView) rootView.findViewById(R.id.mailOf);
        whyOf = (TextView) rootView.findViewById(R.id.whyOf);
        whyOfdata = (TextView) rootView.findViewById(R.id.whyOfdata);
        web = (TextView) rootView.findViewById(R.id.web);


//        เปลี่ยนfont
        font = Typeface.createFromAsset(getActivity().getAssets(), "tmedium.ttf");
        nameOf.setTypeface(font);
        addr.setTypeface(font);
        addrdata.setTypeface(font);
        call.setTypeface(font);
        fax.setTypeface(font);
        mailOf.setTypeface(font);
        whyOf.setTypeface(font);
        whyOfdata.setTypeface(font);
        web.setTypeface(font);


    }
    private void setServices() {
        Call<List<OfRequest>> call2 = Http.getInstance().getOffice().loadJson();
//        Call<List<HRequest>> call2 = Http.getInstance().getHerbimg().loadJson();
        //  call = Http.getInstance().getHerbre().loadJson();
        call2.enqueue(new Callback<List<OfRequest>>() {
            @Override
            public void onResponse(Call<List<OfRequest>> call2, Response<List<OfRequest>> response) {

                if (response.isSuccessful()) {
                    List<OfRequest> herb = response.body();

                    // Can iterate through list and grab Getters from POJO
                    for (OfRequest h : herb) {

                        if (h.getContactName().equals(title)) {
                          nameOf.setText(h.getContactName());
                            addrdata.setText(h.getAddress());
                            call.setText(h.getTel());
                            //fax.setText(h.);
                            mailOf.setText(h.getEmail());
                            whyOfdata.setText(h.getRole());
                            web.setText(h.getWebsite());
                        }

                    }

                } else {
                }
            }

            @Override
            public void onFailure(Call<List<OfRequest>> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });
    }
    private void setData() {
        nameOf.setText("สถาบันวิจัยสมุนไพร");
        addrdata.setText("กรมวิทยาศาสตร์การแพทย์ กระทรวงสาธาณสุข" +
                "88/7 ซ.ติวานนท์ 14 ต.ตลาดขวัญ อ.เมือง จ.นนทบุรี 11000");
        call.setText("เบอร์โทรศัพท์ " + " 0-2951-0491");
        fax.setText("แฟกซ์ " + " 0-2589-9866");
        mailOf.setText("อีเมล " + " -");
        whyOfdata.setText("1. ศึกษา วิเคราะห์ วิจัยและพัฒนาองค์ความรู้ และเทคโนโลยีทางห้องปฏิบัติการด้านสมุนไพร\n" +
                "2. พัฒนาระบบการตรวจวิเคราะห์คุณภาพวัตถุดิบ และผลิตภัณฑ์จากสมุนไพร\n" +
                "3. กำหนดมาตรฐานสมุนไพรและเภสัชตำรับ\n" +
                "4. เป็นห้องปฏิบัติการอ้างอิงด้านสมุนไพร\n" +
                "5. พัฒนาระบบฐานข้อมูลและให้บริการข้อมูลวิธีตรวจวิเคราะห์ทางห้องปฏิบัติการ\n" +
                "6. พัฒนาคุณภาพห้องปฏิบัติการ สนับสนุนด้านวิชาการและถ่ายทอดเทคโนโลยีด้านสมุนไพรแก่ ห้องปฏิบัติการเครือข่ายห้องปฏิบัติการภาครัฐและภาคเอกชน\n" +
                "7. ปฏิบัติงานร่วมกับหรือสนับสนุนการปฏิบัติงานของหน่วยงานอื่นที่เกี่ยวข้องหรือ หรือที่ได้รับมอบหมาย");
        web.setText("เว็ปไซต์ " + " http://dmsc2.dmsc.moph.go.th/webroot/Plant/Mpri2013/index.shtm");
    }


}
