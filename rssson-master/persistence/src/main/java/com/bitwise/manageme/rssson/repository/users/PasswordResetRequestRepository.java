package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.users.PasswordResetRequest;

public interface PasswordResetRequestRepository extends CrudRepository<PasswordResetRequest, Long> {

	public List<PasswordResetRequest> findAll();
	
	public PasswordResetRequest findBySecret(String secret);
	
}
