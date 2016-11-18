package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.CourseEducationType;

public interface CourseEducationTypeService {

	public List<CourseEducationType> findAll();
	
	public CourseEducationType save(CourseEducationType educationType);
}
