package com.jobmatch.algorithm;

import com.jobmatch.models.JobPost;
import com.jobmatch.models.User;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateScore that = (CandidateScore) o;

        if (closeness != that.closeness) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return jobPost != null ? jobPost.equals(that.jobPost) : that.jobPost == null;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (jobPost != null ? jobPost.hashCode() : 0);
        result = 31 * result + closeness;
        return result;
    }

    @Override
    public String toString() {
        return "CandidateScore{" +
                "user=" + user +
                ", jobPost=" + jobPost +
                ", closeness=" + closeness +
                '}';
    }
}
