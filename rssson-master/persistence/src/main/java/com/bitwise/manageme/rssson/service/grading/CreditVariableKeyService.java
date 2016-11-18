package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;

public interface CreditVariableKeyService {

	public List<CreditVariableKey> findAll();
	
	public CreditVariableKey findByKey(String key);
	
	public List<CreditVariableKey> findUserEditableCreditVariableKeys();
	
	public CreditVariableKey save(CreditVariableKey key);
}
