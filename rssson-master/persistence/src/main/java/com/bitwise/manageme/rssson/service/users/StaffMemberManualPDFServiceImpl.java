package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.users.StaffMemberManualPDF;
import com.bitwise.manageme.rssson.repository.users.StaffMemberManualPDFRepository;

@Transactional
@Service("staffManualPDFService")
public class StaffMemberManualPDFServiceImpl implements StaffMemberManualPDFService {

	@Autowired
	private StaffMemberManualPDFRepository staffManualRepo;
	
	@Override
	@Transactional(readOnly=true)
	public StaffMemberManualPDF findById(Long id) {
		return this.staffManualRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StaffMemberManualPDF> findAll() {
		return this.staffManualRepo.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public StaffMemberManualPDF save(StaffMemberManualPDF manualPDF) {
		return this.staffManualRepo.save(manualPDF);
	}

}
