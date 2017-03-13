package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 31/1/2560.
 */
public class MainOffice extends AppCompatActivity {

    private Typeface font;
    TextView tv, nameOf, addr, addrdata, call, fax, mailOf, whyOf, whyOfdata, web,
    nameOf2, addr2, addrdata2, call2, fax2, mailOf2, whyOf2, whyOfdata2, web2;
    ImageView img, i, i2, i3, i4, i5, i6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stucture_office);
        img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือกเภสัช
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });
        setView();
        setData();
        setData2();

    }


    private void setView() {
        tv = (TextView) findViewById(R.id.textView);
        nameOf = (TextView) findViewById(R.id.nameOf);
        addr = (TextView) findViewById(R.id.addr);
        addrdata = (TextView) findViewById(R.id.addrdata);
        call = (TextView) findViewById(R.id.call);
        fax = (TextView) findViewById(R.id.fax);
        mailOf = (TextView) findViewById(R.id.mailOf);
        whyOf = (TextView) findViewById(R.id.whyOf);
        whyOfdata = (TextView) findViewById(R.id.whyOfdata);
        web = (TextView) findViewById(R.id.web);
        nameOf2 = (TextView) findViewById(R.id.nameOf2);
        addr2 = (TextView) findViewById(R.id.addr2);
        addrdata2 = (TextView) findViewById(R.id.addrdata2);
        call2 = (TextView) findViewById(R.id.call2);
        fax2 = (TextView) findViewById(R.id.fax2);
        mailOf2 = (TextView) findViewById(R.id.mailOf2);
        whyOf2 = (TextView) findViewById(R.id.whyOf2);
        whyOfdata2 = (TextView) findViewById(R.id.whyOfdata2);
        web2 = (TextView) findViewById(R.id.web2);


//        เปลี่ยนfont
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        nameOf.setTypeface(font);
        addr.setTypeface(font);
        addrdata.setTypeface(font);
        call.setTypeface(font);
        fax.setTypeface(font);
        mailOf.setTypeface(font);
        whyOf.setTypeface(font);
        whyOfdata.setTypeface(font);
        web.setTypeface(font);
        nameOf2.setTypeface(font);
        addr2.setTypeface(font);
        addrdata2.setTypeface(font);
        call2.setTypeface(font);
        fax2.setTypeface(font);
        mailOf2.setTypeface(font);
        whyOf2.setTypeface(font);
        whyOfdata2.setTypeface(font);
        web2.setTypeface(font);


        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

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
    private void setData2() {
        nameOf2.setText("อุทยานธรรมชาติวิทยาสิรีรุกขชาติ มหาวิทยาลัยมหิดล");
        addrdata2.setText("มหาวิทยาลัยมหิดล  999 ถนนพุทธมณฑลสาย 4 \n" +
                "ต.ศาลายา อ.พุทธมณฑล จ.นครปฐม 73170");
        call2.setText("เบอร์โทรศัพท์ " + " 02-441-5272-4");
        fax2.setText("แฟกซ์ " + " -");
        mailOf2.setText("อีเมล " + " jutatip.khw@mahidol.ac.th");
        whyOfdata2.setText("ภายใต้การดูแลและดาเนินการของภาควิชาเภสัชพฤกษศาสตร์มีพื้นที่รวมทั้งสิ้น ๓๘ ไร่ รวบรวมพันธุ์ สมุนไพรไว้ประมาณ ๘๐๐ ชนิด จัดปลูกไว้อย่างสวยงาม พร้อมป้ายชื่อพืชสมุนไพรที่ระบุทั้งชื่อไทย ชื่อวิทยาศาสตร์ ชื่อวงศ์ ส่วนที่ใช้และสรรพคุณ และเป็นห้องเรียนธรรมชาติสาหรับ นักเรียน นักศึกษา นักวิชาการ รวมทั้งผู้สนใจที่ได้เข้าเยี่ยมชมเพิ่มขึ้นทุกปี จนได้รับรางวัล มหาวิทยาลัยมหิดล สาขาการ บริการ เมื่อปี พ.ศ. ๒๕๓๖ และคณะกรรมการเอกลักษณ์ของชาติ สานักนายกรัฐมนตรีได้พิจารณา ให้เป็นโครงการดีเด่นแห่งชาติ สาขาอนุรักษ์ทรัพยากรธรรมชาติและสิ่งแวดล้อม (ด้านสมุนไพร) ประจำปี ๒๕๓๙");
        web2.setText("เว็ปไซต์ " + " http://www.sireepark.mahidol.ac.th/");
    }
}
