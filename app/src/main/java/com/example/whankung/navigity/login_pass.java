package com.example.whankung.navigity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Whankung on 16/2/2560.
 */

public class login_pass extends AppCompatActivity {

private TextView pro;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);


        pro=(TextView)findViewById(R.id.namePro);
        pro.setText("qqqq");
    }


}
