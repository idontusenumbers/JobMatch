package com.jobmatch.repositories;

import com.jobmatch.models.JobPost;
import com.jobmatch.models.JobSkill;
import com.jobmatch.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSkillRepository extends CrudRepository<JobSkill, Integer> {

}
