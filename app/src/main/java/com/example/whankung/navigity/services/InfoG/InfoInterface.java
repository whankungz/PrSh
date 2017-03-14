package com.example.whankung.navigity.services.InfoG;

import com.example.whankung.navigity.services.Article.ArRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Whankung on 21/2/2560.
 */

public interface InfoInterface {


    @GET("entity.class.article")
    Call<List<InRequest>> loadJson();




    @POST("")
    Call<InRequest> postJson(@Body InRequest body);

}
