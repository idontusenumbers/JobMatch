package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class JobPost {

    // REMOVED "_" from originally in ERD

    /**
     * Employer's job posting.
     * @param id primary key
     * @param user_id foreign key
     */

    private int id;
    private int user_id;
    private String job_title;
    private String job_country;
    private String industry;
    private String job_type;
    private int years_experience;

    public JobPost() {
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getJob_country() {
        return job_country;
    }

    public String getIndustry() {
        return industry;
    }

    public String getJob_type() {
        return job_type;
    }

    public int getYears_experience() {
        return years_experience;
    }
}
