package com.example.remitbeegithubapitest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.remitbeegithubapitest.Listners.GithubListner;
import com.example.remitbeegithubapitest.R;
import com.example.remitbeegithubapitest.adapter.GithubAdapter;
import com.example.remitbeegithubapitest.controller.GithubController;
import com.example.remitbeegithubapitest.model.githubModel;

import java.util.List;

public class GithubActivity extends AppCompatActivity implements GithubListner {
    private RecyclerView mRecyclerView;
    private GithubController mController;
    private GithubAdapter githubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mController = new GithubController(GithubActivity.this);
        //initialise views
        configViews();
        //fetching data from server
        mController.startFetching();
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(GithubActivity.this));
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());

    }


    @Override
    public void onFetchComplete(List<githubModel> commitlist) {
        //passing data to adapter
        githubAdapter = new GithubAdapter(commitlist);
        mRecyclerView.setAdapter(githubAdapter);
    }

    @Override
    public void onFetchFailed() {
        //if failed
        System.out.println("failed");

    }
}