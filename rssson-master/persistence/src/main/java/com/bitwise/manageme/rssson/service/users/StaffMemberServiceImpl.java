package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.bitwise.manageme.rssson.domain.base.Email;
import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.repository.users.StaffMemberRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("staffMemberService")
public class StaffMemberServiceImpl implements StaffMemberService {

	@Autowired
	private StaffMemberRepository staffMemberRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StaffMember> findAll() {
		return Lists.newArrayList(this.staffMemberRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<StaffMember> findByUserVariables(String key, String value) {
		return this.staffMemberRepo.findByUserVariables(key, value);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StaffMember> findByNotRoles(String role, Integer firstResult, Integer maxResult) {
		return this.staffMemberRepo.findByNotRoles(role, firstResult, maxResult);
	}

	/*@Override
	@Transactional(readOnly=true)
	public List<StaffMember> findByUniqueEmails(Email email) {
		return this.staffMemberRepo.findByUniqueEmails(email);
	}*/

	@Override
	@Transactional(readOnly=false)
	public StaffMember save(StaffMember staffMember) {
		return this.staffMemberRepo.save(staffMember);
	}

	@Override
	public void delete(StaffMember staffMember) {
		this.staffMemberRepo.delete(staffMember);
	}

	@Override
	public StaffMember findById(Long id) {
		return this.staffMemberRepo.findOne(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<StaffMember> findByStaffId(String staffId, Pageable pageable) {
		return this.staffMemberRepo.findByStaffId(staffId, pageable);
	}

	@Override
	public Page<StaffMember> findAll(Pageable pageable) {
		return this.staffMemberRepo.findAll(pageable);
	}

	@Override
	public StaffMember findByStaffId(String staffId) {
		return this.staffMemberRepo.findByStaffId(staffId);
	}


}
