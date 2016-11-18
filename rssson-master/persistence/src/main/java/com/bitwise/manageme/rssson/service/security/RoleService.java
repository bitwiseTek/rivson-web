package com.bitwise.manageme.rssson.service.security;
/**
 *  
 * @author Sika Kay
 * @date 13/11/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.security.Role;

public interface RoleService {

	public Role findById(Long id);
	
	public List<Role> findAll();
}
