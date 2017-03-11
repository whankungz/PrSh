package com.example.whankung.navigity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView tv, pro;
    QuickReturnFloaterBehavior behavior;
    ConnectionClass connectionClass;
    private View nav_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectionClass = new ConnectionClass();
        tv = (TextView) findViewById(R.id.toolbar_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, new MainHerb());
        transaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.action_herb:
                                FragmentManager manager = getSupportFragmentManager();
                                FragmentTransaction transaction = manager.beginTransaction();
                                transaction.replace(R.id.container, new MainHerb());
                                transaction.commit();

                                //     tv.setText("สมุนไพร");
                                break;
                            case R.id.action_disea:
                                manager = getSupportFragmentManager();
                                transaction = manager.beginTransaction();
                                transaction.replace(R.id.container, new MainDisease());
                                transaction.commit();
//                                tv.setText("อาการ/โรค");
                                break;
                            case R.id.action_arti:
                                manager = getSupportFragmentManager();
                                transaction = manager.beginTransaction();
                                transaction.replace(R.id.container, new MainArticle());
                                transaction.commit();
                                //   tv.setText("บทความ");
                                break;
                            case R.id.action_info:
                                manager = getSupportFragmentManager();
                                transaction = manager.beginTransaction();
                                transaction.replace(R.id.container, new MainFavorite());
                                transaction.commit();
                                //     tv.setText("รายการโปรด");
                                break;
                            case R.id.action_fav:
                                manager = getSupportFragmentManager();
                                transaction = manager.beginTransaction();
                                transaction.replace(R.id.container, new MainFavorite());
                                transaction.commit();
                                //     tv.setText("รายการโปรด");
                                break;
                        }
                        return true;
                    }
                });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


//        View nav_header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
//        navigationView.addHeaderView(nav_header);
//        pro=(TextView) nav_header.findViewById(R.id.namePro);
//        pro.setText( "wwwwww");
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_invite).setVisible(false);
        nav_header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);


        if (AppState.getSingleInstance().isLogin()) {
            navigationView.addHeaderView(nav_header);
            pro = (TextView) nav_header.findViewById(R.id.namePro);
            pro.setText(AppState.getSingleInstance().getNamePhama());
            navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_invite).setVisible(true);
            AppState.getSingleInstance().setLogin(false);

//            Singleton.getInstance().setYourFormattedString(yourFormattedString);
//            Singleton.getInstance().setYourFormattedString2(yourFormattedString2);
//            Singleton.getInstance().setYourFormattedString3(yourFormattedString3);
        }
//setLogin();
    }

    private void setLogin() {
        if (AppState.getSingleInstance().setLoggingOut(true)) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_invite).setVisible(false);
        } else {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_invite).setVisible(true);

            //   navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);


        } else if (id == R.id.nav_food) {


        } else if (id == R.id.nav_office) {

        } else if (id == R.id.nav_share) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container, new ShareF());
            transaction.commit();
        } else if (id == R.id.nav_invite) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container, new Invite());
            transaction.commit();

        } else if (id == R.id.nav_logout) {
            SharedPreferences myPrefs = getSharedPreferences("MY",
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.clear();
            editor.commit();
            AppState.getSingleInstance().setLoggingOut(true);
            String TAG = "";
            Log.d(TAG, "Now log out and start the activity login");
            Intent intent = new Intent(MainActivity.this,
                    Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.getMenu().findItem(R.id.nav_login).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_invite).setVisible(false);


            pro.setVisibility(View.GONE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setLoginState(boolean status) {

        SharedPreferences sp = getSharedPreferences("LoginState",
                MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("setLoggingOut", status);
        ed.commit();
    }


}
