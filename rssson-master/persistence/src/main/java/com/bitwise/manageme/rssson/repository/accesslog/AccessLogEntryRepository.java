package com.bitwise.manageme.rssson.repository.accesslog;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntry;

public interface AccessLogEntryRepository extends CrudRepository<AccessLogEntry, Long> {
	
	public List<AccessLogEntry> findAll();
	
}
