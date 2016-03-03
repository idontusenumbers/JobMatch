package com.jobmatch.viewmodels;

import org.springframework.web.bind.annotation.ModelAttribute;

public class FavoritePayload {
    int jobPostId;
    boolean isFavorite;

    public FavoritePayload() {
    }
    public FavoritePayload(boolean isFavorite, int jobPostId) {
        this.isFavorite = isFavorite;
        this.jobPostId = jobPostId;
    }
    public boolean getIsFavorite() {
        return isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
    public int getJobPostId() {
        return jobPostId;
    }
    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }
}
