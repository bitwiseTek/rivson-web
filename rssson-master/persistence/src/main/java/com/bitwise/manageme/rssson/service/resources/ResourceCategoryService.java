package com.bitwise.manageme.rssson.service.resources;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.resources.ResourceCategory;

public interface ResourceCategoryService {

	public List<ResourceCategory> findAll();
	
	public ResourceCategory save(ResourceCategory resourceCategory);
	
	public void delete(ResourceCategory resourceCategory);

}
