package com.example.whankung.navigity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Whankung on 15/2/2560.
 */
public class Login extends AppCompatActivity {
    private Typeface font;

    EditText edtuserid, edtpass;


    TextView login, skip, head, regis;
    ProgressBar progressBar;
    NavigationView navigationView;
    ConnectionClass connectionClass;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        connectionClass = new ConnectionClass();
        setView();


    }

    private void setView() {


//        ImageView img = (ImageView)rootView.findViewById(R.id.action_login);
//        img.setVisibility(View.VISIBLE);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //กลับไปยังหน้าเลือกเภสัช
//                Intent intent = new Intent(getApplicationContext(), Menu.class);
//                startActivity(intent);
//
//            }
//        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        skip = (TextView) findViewById(R.id.skip);
        head = (TextView) findViewById(R.id.textView4);
        login = (TextView) findViewById(R.id.textView);
        regis = (TextView) findViewById(R.id.textView2);
        edtuserid = (EditText) findViewById(R.id.user);
        edtpass = (EditText) findViewById(R.id.password);

//        เปลี่ยนfont
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        skip.setTypeface(font);
        head.setTypeface(font);
        edtuserid.setTypeface(font);
        edtpass.setTypeface(font);
        login.setTypeface(font);
        regis.setTypeface(font);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckLogin checkLogin = new CheckLogin();// this is the Asynctask, which is used to process in background to reduce load on app process
                checkLogin.execute("");
            }
        });


////หน้าแรก
//        skip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), Menu.class);
//                startActivity(intent);
////                getActivity().finish();
//            }
//        });
    }
        public class CheckLogin extends AsyncTask<String, String, String> {
            String z = "";
            Boolean isSuccess = false;

            @Override
            protected void onPreExecute() {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String r) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Login.this, r, Toast.LENGTH_SHORT).show();
                if (isSuccess) {
                    Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_LONG).show();
                    //finish();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                String userid = edtuserid.getText().toString();
                String password = edtpass.getText().toString();

                if (userid.trim().equals("") || password.trim().equals(""))
                    z = "Please enter Username and Password";
                else {
                    try {
                        Connection con = connectionClass.connection();       // Connect to database
                        if (con == null) {
                            z = "Check Your Internet Access!";
                        } else {

                            String query = "select * from Pharmacist where username= '" + userid.toString() + "' and password = '" + password.toString() + "'  ";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next()) {
                                z = "Login Successful";
                                isSuccess = true;

                                login.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

//                        //        click login
//                        navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
//                        navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);

                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);


                                    }
                                });
                                con.close();
                            } else {
                                z = "Invalid Credentials!";
                                isSuccess = false;

                            }
                        }
                    } catch (Exception ex) {
                        isSuccess = false;
                        z = ex.getMessage();
                    }
                }
                return z;

            }
        }
    }

