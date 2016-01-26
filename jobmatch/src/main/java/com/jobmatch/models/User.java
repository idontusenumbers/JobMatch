package com.jobmatch.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
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

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<Education> education = new HashSet<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<UserSkill> skills = new HashSet<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<Experience> experiences = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "USER_FAVE_POSTS",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "job_post_id"))
    protected Set<JobPost> favePosts = new HashSet<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<Reference> references = new HashSet<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Set<UserCulture> cultures = new HashSet<>();

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
     * @param optIn
     */
    public User(Role role, String username, String password, Boolean optIn) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.optIn = optIn;
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

    public Set<UserSkill> getSkills() {
        return skills;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public Set<JobPost> getFavePosts() {
        return favePosts;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public Set<UserCulture> getCultures() {
        return cultures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!role.equals(user.role)) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (!optIn.equals(user.optIn)) return false;
        return contact.equals(user.contact);

    }

    @Override
    public int hashCode() {
        int result = role.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + optIn.hashCode();
        result = 31 * result + contact.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", optIn=" + optIn +
                ", contact=" + contact +
                ", education=" + education +
                ", skills=" + skills +
                ", experiences=" + experiences +
                ", favePosts=" + favePosts +
                ", references=" + references +
                ", cultures=" + cultures +
                '}';
    }
}
