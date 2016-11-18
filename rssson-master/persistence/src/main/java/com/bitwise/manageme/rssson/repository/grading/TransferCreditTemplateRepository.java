package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.TransferCreditTemplate;

public interface TransferCreditTemplateRepository extends CrudRepository<TransferCreditTemplate, Long> {

	public List<TransferCreditTemplate> findAll();
}
