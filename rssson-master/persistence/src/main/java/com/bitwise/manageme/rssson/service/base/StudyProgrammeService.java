package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;

public interface StudyProgrammeService {
	
	public StudyProgramme findById(Long id);

	public List<StudyProgramme> findAll();
	
	public StudyProgramme findByName(String name);
	
	public StudyProgramme findByCode(String code);
	
	public StudyProgramme save(StudyProgramme programme);
	
	public void delete(StudyProgramme programme);
}
