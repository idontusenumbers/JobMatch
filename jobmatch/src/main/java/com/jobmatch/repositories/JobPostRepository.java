package com.jobmatch.repositories;

import com.jobmatch.models.JobPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends CrudRepository<JobPost, Integer> {
}
