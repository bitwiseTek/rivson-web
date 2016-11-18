package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import com.bitwise.manageme.rssson.domain.base.Email;
import com.bitwise.manageme.rssson.domain.users.StaffMember;

public interface StaffMemberService {

	public List<StaffMember> findAll();
	
	public StaffMember findById(Long id);
	
	public List<StaffMember> findByUserVariables(String key, String value);
	
	public List<StaffMember> findByNotRoles(String role, Integer firstResult, Integer maxResult);
	
	//public List<StaffMember> findByUniqueEmails(Email email);
	
	public StaffMember save(StaffMember staffMember);
	
	public void delete(StaffMember staffMember);
	
	public Page<StaffMember> findAll(Pageable pageable);
	
	public StaffMember findByStaffId(String staffId);
	
	public Page<StaffMember> findByStaffId(String staffId, Pageable pageable);

}
