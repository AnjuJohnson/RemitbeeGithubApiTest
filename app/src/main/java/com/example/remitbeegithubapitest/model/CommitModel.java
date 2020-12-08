package com.example.remitbeegithubapitest.model;

public class CommitModel {
    private Commiter committer;
    private String message;

    public Commiter getCommitter() {
        return committer;
    }

    public void setCommitter(Commiter committer) {
        this.committer = committer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
