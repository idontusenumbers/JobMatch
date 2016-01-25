package com.jobmatch.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class Reference implements Serializable {

    /**
     * User's person of reference.
     * @param id primary key
     * @param user_id foreign key
     * @param phone format [0-9]*10[^non numeric]
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String companyName;
    @Column(length = 12)
    private String phone;
}
