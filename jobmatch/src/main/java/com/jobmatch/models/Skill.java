package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class Skill {

    /**
     * Name of skill element.
     * @param id primary key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill_name='" + skill_name + '\'' +
                '}';
    }
}
