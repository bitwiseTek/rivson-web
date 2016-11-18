package com.bitwise.manageme.rssson.service.changelog;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntry;
import com.bitwise.manageme.rssson.repository.changelog.ChangeLogEntryRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("changeLogEntryService")
public class ChangeLogEntryServiceImpl implements ChangeLogEntryService {

	@Autowired
	private ChangeLogEntryRepository changeLogEntryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ChangeLogEntry> findAll() {
		return Lists.newArrayList(this.changeLogEntryRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public ChangeLogEntry save(ChangeLogEntry logEntry) {
		return this.changeLogEntryRepo.save(logEntry);
	}

}
