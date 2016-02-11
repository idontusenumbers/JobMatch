package com.jobmatch.repositories;

import com.jobmatch.models.UserSkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository extends CrudRepository<UserSkill, Integer> {

}
