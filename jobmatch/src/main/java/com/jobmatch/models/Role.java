package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class Role {

    /**
     * Defines user account type.
     * Can be admin, student, or employer.
     */

    private int id;
    private String role_name;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public String getRole_name() {
        return role_name;
    }
}
