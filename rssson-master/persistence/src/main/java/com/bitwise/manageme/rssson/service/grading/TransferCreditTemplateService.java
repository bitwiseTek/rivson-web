package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;

public interface TransferCreditTemplateService {

	public List<TransferCreditTemplate> findAll();
	
	public TransferCreditTemplate save(TransferCreditTemplate template);
}
