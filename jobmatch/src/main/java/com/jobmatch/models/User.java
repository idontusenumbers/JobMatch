package com.jobmatch.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class User implements Serializable {

    /**
     * Contains basic user account info.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    protected Role role;
    protected String username;
    protected String password; // hash later
    protected Boolean optIn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    protected Contact contact;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<Education> education;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<UserSkill> skills;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<Experience> experiences;

    /**
     * Default Constructor
     */
    public User() {
    }

    /**
     * Constructor
     * @param role
     * @param username
     * @param password
     * @param opt_in
     */
    public User(Role role, String username, String password, Boolean opt_in) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.optIn = opt_in;
    }

    /**
     * Get User Id
     * @return id
     */
    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getOptIn() {
        return optIn;
    }

    public void setOptIn(Boolean opt_in) {
        this.optIn = opt_in;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Education> getEducation() {
        return education;
    }

    public void setEducation(Set<Education> education) {
        this.education = education;
    }

    public Set<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<UserSkill> skills) {
        this.skills = skills;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", opt_in=" + optIn +
                ", contact=" + contact +
                ", education=" + education +
                ", skills=" + skills +
                ", experiences=" + experiences +
                '}';
    }
}
