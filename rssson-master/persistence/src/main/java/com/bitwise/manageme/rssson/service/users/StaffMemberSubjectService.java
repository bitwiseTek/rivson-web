package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 28/09/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.users.StaffMemberSubject;

public interface StaffMemberSubjectService {
	
	public StaffMemberSubject findById(Long id);

	public List<StaffMemberSubject> findAll();
	
	public StaffMemberSubject save(StaffMemberSubject staffSubject);
	
	public void delete(StaffMemberSubject staffSubject);
}
