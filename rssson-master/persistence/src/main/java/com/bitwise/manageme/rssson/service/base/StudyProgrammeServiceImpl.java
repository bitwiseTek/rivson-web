package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.repository.base.StudyProgrammeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studyProgrammeService")
public class StudyProgrammeServiceImpl implements StudyProgrammeService {

	@Autowired
	private StudyProgrammeRepository studyProgrammeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudyProgramme> findAll() {
		return Lists.newArrayList(this.studyProgrammeRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgramme findByName(String name) {
		return this.studyProgrammeRepo.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgramme findByCode(String code) {
		return this.studyProgrammeRepo.findByCode(code);
	}

	@Override
	@Transactional(readOnly=false)
	public StudyProgramme save(StudyProgramme programme) {
		return this.studyProgrammeRepo.save(programme);
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgramme findById(Long id) {
		return this.studyProgrammeRepo.findOne(id);
	}

	@Override
	public void delete(StudyProgramme programme) {
		this.studyProgrammeRepo.delete(programme);
	}

}
