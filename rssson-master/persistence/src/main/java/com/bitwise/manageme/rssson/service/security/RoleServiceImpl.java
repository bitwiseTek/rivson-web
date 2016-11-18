package com.bitwise.manageme.rssson.service.security;
/**
 *  
 * @author Sika Kay
 * @date 13/11/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.security.Role;
import com.bitwise.manageme.rssson.repository.security.RoleRepository;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Role> findAll() {
		return this.roleRepo.findAll();
	}

	@Override
	public Role findById(Long id) {
		return this.roleRepo.findOne(id);
	}

}
