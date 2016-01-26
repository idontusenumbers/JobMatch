package com.jobmatch.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by Emilia on 1/21/2016.
 */
@Entity
public class UserCulture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    protected Culture culture;
    @Min(0) @Max(10)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCulture that = (UserCulture) o;

        if (rank != that.rank) return false;
        return culture.equals(that.culture);

    }

    @Override
    public int hashCode() {
        int result = culture.hashCode();
        result = 31 * result + rank;
        return result;
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
