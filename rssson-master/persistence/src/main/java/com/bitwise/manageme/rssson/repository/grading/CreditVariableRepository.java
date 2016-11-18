package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditVariable;
import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;

public interface CreditVariableRepository extends CrudRepository<CreditVariable, Long> {

	public List<CreditVariable> findAll();
	
	public CreditVariable findByCreditAndKey(Credit credit, CreditVariableKey key);
}
