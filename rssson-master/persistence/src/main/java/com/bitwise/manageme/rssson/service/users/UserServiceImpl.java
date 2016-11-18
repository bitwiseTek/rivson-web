package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 12/09/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.repository.users.UserRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return Lists.newArrayList(this.userRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
		return this.userRepo.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(Long id) {
		return this.userRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(User user) {
		this.userRepo.delete(user);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByUsernameAndPassword(String username, String passwordEncoded) {
		return this.userRepo.findByUsernameAndPassword(username, passwordEncoded);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByUsername(String username) {
		return this.userRepo.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public User getAccount(String username) {
		return this.userRepo.findByUsername(username);
	}

	@Override
	public User findBySystemId(String systemId) {
		return this.userRepo.findBySystemId(systemId);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return this.userRepo.findAll(pageable);
	}

	@Override
	public Page<User> findByUsername(String username, Pageable pageable) {
		return this.userRepo.findByUsername(username, pageable);
	}

	@Override
	public Page<User> findBySystemId(String systemId, Pageable pageable) {
		return this.userRepo.findBySystemId(systemId, pageable);
	}

}
