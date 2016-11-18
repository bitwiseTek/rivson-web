package com.bitwise.manageme.rssson.service.changelog;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntity;
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;

public interface ChangeLogEntryEntityPropertyService {

	public List<ChangeLogEntryEntityProperty> findAll();
	
	public ChangeLogEntryEntityProperty findByEntityAndName(ChangeLogEntryEntity entity, String name);
	
	public ChangeLogEntryEntityProperty save(ChangeLogEntryEntityProperty entity);
	
}
