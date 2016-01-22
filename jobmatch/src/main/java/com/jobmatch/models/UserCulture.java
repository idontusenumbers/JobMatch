package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class UserCulture {

    /**
     * Connects user with a culture they ranked.
     * @param id primary key
     * @param culture_id foreign key
     * @param user_id foreign key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int culture_id;
    private int user_id;
    private int culture_rank;

    public UserCulture() {
    }

    public int getId() {
        return id;
    }

    public int getCulture_id() {
        return culture_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getCulture_rank() {
        return culture_rank;
    }

    @Override
    public String toString() {
        return "UserCulture{" +
                "id=" + id +
                ", culture_id=" + culture_id +
                ", user_id=" + user_id +
                ", culture_rank=" + culture_rank +
                '}';
    }
}
