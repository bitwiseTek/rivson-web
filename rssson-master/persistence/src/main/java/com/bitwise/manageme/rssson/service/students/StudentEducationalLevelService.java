package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.StudentEducationalLevel;

public interface StudentEducationalLevelService {

	public List<StudentEducationalLevel> findAll();
	
	public StudentEducationalLevel save(StudentEducationalLevel educationalLevel);
}
