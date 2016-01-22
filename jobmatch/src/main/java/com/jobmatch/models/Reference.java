package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class Reference {

    /**
     * User's person of reference.
     * @param id primary key
     * @param user_id foreign key
     * @param phone format [0-9]*10[^non numeric]
     */

    private int id;
    private int user_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company_name;
    private int phone;
}
