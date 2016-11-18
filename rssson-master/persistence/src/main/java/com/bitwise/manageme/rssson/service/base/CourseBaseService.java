package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.CourseBase;

public interface CourseBaseService {

	public CourseBase findById(Long id);
	
	public List<CourseBase> findAll();
	
	public CourseBase findByName(String name);
	
	public CourseBase findByCode(String courseCode);
	
	public CourseBase save(CourseBase base);
	
	public void delete(CourseBase base);
}
