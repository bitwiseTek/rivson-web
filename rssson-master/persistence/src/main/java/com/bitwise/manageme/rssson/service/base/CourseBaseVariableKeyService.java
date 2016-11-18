package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;

public interface CourseBaseVariableKeyService {

	public List<CourseBaseVariableKey> findAll();
	
	public CourseBaseVariableKey findByVariableKey(String key);
	
	public CourseBaseVariableKey save(CourseBaseVariableKey key);
	
}
