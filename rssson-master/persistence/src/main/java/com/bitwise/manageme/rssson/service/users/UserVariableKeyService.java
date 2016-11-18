package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.users.UserVariableKey;

public interface UserVariableKeyService {

	public List<UserVariableKey> findAll();
	
	public List<UserVariableKey> findUserEditableUserVariableKeys();
	
	public List<UserVariableKey> findByUserEditable(Boolean editable);
	
	public UserVariableKey findByVariableKey(String key);
	
	public UserVariableKey save(UserVariableKey key);
}
