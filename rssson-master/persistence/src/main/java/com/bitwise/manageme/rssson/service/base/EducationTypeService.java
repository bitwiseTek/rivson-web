package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.EducationType;

public interface EducationTypeService {

	public List<EducationType> findAll();
	
	public EducationType findByCode(String code);
	
	public EducationType save(EducationType type);
}
