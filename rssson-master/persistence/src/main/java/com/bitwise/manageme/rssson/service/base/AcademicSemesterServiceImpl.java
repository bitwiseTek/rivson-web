package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.AcademicSemester;
import com.bitwise.manageme.rssson.repository.base.AcademicSemesterRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("academicSemesterService")
public class AcademicSemesterServiceImpl implements AcademicSemesterService {

	@Autowired
	private AcademicSemesterRepository academicSemesterRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<AcademicSemester> findAll() {
		return Lists.newArrayList(this.academicSemesterRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public AcademicSemester save(AcademicSemester semester) {
		return this.academicSemesterRepo.save(semester);
	}

	@Override
	@Transactional(readOnly=true)
	public AcademicSemester findById(Long id) {
		return this.academicSemesterRepo.findOne(id);
	}

}
