package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.domain.users.UserVariable;
import com.bitwise.manageme.rssson.domain.users.UserVariableKey;
import com.bitwise.manageme.rssson.repository.users.UserVariableRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("userVariableService")
public class UserVariableServiceImpl implements UserVariableService {

	@Autowired
	private UserVariableRepository userVariableRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<UserVariable> findAll() {
		return Lists.newArrayList(this.userVariableRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public UserVariable findByUserAndVariableKey(User user, UserVariableKey key) {
		return this.userVariableRepo.findByUserAndVariableKey(user, key);
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserVariable> findByUsers(User user) {
		return this.userVariableRepo.findByUsers(user);
	}

	@Override
	@Transactional(readOnly=false)
	public UserVariable save(UserVariable userVariable) {
		return this.userVariableRepo.save(userVariable);
	}

	@Override
	public void delete(UserVariable userVariable) {
		this.userVariableRepo.delete(userVariable);
	}

}
