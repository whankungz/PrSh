package com.example.whankung.navigity.services.Food;

import com.example.whankung.navigity.services.Article.ArRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface FInterface {


    @GET("entity.class.healthfood")
    Call<List<FRequest>> loadJson();




    @POST("")
    Call<FRequest> postJson(@Body FRequest body);

}
