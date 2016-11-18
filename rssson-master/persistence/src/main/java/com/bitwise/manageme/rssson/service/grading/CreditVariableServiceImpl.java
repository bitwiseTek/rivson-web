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

import com.bitwise.manageme.rssson.domain.grading.Credit;
import com.bitwise.manageme.rssson.domain.grading.CreditVariable;
import com.bitwise.manageme.rssson.domain.grading.CreditVariableKey;
import com.bitwise.manageme.rssson.repository.grading.CreditVariableRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("creditVariableService")
public class CreditVariableServiceImpl implements CreditVariableService {

	@Autowired
	private CreditVariableRepository creditVariableRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<CreditVariable> findAll() {
		return Lists.newArrayList(this.creditVariableRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public CreditVariable findByCreditAndKey(Credit credit, CreditVariableKey key) {
		return this.creditVariableRepo.findByCreditAndKey(credit, key);
	}

	@Override
	@Transactional(readOnly=false)
	public CreditVariable save(CreditVariable creditVariable) {
		return this.creditVariableRepo.save(creditVariable);
	}

	@Override
	public void delete(CreditVariable creditVariable) {
		this.creditVariableRepo.delete(creditVariable);
	}

}
