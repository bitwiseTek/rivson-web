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

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntity;
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;
import com.bitwise.manageme.rssson.repository.changelog.ChangeLogEntryEntityPropertyRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("changeLogEntryEntityPropertyService")
public class ChangeLogEntryEntityPropertyServiceImpl implements ChangeLogEntryEntityPropertyService {

	@Autowired
	private ChangeLogEntryEntityPropertyRepository changeLogEntryEntityPropertyRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ChangeLogEntryEntityProperty> findAll() {
		return Lists.newArrayList(this.changeLogEntryEntityPropertyRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public ChangeLogEntryEntityProperty findByEntityAndName(ChangeLogEntryEntity entity, String name) {
		return this.changeLogEntryEntityPropertyRepo.findByEntityAndName(entity, name);
	}

	@Override
	@Transactional(readOnly=false)
	public ChangeLogEntryEntityProperty save(ChangeLogEntryEntityProperty entityProperty) {
		return this.changeLogEntryEntityPropertyRepo.save(entityProperty);
	}

}
