package com.bitwise.manageme.rssson.repository.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.help.StaffManual;

public interface StaffManualRepository extends CrudRepository<StaffManual, Long>{

	public List<StaffManual> findAll();
	
	public StaffManual findByVersion(String manualVersion);
}
