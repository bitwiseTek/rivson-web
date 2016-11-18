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
import com.bitwise.manageme.rssson.repository.grading.CreditRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("creditService")
public class CreditServiceImpl implements CreditService {

	@Autowired
	private CreditRepository creditRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Credit> findAll() {
		return Lists.newArrayList(this.creditRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public Credit save(Credit credit) {
		return this.creditRepo.save(credit);
	}

}
