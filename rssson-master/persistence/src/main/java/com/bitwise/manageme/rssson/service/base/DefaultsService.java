package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.base.Defaults;

public interface DefaultsService{

	public List<Defaults> findAll();
	
	public Defaults save(Defaults defaults);
}
