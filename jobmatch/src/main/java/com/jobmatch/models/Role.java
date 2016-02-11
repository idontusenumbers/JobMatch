package com.jobmatch.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    public static final int ADMIN = 1;
    public static final int STUDENT = 2;
    public static final int EMPLOYER = 3;


    // TODO Asert constants are correct

    /**
     * Defines user account type.
     * Can be admin, student, or employer.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(nullable = false, unique = true)
    protected String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return name.equals(role.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
