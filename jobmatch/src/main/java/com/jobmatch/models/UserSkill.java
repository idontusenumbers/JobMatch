package com.jobmatch.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class UserSkill {

    /**
     * Connects user with a skill they ranked.
     * @param id primary key
     * @param skill_id foreign key
     * @param user_id foreign key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    protected Skill skill;
    @Min(0) @Max(10)
    protected int rank;

    public UserSkill() {

    }

    public UserSkill(Skill skill, int rank) {
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

        UserSkill userSkill = (UserSkill) o;

        if (rank != userSkill.rank) return false;
        return skill.equals(userSkill.skill);

    }

    @Override
    public int hashCode() {
        int result = skill.hashCode();
        result = 31 * result + rank;
        return result;
    }

    @Override
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                ", skill=" + skill +
                ", rank=" + rank +
                '}';
    }
}
