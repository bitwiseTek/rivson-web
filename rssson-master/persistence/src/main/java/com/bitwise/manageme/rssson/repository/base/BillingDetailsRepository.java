package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface BillingDetailsRepository extends CrudRepository<BillingDetails, Long> {

	public List<BillingDetails> findAll();
	
	public List<BillingDetails> findByStudent(Student student);
}
