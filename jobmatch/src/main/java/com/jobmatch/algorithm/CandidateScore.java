package com.jobmatch.algorithm;

import com.jobmatch.models.*;

public class CandidateScore {
    private User user;
    private JobPost jobPost;
    private int closeness;

    public CandidateScore(User user, JobPost jobPost, int closeness){
        this.user = user;
        this.jobPost = jobPost;
        this.closeness = closeness;
    }

    public JobPost getJobPost() {
        return jobPost;
    }
    public int getCloseness() {
        return closeness;
    }
    public User getUser() {
        return user;
    }
}
