package com.example.whankung.navigity.services;

import com.example.whankung.navigity.services.Article.AInterface;
import com.example.whankung.navigity.services.Disease.DInterface;
import com.example.whankung.navigity.services.Food.FInterface;
import com.example.whankung.navigity.services.Herb.HInterface;
import com.example.whankung.navigity.services.Herb.HimgInterface;
import com.example.whankung.navigity.services.Herb.HreInterface;
import com.example.whankung.navigity.services.InfoG.InfoInterface;
import com.example.whankung.navigity.services.Office.OfInterface;
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
    HreInterface herbre;
    HimgInterface herbimg;
    AInterface article;
    FInterface food;
    InfoInterface info;
    OfInterface office;


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
        herbimg = retrofit.create(HimgInterface.class);
        herbre = retrofit.create(HreInterface.class);
        article = retrofit.create(AInterface.class);
        food = retrofit.create(FInterface.class);
        info = retrofit.create(InfoInterface.class);
        office = retrofit.create(OfInterface.class);
    }

    public InfoInterface getInfo() {
        return info;
    }

    public OfInterface getOffice() {
        return office;
    }

    public FInterface getFood() {
        return food;
    }

    public DInterface getDisease() {
        return disease;
    }

    public HInterface getHerb() {
        return herb;
    }

    public HreInterface getHerbre() {
        return herbre;
    }

    public HimgInterface getHerbimg() {
        return herbimg;
    }

    public AInterface getArticle() {
        return article;
    }
}
