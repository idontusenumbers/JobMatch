package com.jobmatch.models;

import javax.persistence.*;

/**
 * Created by Emilia on 1/21/2016.
 */
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
    @JoinColumn
    protected Skill skill;
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
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                ", skill=" + skill +
                ", rank=" + rank +
                '}';
    }
}
