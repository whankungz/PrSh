package com.example.whankung.navigity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Whankung on 31/1/2560.
 */
public class DataFood extends AppCompatActivity {
    private View rootView;
    private Typeface font;
    private TextView tvI, nameI, namefI, frI, howf, howfdata, useF, useFdata, frF, frFdata;
    private ImageView i_Info, img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_food);
        setView();
        setData();

    }

    private void setView() {
        tvI = (TextView) findViewById(R.id.textI);
        nameI = (TextView) findViewById(R.id.nameI);
        namefI = (TextView) findViewById(R.id.namefI);
        frI = (TextView) findViewById(R.id.frI);
        howf = (TextView) findViewById(R.id.howf);
        howfdata = (TextView) findViewById(R.id.howfdata);
        useF = (TextView) findViewById(R.id.useF);
        useFdata = (TextView) findViewById(R.id.useFdata);
        frF = (TextView) findViewById(R.id.frF);
        frFdata = (TextView) findViewById(R.id.frFdata);

        i_Info = (ImageView) findViewById(R.id.i_Info);

        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tvI.setTypeface(font);
        nameI.setTypeface(font);
        namefI.setTypeface(font);
        frI.setTypeface(font);
        howf.setTypeface(font);
        howfdata.setTypeface(font);
        useF.setTypeface(font);
        useFdata.setTypeface(font);
        frF.setTypeface(font);
        frFdata.setTypeface(font);


        img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainFood.class);
                startActivity(intent);

            }
        });
    }

    private void setData() {
        i_Info.setImageResource(R.drawable.img_f2);
        nameI.setText("น้ำพริกผักลวก เพื่อสุขภาพ");
        frI.setText("ส่วนผสม น้ำพริกผักลวก เนื้อกุ้งหั่นชิ้นเล็ก 1 ถ้วย มันกุ้ง [ส่วนผสมเพื่อสุขภาพ] ทานแต่น้อย เพราะอุดมไปด้วยคอเลสเตอรอลสูง 7 ช้อนโต๊ะ น้ำปลา 2 ช้อนโต๊ะ น้ำมะนาว 4 ช้อนโต๊ะ น้ำตาลปี๊ป 1 ช้อนโต๊ะ หอมแดง 4-5 หัว พริกขี้หนูสวน 20 เม็ด กระเทียมกลีบเล็ก 10 กลีบ ผักสดหรือผักลวกต่างๆ ตามชอบ ");
        howfdata.setText("1.นึ่งมันกุ้ง และเนื้อกุ้งจนสุก โดยใช้เวลาในการนึ่งประมาณ 10 นาที เมื่อนึ่งจนสุกแล้วให้เอาออกมาพักไว้\n" +
                "2.โขลกพริก กระเทียม และหอมแดงจนละเอียด\n" +
                "3.ปรุงรสด้วยน้ำตาลปี๊ป น้ำมะนาว และน้ำปลา ในระหว่างนี้เพื่อให้น้ำตาลปี๊ปละลายง่ายขึ้น แนะนำให้ใช้สากค่อยๆ ยีส่วนผสมให้เละเข้ากัน ที่สำคัญเลยคือ น้ำตาลปี๊ปจะต้องละลายไม่จับตัวกันเป็นก้อนๆ\n" +
                "4.เมื่อเครื่องปรุงและส่วนผสมของน้ำพริกเข้ากันดีแล้ว ให้เติมมันกุ้งลงไปในครก\n" +
                "5.คนส่วนผสมภายในครกให้เข้ากันอีกครั้ง แล้วตักใส่ถ้วยจัดเสิร์ฟพร้อมผักเครื่องเคียงต่างๆ ตามชอบ เป็นอันเสร็จ ยกเสิร์ฟได้เลย\n");
        useFdata.setText("ส่วนประกอบที่สำคัญในการทำน้ำพริก พริกทุกชนิดมีสารแคปไซซิน ซึ่งเป็นสารที่มีคุณสมบัติในการป้องกันความชรา และยังมีเบต้าแคโรทีนและวิตามินซีสูง ต้านอนุมูลอิสระ\n" +
                "หอมแดง กระเทียม จะมีเซเลเนียมซึ่งเป็นสารต้านอนุมูลอิสระ");
        frFdata.setText("Thai Love Health (อาหารเพื่อสุขภาพ)");
    }
}
