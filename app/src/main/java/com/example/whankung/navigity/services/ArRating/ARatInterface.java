package com.example.whankung.navigity.services.ArRating;

import com.example.whankung.navigity.services.DRating.DRatRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface ARatInterface {


    @GET("entity.class.diseaserating")
    Call<List<ARatRequest>> loadJson();




    @POST("")
    Call<ARatRequest> postJson(@Body DRatRequest body);

}
