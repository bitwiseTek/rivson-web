package com.bitwise.manageme.rssson.repository.changelog;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.changelog.ChangeLogEntry;

public interface ChangeLogEntryRepository extends CrudRepository<ChangeLogEntry, Long> {

	public List<ChangeLogEntry> findAll();
}
