package com.andro.listndetails.api;

import android.content.Context;

import com.andro.listndetails.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andro on 1/14/2017.
 */

public class ApiManager {

    private String apiKey;

    private MovieApi mMovieApi;

    public ApiManager(Context context) {
        apiKey = context.getString(R.string.api_key);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.baseURL))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        mMovieApi = retrofit.create(MovieApi.class);
    }

    public void discover(int page, Callback callback) {
        mMovieApi.discover(page, apiKey).enqueue(callback);
    }
}
