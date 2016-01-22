package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class Reference {

    /**
     * User's person of reference.
     * @param id primary key
     * @param user_id foreign key
     * @param phone format [0-9]*10[^non numeric]
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int user_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company_name;
    private int phone;

    @Override
    public String toString() {
        return "Reference{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", title='" + title + '\'' +
                ", company_name='" + company_name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
