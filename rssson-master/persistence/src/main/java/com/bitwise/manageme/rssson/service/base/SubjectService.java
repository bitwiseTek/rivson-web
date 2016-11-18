package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.Subject;

public interface SubjectService {
	
	public Subject findById(Long id);

	public List<Subject> findAll();
	
	public Subject findByCode(String code);
	
	public List<Subject> findByEducationTypes(EducationType type);
	
	public Subject save(Subject subject);
	
	public Subject findByName(String name);
	
	public void delete(Subject subject);
	
}
