package com.example.remitbeegithubapitest.Listners;

import com.example.remitbeegithubapitest.model.githubModel;

import java.util.List;

public interface GithubListner {
    void onFetchComplete(List<githubModel> commitlist);
    void onFetchFailed();
}
