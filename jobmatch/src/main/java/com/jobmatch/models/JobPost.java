package com.jobmatch.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class JobPost implements Serializable {

    /**
     * Employer's job posting.
     * @param id primary key
     * @param user_id foreign key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobTitle;
    private String jobCountry;
    private String industry;
    private String jobType;
    private int yearsExperience;

    @ManyToMany
    @JoinTable(name = "USER_FAVE_POSTS",
    joinColumns = @JoinColumn(name = "job_post_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    protected Set<User> users;

    public JobPost() {
    }

    public JobPost(String jobTitle, String jobCountry, String industry, String jobType, int yearsExperience) {
        this.jobTitle = jobTitle;
        this.jobCountry = jobCountry;
        this.industry = industry;
        this.jobType = jobType;
        this.yearsExperience = yearsExperience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobCountry() {
        return jobCountry;
    }

    public void setJobCountry(String jobCountry) {
        this.jobCountry = jobCountry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobCountry='" + jobCountry + '\'' +
                ", industry='" + industry + '\'' +
                ", jobType='" + jobType + '\'' +
                ", yearsExperience=" + yearsExperience +
                '}';
    }
}
