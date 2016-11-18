package com.bitwise.manageme.rssson.service.changelog;
/**
 *  
 * @author Sika Kay
 * @date 27/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntity;

public interface ChangeLogEntryEntityService {

	public List<ChangeLogEntryEntity> findAll();
	
	public ChangeLogEntryEntity findByName(String name);
	
	public ChangeLogEntryEntity save(ChangeLogEntryEntity entity);
}
