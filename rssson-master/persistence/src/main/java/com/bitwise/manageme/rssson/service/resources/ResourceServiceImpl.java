package com.bitwise.manageme.rssson.service.resources;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.resources.Resource;
import com.bitwise.manageme.rssson.repository.resources.ResourceRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceRepository resourceRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Resource> findAll() {
		return Lists.newArrayList(this.resourceRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public Resource save(Resource resource) {
		return this.resourceRepo.save(resource);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Resource resource) {
		this.resourceRepo.delete(resource);
	}

}
