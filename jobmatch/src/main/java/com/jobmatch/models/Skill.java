package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class Skill {

    /**
     * Name of skill element.
     * @param id primary key
     */

    private int id;
    private String skill_name;

    public Skill() {
    }

    public int getId() {
        return id;
    }

    public String getSkill_name() {
        return skill_name;
    }
}
