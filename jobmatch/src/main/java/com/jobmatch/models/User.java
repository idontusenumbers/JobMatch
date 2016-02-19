package com.jobmatch.models;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable {

    /**
     * Contains basic user account info.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne
    @JoinColumn
    protected Role role;
    @Column(unique = true)
    @Size(min = 2, max = 254)
    protected String username;
    @Size(min = 6)
    protected String password;
    @ColumnDefault("false")
    protected Boolean optIn;

    private String email;

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

    @ManyToMany(fetch = FetchType.LAZY)
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
        this.optIn = false;
    }

    /**
     * Constructor
     *
     * @param role
     * @param username
     * @param password
     * @param optIn
     */
    public User(Role role, String username, String password, Boolean optIn, String email) {
        this.role = role;
        this.username = username;
        this.email = email;
        this.setPassword(password);
        this.optIn = optIn;
    }

    /**
     * Get User Id
     *
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


    /**
     * Hash User Password when setting it using bcrypt
     *
     * @param password
     */
    public void setPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    public Boolean getOptIn() {
        return optIn;
    }

    public void setOptIn(Boolean opt_in) {
        this.optIn = opt_in;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return optIn != null ? optIn.equals(user.optIn) : user.optIn == null;

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (optIn != null ? optIn.hashCode() : 0);
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
