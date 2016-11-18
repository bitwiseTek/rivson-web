package com.bitwise.manageme.rssson.repository.security;
/**
 *  
 * @author Sika Kay
 * @date 13/11/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	public List<Role> findAll();
}
