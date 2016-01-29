package com.jobmatch.repositories;

import com.jobmatch.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
    Skill findByName(String name);
}
