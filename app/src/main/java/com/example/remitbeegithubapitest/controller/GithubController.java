package com.example.remitbeegithubapitest.controller;

import com.example.remitbeegithubapitest.Listners.GithubListner;
import com.example.remitbeegithubapitest.api.GithubApi;
import com.example.remitbeegithubapitest.api.RestApiManager;
import com.example.remitbeegithubapitest.model.githubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GithubController {
    private GithubListner mListener;
    private RestApiManager mApiManager;

    public GithubController(GithubListner listener) {
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
        //calling
        GithubApi service = mApiManager.getRetrofitInstance().create(GithubApi.class);
        Call<List<githubModel>> call = service.getAllCommits();
        call.enqueue(new Callback<List<githubModel>>() {
            @Override
            public void onResponse(Call<List<githubModel>> call, Response<List<githubModel>> response) {
                //passing data to mainactivity
                mListener.onFetchComplete(response.body());
            }

            @Override
            public void onFailure(Call<List<githubModel>> call, Throwable t) {
//failed
            }
        });


    }
}
