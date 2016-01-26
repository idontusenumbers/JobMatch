package com.jobmatch.repositories;

import com.jobmatch.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by eric on 1/24/16.
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByRoleName(String roleName);
}
