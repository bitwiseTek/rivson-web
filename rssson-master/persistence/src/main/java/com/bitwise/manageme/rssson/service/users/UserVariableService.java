package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.domain.users.UserVariable;
import com.bitwise.manageme.rssson.domain.users.UserVariableKey;

public interface UserVariableService {

	public List<UserVariable> findAll();
	
	public UserVariable findByUserAndVariableKey(User user, UserVariableKey key);
	
	public List<UserVariable> findByUsers(User user);
	
	public UserVariable save(UserVariable userVariable);
	
	public void delete(UserVariable userVariable);

}
