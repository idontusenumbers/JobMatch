package com.jobmatch.repositories;

import com.jobmatch.models.Experience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by eric on 1/28/16.
 */

@Repository
public interface ExperienceRepository extends CrudRepository<Experience,Integer> {
}
