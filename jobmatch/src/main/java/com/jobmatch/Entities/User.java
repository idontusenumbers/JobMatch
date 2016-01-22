package com.jobmatch.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by eric on 1/21/16.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer role_id;
    private Boolean opt_in;
    private String password;

    protected User() {}

    public User(Integer role_id, Boolean opt_in, String password) {
        this.role_id = role_id;
        this.opt_in = opt_in;

        // TODO: Hash Password using bcrypt
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", opt_in=" + opt_in +
                '}';
    }
}
