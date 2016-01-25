package com.jobmatch.repositories;

import com.jobmatch.models.JobPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by eric on 1/25/16.
 */

@Repository
public interface JobPostRepository extends CrudRepository<JobPost, Integer> {
}
