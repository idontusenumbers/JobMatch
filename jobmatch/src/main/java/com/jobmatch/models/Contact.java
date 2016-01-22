package com.jobmatch.models;

/**
 * Created by Emilia on 1/21/2016.
 */
public class Contact {

    /**
     * User contact card.
     * @param id primary key
     * @param user_id foreign key
     */

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
}
