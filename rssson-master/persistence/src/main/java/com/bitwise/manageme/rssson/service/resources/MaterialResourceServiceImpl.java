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

import com.bitwise.manageme.rssson.domain.resources.MaterialResource;
import com.bitwise.manageme.rssson.repository.resources.MaterialResourceRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("materialResourceService")
public class MaterialResourceServiceImpl implements MaterialResourceService {

	@Autowired
	private MaterialResourceRepository materialResourceRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<MaterialResource> findAll() {
		return Lists.newArrayList(this.materialResourceRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public MaterialResource save(MaterialResource resource) {
		return this.materialResourceRepo.save(resource);
	}

}
