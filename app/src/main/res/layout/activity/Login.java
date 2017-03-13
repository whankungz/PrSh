package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whankung.socialherb.R;
import com.mikepenz.materialdrawer.Drawer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Whankung on 17/1/2560.
 */

public  class Login extends AppCompatActivity {
    private Drawer result = null;
    private Typeface font;

    EditText edtuserid, edtpass;


    TextView login, skip, head, regis;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SessionManagement session;
    ProgressBar progressBar;
    Connection con;
    private String un, pass, db, ip;
    ConnectionClass connectionClass;

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        connectionClass = new ConnectionClass();
        setView();

        //  setLogin();


    }

    private void setView() {

        ImageView img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือกเภสัช
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });
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


//หน้าแรก
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
//                getActivity().finish();
            }
        });
//เข้าสู่ระบบ

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Menu.class);
//                startActivity(intent);
//
//
//            }
//        });
//ลงทะเบียน
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.Register.class);
                startActivity(intent);

            }
        });
//        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(R.string.drawer_item_menu_drawer);
//        final Drawer drawer = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withActionBarDrawerToggle(true)
////                .withAccountHeader(accountHeader)
//                .withCloseOnClick(true)
//                .withSliderBackgroundColorRes(R.color.md_light_primary_text)
//
//    .addDrawerItems(
//                new PrimaryDrawerItem()
//                        .withIcon(FontAwesome.Icon.faw_sign_out)
//                        .withName("ออกจากระบบ")
//                        .withSelectable(false)
//                        .withIconColor(getResources().getColor(R.color.md_grey_100))
//                        .withTextColorRes(R.color.md_grey_100)
//                        .withIdentifier(4)
//       ).build();
//

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
            Toast.makeText(com.example.whankung.socialherb.activity.Login.this, r, Toast.LENGTH_SHORT).show();
            if (isSuccess) {
                Toast.makeText(com.example.whankung.socialherb.activity.Login.this, "Login Successfull", Toast.LENGTH_LONG).show();
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
                                    Intent intent = new Intent(getApplicationContext(), Menu.class);
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


    private void setLogin() {


        //login
        // Session Manager
        session = new SessionManagement(getApplicationContext());

        // Email, Password input text


        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();


        // Login
        login = (TextView) findViewById(R.id.textView);


        // Login button click event
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
            }
//                // Get username, password from EditText
//                String username = user.getText().toString();
//                String Password = password.getText().toString();
//
//                // Check if username, password is filled
//                if (username.trim().length() > 0 && Password.trim().length() > 0) {
//                    // For testing puspose username, password is checked with sample data
//                    // username = test
//                    // password = test
//                    if (username.equals("whan") && Password.equals("1234")) {
//
//
//
//                      // Creating user login session
//                        // For testing i am stroing name, email as follow
//                        // Use user real data
//
//                        session.createLoginSession("Android Hive","sfd");
//
//
//                        // Staring MainActivity
//
//                        Intent i = new Intent(getApplicationContext(), Menu.class);
//                        startActivity(i);
//
//
//
//                    } else {
//                        // username / password doesn't match
//                        alert.showAlertDialog(Login.this, "Login failed..", "Username/Password is incorrect", false);
//                    }
//                } else {
//                    // user didn't entered username or password
//                    // Show alert asking him to enter the details
//                    alert.showAlertDialog(Login.this, "Login failed..", "Please enter username and password", false);
//                }
//
//            }
        });

        final android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.drawer_item_menu_drawer);

//        result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .inflateMenu(R.menu.main2)
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
////                        if (drawerItem instanceof Nameable) {
////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
////                        }
//                        FragmentManager manager = getSupportFragmentManager();
//                        FragmentTransaction transaction = manager.beginTransaction();
//                        switch (position) {
//                            case 0:
//                                Intent intent = new Intent(getApplicationContext(), Login.class);
//                                startActivity(intent);
//
//
//
//                                break;
//
//                        }
//                        return false;
//                    }
//                }).build();
    }


}
