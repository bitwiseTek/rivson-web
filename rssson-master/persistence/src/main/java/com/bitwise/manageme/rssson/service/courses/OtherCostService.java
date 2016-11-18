package com.bitwise.manageme.rssson.service.courses;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.OtherCost;

public interface OtherCostService {

	public List<OtherCost> findAll();
	
	public List<OtherCost> findByCourses(Course course);
	
	public OtherCost save(OtherCost otherCost);
	
	public void delete(OtherCost otherCost);

}
