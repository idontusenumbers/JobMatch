package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class Culture {

    /**
     * Name of culture element.
     * @param id primary key+
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String culture_name;

    public Culture() {
    }

    /**
     * Adds a new culture to the database
     *
     * @param culture_name
     */
    public Culture(String culture_name) {
        this.culture_name = culture_name;
    }

    public int getId() {
        return id;
    }

    public String getCulture_name() {
        return culture_name;
    }

    @Override
    public String toString() {
        return "Culture{" +
                "id=" + id +
                ", culture_name='" + culture_name + '\'' +
                '}';
    }
}
