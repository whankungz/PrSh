package com.example.whankung.navigity.services.Article;

import com.example.whankung.navigity.services.Disease.DRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface AInterface {


    @GET("entity.class.article")
    Call<List<ArRequest>> loadJson();




    @POST("")
    Call<ArRequest> postJson(@Body ArRequest body);

}
