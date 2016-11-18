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

import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;
import com.bitwise.manageme.rssson.repository.grading.CreditVariableKeyRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("creditVariableKeyService")
public class CreditVariableKeyServiceImpl implements CreditVariableKeyService {

	@Autowired
	private CreditVariableKeyRepository creditVariableKeyRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CreditVariableKey> findAll() {
		return Lists.newArrayList(this.creditVariableKeyRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public CreditVariableKey findByKey(String key) {
		return this.creditVariableKeyRepo.findByKey(key);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CreditVariableKey> findUserEditableCreditVariableKeys() {
		return this.creditVariableKeyRepo.findUserEditableCreditVariableKeys();
	}

	@Override
	@Transactional(readOnly=false)
	public CreditVariableKey save(CreditVariableKey key) {
		return this.creditVariableKeyRepo.save(key);
	}

}
