package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 23/06/16
 *
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bitwise.manageme.rssson.domain.users.StaffMember;

public interface StaffMemberRepository extends PagingAndSortingRepository<StaffMember, Long> {

	public List<StaffMember> findAll();
	
	public List<StaffMember> findByUserVariables(String key, String value);
	
	public List<StaffMember> findByNotRoles(String role, Integer firstResult, Integer maxResult);
	
	public StaffMember findByStaffId(String staffId);
	
	public Page<StaffMember> findByStaffId(String staffId, Pageable pageable);
	
	//public List<StaffMember> findByUniqueEmails(Email email);
	
	
}
