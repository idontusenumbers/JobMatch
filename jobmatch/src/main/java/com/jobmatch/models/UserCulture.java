package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class UserCulture {

    /**
     * Connects user with a culture they ranked.
     * @param id primary key
     * @param culture_id foreign key
     * @param user_id foreign key
     */

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
}
