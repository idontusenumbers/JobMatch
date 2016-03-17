package com.jobmatch.algorithm;

import com.jobmatch.models.JobPost;
import com.jobmatch.models.User;

public class CandidateScore implements Comparable<CandidateScore> {
    private User user;
    private JobPost jobPost;
    private float closeness;

    public CandidateScore(User user, JobPost jobPost, float closeness){
        this.user = user;
        this.jobPost = jobPost;
        this.closeness = closeness;
    }

    public JobPost getJobPost() {
        return jobPost;
    }
    public float getCloseness() {
        return closeness;
    }
    public User getUser() {
        return user;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateScore that = (CandidateScore) o;

        if (Float.compare(that.closeness, closeness) != 0) return false;
        if (!user.equals(that.user)) return false;
        return jobPost.equals(that.jobPost);
    }
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + jobPost.hashCode();
        result = 31 * result + (closeness != +0.0f ? Float.floatToIntBits(closeness) : 0);
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

    @Override
    public int compareTo(CandidateScore candidateScore) {
        return Float.compare(this.closeness, candidateScore.closeness);
    }
}
