package com.example.whankung.navigity.services.Herb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface HimgInterface {


    @GET("entity.class.herbimg")
    Call<List<HimgRequest>> loadJson();




    @POST("")
    Call<HimgRequest> postJson(@Body HimgRequest body);

}
