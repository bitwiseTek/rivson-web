package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.CourseEducationSubtype;

public interface CourseEducationSubtypeService {

	public List<CourseEducationSubtype> findAll();
	
	public CourseEducationSubtype save(CourseEducationSubtype educationSubType);
	
}
