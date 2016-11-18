package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.Credit;

public interface CreditService {

	public List<Credit> findAll();
	
	public Credit save(Credit credit);
}
