package com.example.whankung.navigity.services.Office;

import com.example.whankung.navigity.services.Article.ArRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface OfInterface {


    @GET("entity.class.contact")
    Call<List<OfRequest>> loadJson();




    @POST("")
    Call<OfRequest> postJson(@Body OfRequest body);

}
