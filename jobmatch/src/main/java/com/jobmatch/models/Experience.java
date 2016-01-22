package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class Experience {

    /**
     * User's job experience.
     * @param id primary key
     * @param user_id foreign key
     * @param start_date regex calendar specific
     * @param end_date regex calendar specific
     */

    private int id;
    private int user_id;
    private String title;
    private String company_name;
    private String company_address;
    private String start_date;
    private String end_date;
    private String responsibilities;

    public Experience() {
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getResponsibilities() {
        return responsibilities;
    }
}
