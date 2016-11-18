package com.bitwise.manageme.rssson.service.accesslog;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntryPath;

public interface AccessLogEntryPathService {
	
	public AccessLogEntryPath findByPath(String path);
	
	public List<AccessLogEntryPath> findAll();
	
	public AccessLogEntryPath save(AccessLogEntryPath path);
	
}
