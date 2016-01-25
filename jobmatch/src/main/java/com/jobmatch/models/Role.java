package com.jobmatch.models;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String roleName;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return roleName;
    }

    public void setRole_name(String role_name) {
        this.roleName = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + roleName + '\'' +
                '}';
    }
}
