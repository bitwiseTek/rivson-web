package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditVariable;
import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;

public interface CreditVariableService {

	public List<CreditVariable> findAll();
	
	public CreditVariable findByCreditAndKey(Credit credit, CreditVariableKey key);
	
	public CreditVariable save(CreditVariable creditVariable);
	
	public void delete(CreditVariable creditVariable);
}
