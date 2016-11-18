package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

	public List<Subject> findAll();
	
	public Subject findByCode(String code);
	
	public Subject findByName(String name);
	
	public List<Subject> findByEducationTypes(EducationType type);
	
}
