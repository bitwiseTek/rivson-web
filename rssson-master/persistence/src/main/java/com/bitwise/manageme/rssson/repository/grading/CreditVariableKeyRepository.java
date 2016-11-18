package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;

public interface CreditVariableKeyRepository extends CrudRepository<CreditVariableKey, Long> {

	public List<CreditVariableKey> findAll();
	
	public CreditVariableKey findByKey(String key);
	
	public List<CreditVariableKey> findUserEditableCreditVariableKeys();
}
