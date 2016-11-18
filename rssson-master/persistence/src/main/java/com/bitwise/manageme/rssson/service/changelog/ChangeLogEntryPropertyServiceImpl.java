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

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryProperty;
import com.bitwise.manageme.rssson.repository.changelog.ChangeLogEntryPropertyRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("changeLogEntryPropertyService")
public class ChangeLogEntryPropertyServiceImpl implements ChangeLogEntryPropertyService {

	@Autowired
	private ChangeLogEntryPropertyRepository changeLogEntryPropertyRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ChangeLogEntryProperty> findAll() {
		return Lists.newArrayList(this.changeLogEntryPropertyRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public ChangeLogEntryProperty findLatestByEntryEntityProperty(ChangeLogEntryEntityProperty property, String entityId) {
		return this.changeLogEntryPropertyRepo.findLatestByEntryEntityProperty(property, entityId);
	}

	@Override
	@Transactional(readOnly=false)
	public ChangeLogEntryProperty save(ChangeLogEntryProperty property) {
		return this.changeLogEntryPropertyRepo.save(property);
	}

}
