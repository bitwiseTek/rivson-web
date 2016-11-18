package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentActivityType;

public interface StudentActivityTypeService {

	public List<StudentActivityType> findAll();
	
	public StudentActivityType save(StudentActivityType activityType);
}
