package com.example.whankung.navigity.services.InRating;

import com.example.whankung.navigity.services.DRating.DRatRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface InRatInterface {


    @GET("entity.class.infographicrating")
    Call<List<InRatRequest>> loadJson();




    @POST("")
    Call<InRatRequest> postJson(@Body InRatRequest body);

}
