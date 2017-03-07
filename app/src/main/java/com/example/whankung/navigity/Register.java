package com.example.whankung.navigity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.whankung.navigity.ConnectionClass;
import com.example.whankung.navigity.Login;
import com.example.whankung.navigity.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * Created by Whankung on 18/1/2560.
 */

public class Register extends AppCompatActivity {
    private Typeface font;
    private Button button;
    private ConnectionClass connectionClass;
    private EditText u, p, m, s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        connectionClass = new ConnectionClass();
        setView();
    }

    private void setView() {
        TextView regis2 = (TextView) findViewById(R.id.regis);
        TextView regis_bar = (TextView) findViewById(R.id.textView);
        u = (EditText) findViewById(R.id.username);
        p = (EditText) findViewById(R.id.pass);
        m = (EditText) findViewById(R.id.mail);
        TextView sex = (TextView) findViewById(R.id.sex);


        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        regis2.setTypeface(font);
        regis_bar.setTypeface(font);
        u.setTypeface(font);
        p.setTypeface(font);
        m.setTypeface(font);
        sex.setTypeface(font);



        regis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBOperation dbOperation = new DBOperation();
                try {
                    dbOperation.getAllUsers();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dbOperation.addUser();


                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);


            }
        });


        ImageView img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือก ถาคของเรา
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });

        SegmentedGroup segmented2 = (SegmentedGroup) findViewById(R.id.segmented2);
        segmented2.setTintColor(Color.DKGRAY);

        RadioButton man = (RadioButton) findViewById(R.id.man);
        RadioButton wman = (RadioButton) findViewById(R.id.woman);

        man.setTypeface(font);
        wman.setTypeface(font);

    }

    //
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.dbtest, menu);
//        return true;
//
//    }



    @Override
    protected void onResume() {

        super.onResume();
        (new DBConnection()).execute(null, null, null);

    }

    @Override
    protected void onPause() {

        super.onPause();
        try {
            Connection con = connectionClass.connection();
            con.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    class DBConnection extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... arg0) {
            String us = u.getText().toString();
            String ps= p.getText().toString();
            String em = m.getText().toString();
            try {

                Log.e("MSSQL", "Attempting to connect");

                Connection con = connectionClass.connection();
//                Class.forName("net.sourceforge.jtds.jdbc.Driver");
//                conn = (Connection) DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.233.51/SocialHerb;user=sa;password=1234");

                Log.e("MSSQL", "Connected");

            } catch (Exception e) {

                e.printStackTrace();
                Log.e("MSSQL", e.toString());

            }

            return null;
        }

    }

    class UserInfo {


        String username;
        String password;
        String email;


        public UserInfo(String username, String password,
                        String email) {


            this.username = username;

            this.password = password;
            this.email = email;

        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


    }

    class DBOperation {

        public List<UserInfo> getAllUsers() throws SQLException {
            Connection con = connectionClass.connection();
            Statement statement = getStatement((Connection) con);

            List<UserInfo> userlist = new ArrayList<UserInfo>();

            ResultSet rs = statement.executeQuery("SELECT * FROM Pharmacist");
            rs.next();
            int count = 0;

            while (rs.next()) {

                userlist.add(new UserInfo(rs.getString(1), rs.getString(2),
                        rs.getString(3)));
                count++;

            }

            rs.close();
            statement.close();
            return userlist;

        }

        public void addUser() {
            String us = u.getText().toString();
            String ps= p.getText().toString();
            String em = m.getText().toString();
            Log.e("MSSQL", "in adduser");
            Connection con = connectionClass.connection();
            Statement statement = getStatement((Connection) con);

            try {

                ResultSet rs = statement.executeQuery("INSERT INTO Pharmacist "
                        + "  VALUES ("+us.toString()+" ,"+ps.toString()+" , "+em.toString()+")");

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
        }

    }


}
