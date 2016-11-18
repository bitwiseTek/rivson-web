package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.AcademicSemester;

public interface AcademicSemesterRepository extends CrudRepository<AcademicSemester, Long>{

	public List<AcademicSemester> findAll();
	
}
