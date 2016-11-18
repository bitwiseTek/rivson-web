package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.domain.users.StaffMemberImage;

public interface StaffMemberImageService {

	public List<StaffMemberImage> findAll();
	
	public StaffMemberImage findById(Long id);
	
	public StaffMemberImage findByStaff(StaffMember student);
	
	public Boolean findStaffHasImage(StaffMember student);
	
	public StaffMemberImage save(StaffMemberImage image);
	
	public void delete(StaffMemberImage image);
}
