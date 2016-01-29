package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Culture implements Serializable {

    /**
     * Name of culture element.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String name;

    public Culture() {
    }

    /**
     * Adds a new culture to the database with name
     * @param name
     */
    public Culture(String name) {
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

        Culture culture = (Culture) o;

        return name.equals(culture.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Culture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
