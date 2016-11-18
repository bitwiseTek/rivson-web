package com.bitwise.manageme.rssson.repository.changelog;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryEntityProperty;
import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntryProperty;

public interface ChangeLogEntryPropertyRepository extends CrudRepository<ChangeLogEntryProperty, Long> {

	public List<ChangeLogEntryProperty> findAll();
	
	public ChangeLogEntryProperty findLatestByEntryEntityProperty(ChangeLogEntryEntityProperty property, String entityId);
}
