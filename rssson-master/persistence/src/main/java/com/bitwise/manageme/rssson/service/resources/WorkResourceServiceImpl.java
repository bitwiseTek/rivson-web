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

import com.bitwise.manageme.rssson.domain.resources.WorkResource;
import com.bitwise.manageme.rssson.repository.resources.WorkResourceRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("workResourceService")
public class WorkResourceServiceImpl implements WorkResourceService {

	@Autowired
	private WorkResourceRepository workResourceRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<WorkResource> findAll() {
		return Lists.newArrayList(this.workResourceRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public WorkResource save(WorkResource resource) {
		return this.workResourceRepo.save(resource);
	}

}
