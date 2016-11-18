package com.bitwise.manageme.rssson.repository.users;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.users.StaffMemberManualPDF;

public interface StaffMemberManualPDFRepository extends CrudRepository<StaffMemberManualPDF, Long>{

	public List<StaffMemberManualPDF> findAll();
	
}
