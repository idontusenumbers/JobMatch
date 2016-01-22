package com.jobmatch.repository;

import com.jobmatch.Entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eric on 1/21/16.
 */
public interface UserRepository extends CrudRepository <User, Long> {
}
