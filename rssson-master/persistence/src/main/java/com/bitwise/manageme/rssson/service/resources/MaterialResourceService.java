package com.bitwise.manageme.rssson.service.resources;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.resources.MaterialResource;

public interface MaterialResourceService {

	public List<MaterialResource> findAll();
	
	public MaterialResource save(MaterialResource resource);
}
