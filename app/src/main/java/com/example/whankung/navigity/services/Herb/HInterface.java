package com.example.whankung.navigity.services.Herb;

import com.example.whankung.navigity.services.Disease.DRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface HInterface {


    @GET("entity.class.herb"+"entity.class.herbimg"+"entity.class.herbresearch")
    Call<List<HRequest>> loadJson();





    @POST("")
    Call<HRequest> postJson(@Body HRequest body);

}
