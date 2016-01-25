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
     * @param id primary key
     * @param role_id foreign key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Role role;
    private String username;
    private String password; // hash later
    private Boolean opt_in;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Contact contact;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "user_id", referencedColumnName = "id")
    private Set<Education> education;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "user_id", referencedColumnName = "id")
    private Set<UserSkill> skills;

    public User() {
    }

    public User(Role role, String username, String password, Boolean opt_in) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.opt_in = opt_in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Boolean getOpt_in() {
        return opt_in;
    }

    public void setOpt_in(Boolean opt_in) {
        this.opt_in = opt_in;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", opt_in=" + opt_in +
                ", contact=" + contact +
                ", education=" + education +
                ", skills=" + skills +
                '}';
    }
}
