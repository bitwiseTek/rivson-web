package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.users.UserVariableKey;

public interface UserVariableKeyRepository extends CrudRepository<UserVariableKey, Long> {

	public List<UserVariableKey> findAll();
	
	public List<UserVariableKey> findUserEditableUserVariableKeys();
	
	public List<UserVariableKey> findByUserEditable(Boolean editable);
	
	public UserVariableKey findByVariableKey(String key);
}
