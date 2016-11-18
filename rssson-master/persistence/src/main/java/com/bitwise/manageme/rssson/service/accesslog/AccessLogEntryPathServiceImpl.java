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

import com.bitwise.manageme.rssson.domain.accesslog.AccessLogEntryPath;
import com.bitwise.manageme.rssson.repository.accesslog.AccessLogEntryPathRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("accessLogEntryPathService")
public class AccessLogEntryPathServiceImpl implements AccessLogEntryPathService {

	@Autowired
	private AccessLogEntryPathRepository logEntryPathRepo;
	
	@Override
	@Transactional(readOnly=true)
	public AccessLogEntryPath findByPath(String path) {
		return this.logEntryPathRepo.findByPath(path);
	}

	@Override
	@Transactional(readOnly=true)
	public List<AccessLogEntryPath> findAll() {
		return Lists.newArrayList(this.logEntryPathRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public AccessLogEntryPath save(AccessLogEntryPath path) {
		return this.logEntryPathRepo.save(path);
	}

}
