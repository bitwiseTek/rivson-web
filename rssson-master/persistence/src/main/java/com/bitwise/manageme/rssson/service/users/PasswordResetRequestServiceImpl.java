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

import com.bitwise.manageme.rssson.domain.users.PasswordResetRequest;
import com.bitwise.manageme.rssson.repository.users.PasswordResetRequestRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("passwordResetRequestService")
public class PasswordResetRequestServiceImpl implements PasswordResetRequestService {

	@Autowired
	private PasswordResetRequestRepository passwordResetRequestRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<PasswordResetRequest> findAll() {
		return Lists.newArrayList(this.passwordResetRequestRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public PasswordResetRequest findBySecret(String secret) {
		return this.passwordResetRequestRepo.findBySecret(secret);
	}

	@Override
	@Transactional(readOnly=false)
	public PasswordResetRequest save(PasswordResetRequest resetRequest) {
		return this.passwordResetRequestRepo.save(resetRequest);
	}

	@Override
	public void delete(PasswordResetRequest resetRequest) {
		this.passwordResetRequestRepo.delete(resetRequest);
	}

}
