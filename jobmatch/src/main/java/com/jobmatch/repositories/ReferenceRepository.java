package com.jobmatch.repositories;

import com.jobmatch.models.Reference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRepository extends CrudRepository<Reference, Integer> {
}
