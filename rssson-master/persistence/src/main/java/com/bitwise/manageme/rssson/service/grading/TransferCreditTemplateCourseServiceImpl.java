package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;
import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplateCourse;
import com.bitwise.manageme.rssson.repository.grading.TransferCreditTemplateCourseRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("transferCreditTemplateCourseService")
public class TransferCreditTemplateCourseServiceImpl implements TransferCreditTemplateCourseService {

	@Autowired
	private TransferCreditTemplateCourseRepository transferCreditTemplateCourseRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<TransferCreditTemplateCourse> findAll() {
		return Lists.newArrayList(this.transferCreditTemplateCourseRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<TransferCreditTemplateCourse> findByTemplates(TransferCreditTemplate template) {
		return this.transferCreditTemplateCourseRepo.findByTemplates(template);
	}

	@Override
	@Transactional(readOnly=false)
	public TransferCreditTemplateCourse save(TransferCreditTemplateCourse templateCourse) {
		return this.transferCreditTemplateCourseRepo.save(templateCourse);
	}

	@Override
	public void delete(TransferCreditTemplateCourse templateCourse) {
		this.transferCreditTemplateCourseRepo.delete(templateCourse);
	}

}
