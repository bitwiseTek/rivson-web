package com.bitwise.manageme.rssson.service.accesslog;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntry;

public interface AccessLogEntryService {
	
	public List<AccessLogEntry> findAll();
	
	public AccessLogEntry save(AccessLogEntry entry);
	
}
