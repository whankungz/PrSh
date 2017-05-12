package com.example.whankung.navigity.services.DRating;

import com.example.whankung.navigity.services.HerbRating.RatRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface DRatInterface {


    @GET("entity.class.diseaserating")
    Call<List<DRatRequest>> loadJson();




    @POST("")
    Call<DRatRequest> postJson(@Body DRatRequest body);

}
