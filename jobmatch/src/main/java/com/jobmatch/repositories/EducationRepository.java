package com.jobmatch.repositories;

import com.jobmatch.models.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository<Education,Integer> {
}
