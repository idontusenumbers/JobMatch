package com.jobmatch.repositories;

import com.jobmatch.models.RankedSkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankedSkillRepository extends CrudRepository<RankedSkill, Integer> {

}
