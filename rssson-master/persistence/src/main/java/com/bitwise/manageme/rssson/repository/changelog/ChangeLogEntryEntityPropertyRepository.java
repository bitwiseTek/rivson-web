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
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;

public interface ChangeLogEntryEntityPropertyRepository extends CrudRepository<ChangeLogEntryEntityProperty, Long> {

	public List<ChangeLogEntryEntityProperty> findAll();
	
	public ChangeLogEntryEntityProperty findByEntityAndName(ChangeLogEntryEntity entity, String name);
	
}
