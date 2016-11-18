package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;

public interface EducationalTimeUnitService {
	
	public EducationalTimeUnit findById(Long id);

	public List<EducationalTimeUnit> findAll();
	
	public EducationalTimeUnit save(EducationalTimeUnit timeUnit);
	
}
