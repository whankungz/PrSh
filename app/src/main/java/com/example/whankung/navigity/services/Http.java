package com.example.whankung.navigity.services;

import com.example.whankung.navigity.services.Disease.DInterface;
import com.example.whankung.navigity.services.Herb.HInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.whankung.navigity.SearchDisease.BASE_URL;

/**
 * Created by Whankung on 21/2/2560.
 */

public class Http {
    private static Http instance;
    DInterface disease;
    HInterface herb;


    public static Http getInstance() {

        return new Http();
    }

    private Http() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        disease = retrofit.create(DInterface.class);
        herb = retrofit.create(HInterface.class);
    }


    public DInterface getDisease() {
        return disease;
    }

    public HInterface getHerb() {
        return herb;
    }

}
