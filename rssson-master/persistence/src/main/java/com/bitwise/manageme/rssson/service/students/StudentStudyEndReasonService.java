package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 30/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;

public interface StudentStudyEndReasonService {

	public List<StudentStudyEndReason> findAll();
	
	public List<StudentStudyEndReason> findByParentReasons(StudentStudyEndReason parentReason);
	
	public StudentStudyEndReason save(StudentStudyEndReason endReason);
	
	public void delete(StudentStudyEndReason endReason);

}
