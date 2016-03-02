package com.jobmatch.repositories;

import com.jobmatch.models.Culture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureRepository extends CrudRepository<Culture, Integer>, CultureRepositoryCustom {
}
