package com.andro.listndetails.api;

import com.andro.listndetails.models.Discover;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by andro on 1/14/2017.
 */

public interface MovieApi {
    @GET("discover/movie/")
    Call<Discover> discover(@Query("page") int page,
                            @Query("api_key") String apiKey);
}
