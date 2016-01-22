package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class Role {

    /**
     * Defines user account type.
     * Can be admin, student, or employer.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
