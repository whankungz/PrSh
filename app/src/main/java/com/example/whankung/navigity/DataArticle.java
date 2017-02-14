package com.example.whankung.navigity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Whankung on 24/1/2560.
 */

public class DataArticle extends android.support.v4.app.Fragment {
    private View rootView;
    private Typeface font;
    private ImageView i;
    private TextView t, t2, t3, t4, t5, t6,nm, un, date;
    private String link = "http://www.thaihealth.or.th/Content/35077-%E2%80%98%E0%B9%82%E0%B8%A3%E0%B8%84%E0%B8%AD%E0%B9%89%E0%B8%A7%E0%B8%99%E2%80%99%20%E0%B8%A1%E0%B8%AB%E0%B8%B1%E0%B8%99%E0%B8%95%E0%B8%A0%E0%B8%B1%E0%B8%A2%E0%B8%A1%E0%B8%B7%E0%B8%94%E0%B8%A1%E0%B8%99%E0%B8%B8%E0%B8%A9%E0%B8%A2%E0%B9%8C%E0%B9%80%E0%B8%A1%E0%B8%B7%E0%B8%AD%E0%B8%87.html";
    private RatingBar rat;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.data_article, container, false);
        setView();
        setData();
        setRating();

        return rootView;
    }
    private void setRating() {

    }

    private void setView() {
//        date = (TextView) rootView.findViewById(R.id.date);
//        nm = (TextView) rootView.findViewById(R.id.nameMe);
//        un = (TextView) rootView.findViewById(R.id.Uname);
        t = (TextView) rootView.findViewById(R.id.nameA);
        t2 = (TextView) rootView.findViewById(R.id.nameDdataA);
        t3 = (TextView) rootView.findViewById(R.id.namef);
        t4 = (TextView) rootView.findViewById(R.id.namefda);
        t5 = (TextView) rootView.findViewById(R.id.namefdat);
        t6 = (TextView) rootView.findViewById(R.id.submit);
        i = (ImageView) rootView.findViewById(R.id.imageView2_b);

        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        t.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);
//        nm.setTypeface(font);
//        un.setTypeface(font);
//        date.setTypeface(font);

    }

    private void setData() {
        i.setImageResource(R.drawable.img_a);
        t2.setText("‘โรคอ้วน’ มหันตภัยมืดมนุษย์เมือง");
        t3.setText("สาเหตุการเสียชีวิตของคนในสังคมยุคปัจจุบันจากข้อมูลขององค์การอนามัยโลก (WHO) พบว่า เกิดจากโรคที่ไม่ติดต่อเรื้อรังมากกว่าโรคที่เกิดจากการติดเชื้อ ซึ่งนับวันยิ่งทวีความรุนแรงมากขึ้นเรื่อยๆ โดยสาเหตุหลักโรคเหล่านี้จุดเริ่มต้นมาจากไลฟ์สไตล์การใช้ชีวิตบนพฤติกรรมเสี่ยง เช่น ขาดการออกกำลังกาย ดื่มสุรา สูบบุหรี่ ชอบรับประทานอาหารรสหวานมันเค็มจัด ปัจจัยเหล่านี้จึงเป็นภัยร้ายที่แทรกซึมฆ่าชีวิตของคนโดยเฉพาะในสังคมเมือง ผศ.นพ.ธีระ วรธนารัตน์ อาจารย์ภาควิชาเวชศาสตร์ป้องกันและสังคม คณะแพทยศาสตร์ จุฬาลงกรณ์มหาวิทยาลัย อธิบายว่า โรคอ้วน เบาหวาน ความดัน ไขมันสูง โรคหัวใจหลอดเลือด โรคสมองตีบแตกตัน โรคเหล่านี้มักจะมาเป็นแพ็กเกจ ซึ่งเกิดจากการใช้ชีวิตแบบชาวตะวันตก ภายใต้บริบทการพัฒนาของสังคมเมือง ที่ทำให้คนมีวิถีชีวิตเปลี่ยนไป รักความสบาย เคลื่อนไหวน้อย มีสิ่งอำนวยความสะดวกทางด้านพฤติกรรมมากขึ้น โดยเฉพาะการกิน อย่างไรก็ตาม หลักความเป็นจริงคนไทยในอดีตที่มีสุขภาพแข็งแรง เพราะวิถีการดำรงชีวิตนิยมรับประทานอาหารพวกพืชผักผลไม้ตามธรรมชาติเป็นส่วนใหญ่ แต่ปัจจุบันความเป็นสังคมเมืองกลับเลือกรับประทานอาหารที่สะดวก มีรสหวานเค็มมัน ซึ่งมีไขมันเยอะ จนก่อนให้เกิดผลกระทบต่อร่างกาย เมื่อเป็นเช่นนี้จึงทำให้เสี่ยงที่จะเป็นโรคอ้วน จากการศึกษาพบว่า เดิมคนไทยน้ำหนักเกินค่าเฉลี่ยอยู่ 10% แต่ปัจจุบันในกลุ่มผู้ใหญ่มีน้ำหนักเกินถึง 30% ส่วนกลุ่มเด็กในเมืองน้ำหนักเกินอยู่ที่ 12.5% ซึ่งถือว่าเยอะมากกว่าเมืองในอดีต ผลลัพธ์เหล่านี้จึงเป็นปัจจัยเสี่ยงต่อร่างกายในระยะยาว ผศ.นพ.ธีระ แนะนำว่า ทางแก้สามารถปฏิบัติได้ 2 วิธี คือ เริ่มที่ตัวบุคคล ควรใส่ใจไปพร้อมกับต้องมีความรู้ในการเลือกรับประทานอาหารที่ไม่เสี่ยงต่อสุขภาพ รวมถึงต้องมีความระงับยับยั้งชั่งใจว่า จะเชื่อหรือไม่กับข้อมูลบนโซเชียลมีเดีย ส่วนภาครัฐ และภาคธุรกิจก็ควรใส่ใจคุณภาพชีวิตของประชาชนเช่นกัน แต่การที่รัฐออกนโยบายสาธารณะเพื่อสนับสนุนให้เอกชนเข้ามาลงทุนเปิดกิจการร้านอาหารหวังการไหลเวียนของเม็ดเงิน โดยไม่ใส่ใจว่าธุรกิจเหล่านั้น จะส่งผลกระทบต่อสุขภาพคนไทยระยะยาว ดังนั้น รัฐควรปรับตัวรู้เท่าทันสภาวการณ์พัฒนาด้านเศรษฐกิจและสังคม ควบคู่ไปกับการประเมินผลกระทบต่อสุขภาพประชาชน เช่น อาจขอความร่วมมือร้านอาหารฟาสต์ฟู้ดไม่ควรโฆษณาการเพิ่มขนาดอาหาร ด้วยเงินเพียงน้อยนิด เพราะยิ่งจะเป็นการเสี่ยงต่อสุขภาพ หรือขอความร่วมมือให้ทุกร้านมีเมนูอาหารเพื่อสุขภาพ ไปจนถึงมาตรการขึ้นภาษี แต่ถึงอย่างไรมาตรการควบคุมเหล่านี้ไม่ใช้เพื่อกีดกันทางการค้า แต่เพื่อสร้างทางเลือกคู่ขนานให้กับผู้บริโภค");
        t5.setText("เว็บไซต์โพสต์ทูเดย์");



    }
}
