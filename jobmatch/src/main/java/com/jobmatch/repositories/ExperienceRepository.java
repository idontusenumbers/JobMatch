package com.jobmatch.repositories;

import com.jobmatch.models.Experience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience,Integer> {
}
