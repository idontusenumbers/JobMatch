package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class FavePost {

    /**
     * Connects user with their favorited job posting.
     * @param user_id primary key, foreign key
     * @param job_post_id primary key, foreign key
     */

    private int user_id;
    private int job_post_id;

    public FavePost() {
    }

    public int getUser_id() {
        return user_id;
    }

    public int getJob_post_id() {
        return job_post_id;
    }
}
