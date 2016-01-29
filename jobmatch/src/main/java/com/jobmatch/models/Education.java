package com.jobmatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Education implements Serializable {

    /**
     * User's college information.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String schoolName;
    private String country;
    private String degree;
    private String major;
    private int yearGraduated;

    public Education() {
    }

    public Education(String schoolName, String country, String degree, String major, int yearGraduated) {
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

    public int getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(int yearGraduated) {
        this.yearGraduated = yearGraduated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Education education = (Education) o;

        if (yearGraduated != education.yearGraduated) return false;
        if (!schoolName.equals(education.schoolName)) return false;
        if (!country.equals(education.country)) return false;
        if (!degree.equals(education.degree)) return false;
        return major.equals(education.major);

    }

    @Override
    public int hashCode() {
        int result = schoolName.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + degree.hashCode();
        result = 31 * result + major.hashCode();
        result = 31 * result + yearGraduated;
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
