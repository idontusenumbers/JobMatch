package com.jobmatch.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    protected Skill skill;

    @Min(0)
    @Max(10)
    protected int rank;

    public JobSkill() {
    }

    public JobSkill(Skill skill, int rank) {
        this.skill = skill;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
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

        JobSkill that = (JobSkill) o;

        if (rank != that.rank) return false;
        return skill.equals(that.skill);
    }

    @Override
    public int hashCode() {
        int result = skill.hashCode();
        result = 31 * result + rank;
        return result;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "id=" + id +
                ", skill=" + skill +
                ", rank=" + rank +
                '}';
    }
}
