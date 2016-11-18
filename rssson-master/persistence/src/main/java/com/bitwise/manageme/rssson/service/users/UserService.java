package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 12/09/16
 *
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bitwise.manageme.rssson.domain.users.User;

public interface UserService {

	public User findById(Long id);
	
	public List<User> findAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public User findByUsernameAndPassword(String username, String passwordEncoded);
	
	public User findByUsername(String username);
	
	public User findBySystemId(String systemId);
	
	public Page<User> findByUsername(String username, Pageable pageable);
	
	public Page<User> findBySystemId(String systemId, Pageable pageable);
	
	public User save(User user);
	
	public User getAccount(String username);
	
	public void delete(User user);
}
