package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface BillingDetailsService {

	public List<BillingDetails> findAll();
	
	public BillingDetails findById(Long id);
	
	public List<BillingDetails> findByStudent(Student student);
	
	public void delete(BillingDetails billingDetals);
	
	public BillingDetails save(BillingDetails billingDetails);
}
