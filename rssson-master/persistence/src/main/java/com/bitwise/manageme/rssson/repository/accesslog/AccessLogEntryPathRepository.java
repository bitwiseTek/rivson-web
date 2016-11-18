package com.bitwise.manageme.rssson.repository.accesslog;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntryPath;

public interface AccessLogEntryPathRepository extends CrudRepository<AccessLogEntryPath, Long>{
	
	public AccessLogEntryPath findByPath(String path);
	
	public List<AccessLogEntryPath> findAll();
	
}
