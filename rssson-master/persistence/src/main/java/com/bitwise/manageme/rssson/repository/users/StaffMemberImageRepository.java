package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.users.StaffMemberImage;

public interface StaffMemberImageRepository extends CrudRepository<StaffMemberImage, Long> {

	public List<StaffMemberImage> findAll();
	
	/*public StaffMemberImage findByStaff(StaffMember student);
	
	public Boolean findStaffHasImage(StaffMember student);*/
}
