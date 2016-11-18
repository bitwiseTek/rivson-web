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

public interface EducationTypeRepository extends CrudRepository<EducationType, Long> {

	public List<EducationType> findAll();
	
	public EducationType findByCode(String code);
	
}
