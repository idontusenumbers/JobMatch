package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class Contact {

    /**
     * User contact card.
     * @param id primary key
     * @param user_id foreign key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int user_id;
    private String email;
    private String phone;
    private String address;
    private String zipcode;
    private String website;
    private String first_name;
    private String last_name;

    public Contact() {
    }

    public Contact(User user_id) {

    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getWebsite() {
        return website;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", website='" + website + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
