package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.AcademicSemester;

public interface AcademicSemesterService {

	public AcademicSemester findById(Long id);
	
	public List<AcademicSemester> findAll();
	
	public AcademicSemester save(AcademicSemester semester);
	
}
