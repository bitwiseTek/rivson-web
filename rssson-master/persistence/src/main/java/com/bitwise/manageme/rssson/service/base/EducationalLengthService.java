package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.EducationalLength;

public interface EducationalLengthService{
	
	public EducationalLength findById(Long id);

	public List<EducationalLength> findAll();
	
	public EducationalLength save(EducationalLength length);
}
