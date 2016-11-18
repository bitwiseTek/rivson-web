package com.bitwise.manageme.rssson.repository.resources;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.resources.ResourceCategory;

public interface ResourceCategoryRepository extends CrudRepository<ResourceCategory, Long> {

	public List<ResourceCategory> findAll();
}
