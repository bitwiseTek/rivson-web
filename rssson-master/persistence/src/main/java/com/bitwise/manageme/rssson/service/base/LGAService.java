package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.LGA;

public interface LGAService {

	public List<LGA> findAll();
	
	public LGA findByCode(String code);
	
	public LGA save(LGA lga);
}
