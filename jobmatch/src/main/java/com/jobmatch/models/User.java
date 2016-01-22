package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class User {

    /**
     * Contains basic user account info.
     * @param id primary key
     * @param role_id foreign key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int role_id;
    private String username;
    private String password; // hash later
    private Boolean opt_in;

    protected User() {
    }

    public User(int role_id, String username, String password, Boolean opt_in) {
        this.role_id = role_id;
        this.username = username;
        this.password = password;
        this.opt_in = opt_in;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", username='" + username + '\'' +
                ", opt_in=" + opt_in +
                '}';
    }
}
