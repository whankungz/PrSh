package com.example.whankung.socialherb.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.whankung.socialherb.R;

/**
 * Created by Whankung on 18/1/2560.
 */

public class Toolbar extends AppCompatActivity {
    private Typeface font;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_toolbar_login);
        setView();


    }

    private void setView() {
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");


    }
}
