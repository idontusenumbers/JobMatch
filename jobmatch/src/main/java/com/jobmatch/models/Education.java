package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Education implements Serializable {

    /**
     * User's college information.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String schoolName;
    protected String country;
    protected String degree;
    protected String major;
    @Size(min = 4, max = 4)
    protected String yearGraduated;

    public Education() {
    }

    /**
     * Constructor
     *
     * @param schoolName
     * @param country
     * @param degree
     * @param major
     * @param yearGraduated
     */
    public Education(String schoolName, String country, String degree, String major, String yearGraduated) {
        this.schoolName = schoolName;
        this.country = country;
        this.degree = degree;
        this.major = major;
        this.yearGraduated = yearGraduated;
    }

    public int getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(String yearGraduated) {
        this.yearGraduated = yearGraduated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Education education = (Education) o;

        if (schoolName != null ? !schoolName.equals(education.schoolName) : education.schoolName != null) return false;
        if (country != null ? !country.equals(education.country) : education.country != null) return false;
        if (degree != null ? !degree.equals(education.degree) : education.degree != null) return false;
        if (major != null ? !major.equals(education.major) : education.major != null) return false;
        return yearGraduated != null ? yearGraduated.equals(education.yearGraduated) : education.yearGraduated == null;

    }

    @Override
    public int hashCode() {
        int result = schoolName != null ? schoolName.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (yearGraduated != null ? yearGraduated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", country='" + country + '\'' +
                ", degree='" + degree + '\'' +
                ", major='" + major + '\'' +
                ", yearGraduated=" + yearGraduated +
                '}';
    }
}
