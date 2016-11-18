package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.domain.users.UserVariable;
import com.bitwise.manageme.rssson.domain.users.UserVariableKey;

public interface UserVariableRepository extends CrudRepository<UserVariable, Long> {

	public List<UserVariable> findAll();
	
	public UserVariable findByUserAndVariableKey(User user, UserVariableKey key);
	
	public List<UserVariable> findByUsers(User user);
}
