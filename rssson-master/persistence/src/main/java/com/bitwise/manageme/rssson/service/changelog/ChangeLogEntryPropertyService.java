package com.bitwise.manageme.rssson.service.changelog;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryProperty;

public interface ChangeLogEntryPropertyService {

	public List<ChangeLogEntryProperty> findAll();
	
	public ChangeLogEntryProperty findLatestByEntryEntityProperty(ChangeLogEntryEntityProperty property, String entityId);
	
	public ChangeLogEntryProperty save(ChangeLogEntryProperty property);
}
