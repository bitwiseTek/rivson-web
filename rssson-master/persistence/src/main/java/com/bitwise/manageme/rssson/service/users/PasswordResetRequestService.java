package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.users.PasswordResetRequest;

public interface PasswordResetRequestService {

	public List<PasswordResetRequest> findAll();
	
	public PasswordResetRequest findBySecret(String secret);
	
	public PasswordResetRequest save(PasswordResetRequest resetRequest);
	
	public void delete(PasswordResetRequest resetRequest);

}
