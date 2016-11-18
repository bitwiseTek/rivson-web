package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;
import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplateCourse;

public interface TransferCreditTemplateCourseRepository extends CrudRepository<TransferCreditTemplateCourse, Long> {

	public List<TransferCreditTemplateCourse> findAll();
	
	public List<TransferCreditTemplateCourse> findByTemplates(TransferCreditTemplate template);
}
