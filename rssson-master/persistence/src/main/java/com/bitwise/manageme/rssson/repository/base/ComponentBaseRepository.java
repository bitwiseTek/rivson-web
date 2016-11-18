package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.ComponentBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;

public interface ComponentBaseRepository extends CrudRepository<ComponentBase, Long> {

	public List<ComponentBase> findAll();
	
	public CourseBaseVariableKey findByVariableKey(String key);
	
}
