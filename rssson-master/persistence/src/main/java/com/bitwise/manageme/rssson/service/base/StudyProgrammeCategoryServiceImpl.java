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

import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;
import com.bitwise.manageme.rssson.repository.base.StudyProgrammeCategoryRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studyProgrammeCategoryService")
public class StudyProgrammeCategoryServiceImpl implements StudyProgrammeCategoryService {

	@Autowired
	private StudyProgrammeCategoryRepository studyProgrammeCategoryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StudyProgrammeCategory> findAll() {
		return Lists.newArrayList(this.studyProgrammeCategoryRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgrammeCategory findByName(String name) {
		return this.studyProgrammeCategoryRepo.findByName(name);
	}

	@Override
	@Transactional(readOnly=false)
	public StudyProgrammeCategory save(StudyProgrammeCategory category) {
		return this.studyProgrammeCategoryRepo.save(category);
	}

	@Override
	@Transactional(readOnly=true)
	public StudyProgrammeCategory findById(Long id) {
		return this.studyProgrammeCategoryRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(StudyProgrammeCategory category) {
		this.studyProgrammeCategoryRepo.delete(category);
	}

}
