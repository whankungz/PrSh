package com.example.whankung.navigity.services;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.compat.BuildConfig;



public class AdeptAndroid extends Application {

    public static AdeptAndroid instance;

    @Override
    public void onCreate()
    {
        super.onCreate();

        instance = this;

        if (BuildConfig.DEBUG)
        {

        }


    }

    public static AdeptAndroid getInstance ()
    {
        return instance;
    }

    public static boolean hasNetwork ()
    {
        return instance.checkIfHasNetwork();
    }

    public boolean checkIfHasNetwork()
    {
        boolean state;
        ConnectivityManager cmg = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cmg.getActiveNetworkInfo();
        state = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (state) {
            return true;
        } else {
            //NO interntet
            return false;
        }

//        ConnectivityManager cm = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
//        return networkInfo != null && networkInfo.isConnected();
    }
}
