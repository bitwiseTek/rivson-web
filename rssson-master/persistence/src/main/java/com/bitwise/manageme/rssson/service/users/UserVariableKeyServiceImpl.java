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

import com.bitwise.manageme.rssson.domain.users.UserVariableKey;
import com.bitwise.manageme.rssson.repository.users.UserVariableKeyRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("userVariableKeyService")
public class UserVariableKeyServiceImpl implements UserVariableKeyService {

	@Autowired
	private UserVariableKeyRepository userVariableKeyRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<UserVariableKey> findAll() {
		return Lists.newArrayList(this.userVariableKeyRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserVariableKey> findUserEditableUserVariableKeys() {
		return this.userVariableKeyRepo.findUserEditableUserVariableKeys();
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserVariableKey> findByUserEditable(Boolean editable) {
		return this.userVariableKeyRepo.findByUserEditable(editable);
	}

	@Override
	@Transactional(readOnly=true)
	public UserVariableKey findByVariableKey(String key) {
		return this.userVariableKeyRepo.findByVariableKey(key);
	}

	@Override
	@Transactional(readOnly=false)
	public UserVariableKey save(UserVariableKey key) {
		return this.userVariableKeyRepo.save(key);
	}

}
