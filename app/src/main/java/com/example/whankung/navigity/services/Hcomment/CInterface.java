package com.example.whankung.navigity.services.Hcomment;

import com.example.whankung.navigity.services.Disease.DRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface CInterface {


    @GET("entity.class.herbcomment")
    Call<List<CRequest>> loadJson();




    @POST("")
    Call<CRequest> postJson(@Body CRequest body);

}
