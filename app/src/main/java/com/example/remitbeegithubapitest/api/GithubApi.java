package com.example.remitbeegithubapitest.api;
import com.example.remitbeegithubapitest.model.githubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GithubApi {
    @GET("commits")
    Call<List<githubModel>> getAllCommits();



}
