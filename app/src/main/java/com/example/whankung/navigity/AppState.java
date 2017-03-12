package com.example.whankung.navigity;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

/**
 * Created by Whankung on 11/3/2560.
 */

public class AppState {
    private static AppState singleInstance;

    private boolean isLoggingOut;
    private boolean isLogin;
    private String namePhama;
    private String dataHerb;
    private boolean dataHerb2;

    private static String indexlist;
    private boolean rating;

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
