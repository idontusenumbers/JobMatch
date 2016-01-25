package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Emilia on 1/21/2016.
 */
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
    public String toString() {
        return "Culture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
