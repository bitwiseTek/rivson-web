package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.EducationSubtype;
import com.bitwise.manageme.rssson.domain.base.EducationType;

public interface EducationSubtypeRepository extends CrudRepository<EducationSubtype, Long> {

	public List<EducationSubtype> findAll();
	
	public EducationSubtype findByCode(String code);
	
	public List<EducationSubtype> findByEducationType(EducationType educationType);
	
}
