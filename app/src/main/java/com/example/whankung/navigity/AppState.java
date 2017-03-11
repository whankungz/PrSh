package com.example.whankung.navigity;

import android.support.v4.app.Fragment;

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


    private GeneralHerbFragment ge;

    public GeneralHerbFragment getGe() {
        return ge;
    }

    public void setGe(GeneralHerbFragment ge) {
        this.ge = ge;
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

    public void setDataHerb(String dataHerb) {
        this.dataHerb = dataHerb;
    }
    public boolean isDataHerb2() {
        return dataHerb2;
    }

    public void setDataHerb2(boolean dataHerb2) {
        this.dataHerb2 = dataHerb2;
    }
}
