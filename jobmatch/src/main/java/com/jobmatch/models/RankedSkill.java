package com.jobmatch.models;

import com.jobmatch.repositories.SkillRepository;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Entity
public class RankedSkill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    protected Skill skill;

    @Min(0)
    @Max(10)
    protected int rank;

    public RankedSkill() {
    }

    public RankedSkill(Skill skill, int rank) {
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

    public static Map<String, String> getSkillsAndRanks(Set<RankedSkill> skills) {
        return StreamSupport.stream(skills.spliterator(), false)
                .collect(Collectors.toMap(rankedSkill -> String.valueOf(rankedSkill.getSkill().getId()),
                        rankedSkill -> String.valueOf(rankedSkill.getRank())));
    }

    /*public static List<RankedSkill> getSkillsAndRanks(Set<RankedSkill> skills) {
        return new ArrayList<>(skills);
    }*/

    public static void updateSkillSet(String[] skills, String[] ranks, Set<RankedSkill> skillSet, SkillRepository skillRepository) {
        skillSet.clear();
        for (int i = 0; i < skills.length; i++) {
            String s = skills[i];
            if (!s.isEmpty()) {
                Skill skill = skillRepository.findOne(Integer.valueOf(s));
                RankedSkill rankedSkill = new RankedSkill(skill, Integer.valueOf(ranks[i]));
                skillSet.add(rankedSkill);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RankedSkill that = (RankedSkill) o;

        if (rank != that.rank) return false;
        return skill != null ? skill.equals(that.skill) : that.skill == null;

    }

    @Override
    public int hashCode() {
        int result = skill != null ? skill.hashCode() : 0;
        result = 31 * result + rank;
        return result;
    }

    @Override
    public String toString() {
        return "RankedSkill{" +
                "id=" + id +
                ", skill=" + skill +
                ", rank=" + rank +
                '}';
    }
}
