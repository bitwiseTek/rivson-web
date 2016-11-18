package com.bitwise.manageme.rssson.service.resources;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.resources.Resource;

public interface ResourceService {

	public List<Resource> findAll();
	
	public Resource save(Resource resource);
	
	public void delete(Resource resource);

}
