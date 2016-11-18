package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;
import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplateCourse;

public interface TransferCreditTemplateCourseService {

	public List<TransferCreditTemplateCourse> findAll();
	
	public List<TransferCreditTemplateCourse> findByTemplates(TransferCreditTemplate template);
	
	public TransferCreditTemplateCourse save(TransferCreditTemplateCourse templateCourse);
	
	public void delete(TransferCreditTemplateCourse templateCourse);

}
