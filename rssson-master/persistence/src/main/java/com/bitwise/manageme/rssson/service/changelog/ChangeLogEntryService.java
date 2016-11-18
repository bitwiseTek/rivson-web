package com.bitwise.manageme.rssson.service.changelog;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntry;

public interface ChangeLogEntryService {

	public List<ChangeLogEntry> findAll();
	
	public ChangeLogEntry save(ChangeLogEntry logEntry);
}
