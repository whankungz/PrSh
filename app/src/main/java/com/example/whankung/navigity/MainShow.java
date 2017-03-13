package com.example.whankung.navigity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import static android.view.View.GONE;

/**
 * Created by Whankung on 13/3/2560.
 */

public class MainShow extends AppCompatActivity {
    private ProgressBar progressBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_show_logo);
      setview();
    }

    private void setview() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        CountDownTimer cdt = new CountDownTimer(4000, 400) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        }.start();
    }
}
