package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class Education {

    /**
     * User's college information.
     * @param id primary key
     * @param user_id foreign key
     */

    private int id;
    private int user_id;
    private String school_name;
    private String country;
    private String degree;
    private String major;
    private int year_graduated;

    public Education() {
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public String getCountry() {
        return country;
    }

    public String getDegree() {
        return degree;
    }

    public String getMajor() {
        return major;
    }

    public int getYear_graduated() {
        return year_graduated;
    }
}
