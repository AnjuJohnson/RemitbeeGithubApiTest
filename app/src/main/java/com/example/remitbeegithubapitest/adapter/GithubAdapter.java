package com.example.remitbeegithubapitest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.remitbeegithubapitest.R;
import com.example.remitbeegithubapitest.model.githubModel;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.Holder> {
    private List<githubModel> mCommitList;

    public GithubAdapter(List<githubModel> commit) {
        mCommitList = commit;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        githubModel currentFlower = mCommitList.get(position);
        holder.mName.setText(currentFlower.getCommit().getCommitter().getName());
        holder.mDate.setText("Committed date: "+currentFlower.getCommit().getCommitter().getDate());
        holder.mMessage.setText("Commit message : "+currentFlower.getCommit().getMessage());
    }

    @Override
    public int getItemCount() {
        return mCommitList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mName,mDate,mMessage;
        public ImageView mImage;

        public Holder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.commmit);
            mDate = (TextView) itemView.findViewById(R.id.date);
            mMessage = (TextView) itemView.findViewById(R.id.message);

        }
    }
}
