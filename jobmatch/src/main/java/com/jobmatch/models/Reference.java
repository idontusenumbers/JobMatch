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
     * @param phone format [0-9]*10[^non numeric]
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String title;
    protected String companyName;
    @Column(length = 12)
    protected String phone;

    public Reference() {
    }

    public Reference(String firstName, String lastName, String title, String companyName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.companyName = companyName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference reference = (Reference) o;

        if (!firstName.equals(reference.firstName)) return false;
        if (!lastName.equals(reference.lastName)) return false;
        if (!title.equals(reference.title)) return false;
        if (!companyName.equals(reference.companyName)) return false;
        return phone.equals(reference.phone);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + companyName.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
