package com.example.whankung.navigity;

/**
 * Created by Whankung on 11/3/2560.
 */

public class AppState {
    private static AppState singleInstance;

    private boolean isLoggingOut;
    private boolean isLogin;
    private String namePhama;



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
        this.isLogin=isLogin;
        isLogin = login;
    }
    public String getNamePhama() {
        return namePhama;
    }

    public void setNamePhama(String namePhama) {
        this.namePhama = namePhama;
    }
}
