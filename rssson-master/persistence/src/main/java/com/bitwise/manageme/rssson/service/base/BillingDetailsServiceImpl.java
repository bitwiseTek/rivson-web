package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.repository.base.BillingDetailsRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("billingDetailsService")
public class BillingDetailsServiceImpl implements BillingDetailsService {

	@Autowired
	private BillingDetailsRepository billingDetailsRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<BillingDetails> findAll() {
		return Lists.newArrayList(this.billingDetailsRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<BillingDetails> findByStudent(Student student) {
		return this.billingDetailsRepo.findByStudent(student);
	}

	@Override
	public void delete(BillingDetails billingDetails) {
		this.billingDetailsRepo.delete(billingDetails);
	}

	@Override
	@Transactional(readOnly=false)
	public BillingDetails save(BillingDetails billingDetails) {
		return this.billingDetailsRepo.save(billingDetails);
	}

	@Override
	public BillingDetails findById(Long id) {
		return this.billingDetailsRepo.findOne(id);
	}

}
