package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentGroupUser;

public interface StudentGroupUserService {

	public List<StudentGroupUser> findAll();

	public StudentGroupUser save(StudentGroupUser groupUser);
	
	public void delete(StudentGroupUser groupUser);

}
