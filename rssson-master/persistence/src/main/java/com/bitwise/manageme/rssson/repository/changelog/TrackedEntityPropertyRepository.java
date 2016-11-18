package com.bitwise.manageme.rssson.repository.changelog;
/**
 *  
 * @author Sika Kay
 * @date 21/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.changelog.TrackedEntityProperty;

public interface TrackedEntityPropertyRepository extends CrudRepository<TrackedEntityProperty, Long> {

	public List<TrackedEntityProperty> findAll();
	
	public TrackedEntityProperty findByEntityAndProperty(String entity, String property);
	
}
