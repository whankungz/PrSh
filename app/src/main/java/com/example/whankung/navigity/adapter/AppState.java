package com.example.whankung.navigity.adapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Whankung on 11/3/2560.
 */

public class AppState{
    private static AppState singleInstance;

    private boolean isLoggingOut;
    private boolean isLogin;
    private String namePhama;
    private String dataHerb;
    private boolean dataHerb2;

    private static String indexlist;
    private boolean rating;

    public static Boolean getFirstOpenApp() {
        return firstOpenApp;
    }

    public static void setFirstOpenApp(Boolean firstOpenApp) {
        AppState.firstOpenApp = firstOpenApp;
    }



        public boolean isNetworkAvailables(Context context) {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();


    }
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private String nameH;

    private static Boolean firstOpenApp;

    public String getRegis() {
        return regis;
    }

    public void setRegis(String regis) {
        this.regis = regis;
    }

    private String regis;
    public String getNameH() {
        return nameH;
    }

    public void setNameH(TextView nameH) {

    }

    public boolean isRating(boolean b) {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }

    private AppState() {

    }

    public static AppState getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new AppState();
        }
        return singleInstance;
    }

    public boolean isLoggingOut() {
        return isLoggingOut;
    }

    public boolean setLoggingOut(boolean isLoggingOut) {
        this.isLoggingOut = isLoggingOut;
        return isLoggingOut;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        this.isLogin = isLogin;
        isLogin = login;
    }

    public String getNamePhama() {
        return namePhama;
    }

    public void setNamePhama(String namePhama) {
        this.namePhama = namePhama;
    }

    public String getDataHerb() {
        return dataHerb;
    }

    public void setDataHerb(String[] dataHerb) {

    }

    public boolean isDataHerb2(boolean b) {
        return dataHerb2;
    }

    public void setDataHerb2(boolean dataHerb2) {
        this.dataHerb2 = dataHerb2;
    }


    public String getIndexlist() {
        return indexlist;
    }

    public void setIndexlist(ImageView indexlist) {

    }
}
