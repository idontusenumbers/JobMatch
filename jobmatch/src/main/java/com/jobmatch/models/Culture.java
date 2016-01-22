package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class Culture {

    /**
     * Name of culture element.
     * @param id primary key+
     */

    private int id;
    private String culture_name;

    public Culture() {
    }

    public int getId() {
        return id;
    }

    public String getCulture_name() {
        return culture_name;
    }
}
