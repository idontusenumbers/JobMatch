package com.jobmatch.repositories;

import com.jobmatch.models.Role;
import com.jobmatch.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer>, SkillRepositoryCustom {
    Skill findByName(String name);
}
