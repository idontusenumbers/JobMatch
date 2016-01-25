package com.jobmatch.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class UserCulture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    protected Culture culture;
    protected int rank;

    public UserCulture() {
    }

    public UserCulture(Culture culture, int rank) {
        this.culture = culture;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "UserCulture{" +
                "id=" + id +
                ", culture=" + culture +
                ", rank=" + rank +
                '}';
    }
}
