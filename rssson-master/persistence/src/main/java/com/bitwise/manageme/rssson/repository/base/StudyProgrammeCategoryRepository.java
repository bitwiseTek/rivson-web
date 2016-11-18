package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;

public interface StudyProgrammeCategoryRepository extends CrudRepository<StudyProgrammeCategory, Long> {

	public List<StudyProgrammeCategory> findAll();
	
	public StudyProgrammeCategory findByName(String name);
}
