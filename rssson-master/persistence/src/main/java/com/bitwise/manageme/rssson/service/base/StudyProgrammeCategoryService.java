package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;

public interface StudyProgrammeCategoryService {
	
	public StudyProgrammeCategory findById(Long id);

	public List<StudyProgrammeCategory> findAll();
	
	public StudyProgrammeCategory findByName(String name);
	
	public StudyProgrammeCategory save(StudyProgrammeCategory category);
	
	public void delete(StudyProgrammeCategory category);
}
