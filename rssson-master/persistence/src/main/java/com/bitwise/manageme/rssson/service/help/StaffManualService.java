package com.bitwise.manageme.rssson.service.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.help.StaffManual;

public interface StaffManualService {

	public StaffManual findById(Long id);
	
	public List<StaffManual> findAll();
	
	public StaffManual findByVersion(String manualVersion);
	
	public StaffManual save(StaffManual staffManual);
}
