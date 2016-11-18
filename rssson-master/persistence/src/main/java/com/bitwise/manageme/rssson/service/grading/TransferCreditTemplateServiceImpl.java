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

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;
import com.bitwise.manageme.rssson.repository.grading.TransferCreditTemplateRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("transferCreditTemplateService")
public class TransferCreditTemplateServiceImpl implements TransferCreditTemplateService {

	@Autowired
	private TransferCreditTemplateRepository transferCreditTemplateRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<TransferCreditTemplate> findAll() {
		return Lists.newArrayList(this.transferCreditTemplateRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public TransferCreditTemplate save(TransferCreditTemplate template) {
		return this.transferCreditTemplateRepo.save(template);
	}

}
