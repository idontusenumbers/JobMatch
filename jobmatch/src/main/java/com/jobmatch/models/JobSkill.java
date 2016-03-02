package com.jobmatch.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Entity
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
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

    public static Map<String, String> getSkillsAndRanks(Set<JobSkill> skills) {
                return StreamSupport.stream(skills.spliterator(), false)
                .collect(Collectors.toMap(jobSkill -> String.valueOf(jobSkill.getSkill().getId()),
                                          jobSkill -> String.valueOf(jobSkill.getRank())));
    }
}
