package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.EducationSubtype;
import com.bitwise.manageme.rssson.domain.base.EducationType;

public interface EducationSubtypeService {

	public List<EducationSubtype> findAll();
	
	public EducationSubtype findByCode(String code);
	
	public List<EducationSubtype> findByEducationType(EducationType educationType);
	
	public EducationSubtype save(EducationSubtype subType);
	
}
