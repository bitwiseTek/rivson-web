package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.users.StaffMemberSubject;

public interface StaffMemberSubjectRepository extends CrudRepository<StaffMemberSubject, Long> {

	public List<StaffMemberSubject> findAll();
}
