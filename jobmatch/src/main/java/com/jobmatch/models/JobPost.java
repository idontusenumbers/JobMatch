package com.jobmatch.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class JobPost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobTitle;
    private String jobCountry;
    private String industry;
    private String jobType;

    @Min(0)
    private int yearsExperience;

    @ManyToMany
    @JoinTable(name = "USER_FAVE_POSTS",
            joinColumns = @JoinColumn(name = "job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    protected Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "JOB_POST_SKILLS",
            joinColumns = @JoinColumn(name = "job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_rank_id"))
    protected Set<SkillRank> skills = new HashSet<>();


    @OneToOne
    @JoinColumn
    protected User creator;

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

    public Set<SkillRank> getSkills() {
        return skills;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobPost jobPost = (JobPost) o;

        if (yearsExperience != jobPost.yearsExperience) return false;
        if (!jobTitle.equals(jobPost.jobTitle)) return false;
        if (!jobCountry.equals(jobPost.jobCountry)) return false;
        if (!industry.equals(jobPost.industry)) return false;
        return jobType.equals(jobPost.jobType);
    }

    @Override
    public int hashCode() {
        int result = jobTitle.hashCode();
        result = 31 * result + jobCountry.hashCode();
        result = 31 * result + industry.hashCode();
        result = 31 * result + jobType.hashCode();
        result = 31 * result + yearsExperience;
        return result;
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
                ", users=" + users +
                ", skills=" + skills +
                '}';
    }
}
