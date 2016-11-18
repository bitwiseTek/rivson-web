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
import com.bitwise.manageme.rssson.repository.changelog.ChangeLogEntryEntityRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("changeLogEntryEntityService")
public class ChangeLogEntryEntityServiceImpl implements ChangeLogEntryEntityService {

	@Autowired
	private ChangeLogEntryEntityRepository changeLogEntryEntityRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ChangeLogEntryEntity> findAll() {
		return Lists.newArrayList(this.changeLogEntryEntityRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public ChangeLogEntryEntity findByName(String name) {
		return this.changeLogEntryEntityRepo.findByName(name);
	}

	@Override
	@Transactional(readOnly=false)
	public ChangeLogEntryEntity save(ChangeLogEntryEntity entity) {
		return this.changeLogEntryEntityRepo.save(entity);
	}

}
