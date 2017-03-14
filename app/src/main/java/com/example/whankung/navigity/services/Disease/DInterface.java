package com.example.whankung.navigity.services.Disease;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface DInterface {


    @GET("entity.class.disease")
    Call<List<DRequest>> loadJson();




    @POST("")
    Call<DRequest> postJson(@Body DRequest body);

}
