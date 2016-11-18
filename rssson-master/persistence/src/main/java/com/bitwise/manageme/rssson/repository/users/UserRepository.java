package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 11/09/16
 *
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bitwise.manageme.rssson.domain.users.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public List<User> findAll();
	
	public User findByUsernameAndPassword(String username, String passwordEncoded);
	
	public User findByUsername(String username);
	
	public User findBySystemId(String systemId);
	
	public Page<User> findBySystemId(String systemId, Pageable pageable);
	
	public Page<User> findByUsername(String username, Pageable pageable);
}
