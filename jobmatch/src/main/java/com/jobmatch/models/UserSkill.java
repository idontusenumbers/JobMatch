package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class UserSkill {

    /**
     * Connects user with a skill they ranked.
     * @param id primary key
     * @param skill_id foreign key
     * @param user_id foreign key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int skill_id;
    private int user_id;
    private int skill_rank;

    public UserSkill() {
    }

    public int getId() {
        return id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getSkill_rank() {
        return skill_rank;
    }
}
