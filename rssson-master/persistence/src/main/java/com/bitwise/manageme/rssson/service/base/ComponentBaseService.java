package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.ComponentBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;

public interface ComponentBaseService {

	public List<ComponentBase> findAll();
	
	public CourseBaseVariableKey findByVariableKey(String key);
	
	public ComponentBase save(ComponentBase componentBase);
	
}
