package com.jobmatch.repositories;

import com.jobmatch.models.UserCulture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCultureRepository extends CrudRepository<UserCulture,Integer> {
}
