package com.bitwise.manageme.rssson.service.resources;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.resources.WorkResource;

public interface WorkResourceService {

	public List<WorkResource> findAll();
	
	public WorkResource save(WorkResource resource);
}
