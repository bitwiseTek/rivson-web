package com.bitwise.manageme.rssson.repository.changelog;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntity;

public interface ChangeLogEntryEntityRepository extends CrudRepository<ChangeLogEntryEntity, Long> {

	public List<ChangeLogEntryEntity> findAll();
	
	public ChangeLogEntryEntity findByName(String name);
}
