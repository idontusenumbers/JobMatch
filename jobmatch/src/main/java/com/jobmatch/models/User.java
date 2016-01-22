package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class User {

    /**
     * Contains basic user account info.
     * @param id primary key
     * @param role_id foreign key
     */

    private int id;
    private int role_id;
    private String username;
    private String password; // hash later
    private Boolean opt_in;

    public int getId() {
        return id;
    }

    public int getRole_id() {
        return role_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getOpt_in() {
        return opt_in;
    }
}
