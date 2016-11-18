package com.bitwise.manageme.rssson.service.accesslog;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntry;
import com.bitwise.manageme.rssson.repository.accesslog.AccessLogEntryRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("accessLogEntryService")
public class AccessLogEntryServiceImpl implements AccessLogEntryService {

	@Autowired
	private AccessLogEntryRepository logEntryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<AccessLogEntry> findAll() {
		return Lists.newArrayList(this.logEntryRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public AccessLogEntry save(AccessLogEntry entry) {
		return this.logEntryRepo.save(entry);
	}

}
