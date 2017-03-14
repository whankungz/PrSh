package com.example.whankung.navigity.services.Herb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface HreInterface {


    @GET("entity.class.herbresearch")
    Call<List<HRequest>> loadJson();





    @POST("")
    Call<HRequest> postJson(@Body HRequest body);

}
