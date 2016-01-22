package com.jobmatch.repositories;

import com.jobmatch.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eric on 1/21/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
