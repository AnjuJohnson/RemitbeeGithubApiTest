package com.example.remitbeegithubapitest.api;

import com.example.remitbeegithubapitest.utilities.Constants;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestApiManager {

    private static Retrofit retrofit;
    //creating retrofit instance
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15000, TimeUnit.SECONDS)
                    .readTimeout(15000,TimeUnit.SECONDS).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

}
