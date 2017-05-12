package com.example.whankung.navigity.services.HerbRating;

import com.example.whankung.navigity.services.Disease.DRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface RatInterface {


    @GET("entity.class.herbrating")
    Call<List<RatRequest>> loadJson();




    @POST("")
    Call<RatRequest> postJson(@Body RatRequest body);

}
