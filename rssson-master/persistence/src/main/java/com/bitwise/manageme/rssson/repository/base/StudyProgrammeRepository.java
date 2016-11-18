package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;

public interface StudyProgrammeRepository extends CrudRepository<StudyProgramme, Long> {

	public List<StudyProgramme> findAll();
	
	public StudyProgramme findByName(String name);
	
	public StudyProgramme findByCode(String code);
}
