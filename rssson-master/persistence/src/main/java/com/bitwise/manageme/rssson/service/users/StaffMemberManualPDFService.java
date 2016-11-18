package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.users.StaffMemberManualPDF;

public interface StaffMemberManualPDFService {

	public StaffMemberManualPDF findById(Long id);
	
	public List<StaffMemberManualPDF> findAll();
	
	public StaffMemberManualPDF save(StaffMemberManualPDF manualPDF);
	
}
