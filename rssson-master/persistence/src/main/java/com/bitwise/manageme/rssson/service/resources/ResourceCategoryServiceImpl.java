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

import com.bitwise.manageme.rssson.domain.resources.ResourceCategory;
import com.bitwise.manageme.rssson.repository.resources.ResourceCategoryRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("resourceCategoryService")
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

	@Autowired
	private ResourceCategoryRepository resourceCategoryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ResourceCategory> findAll() {
		return Lists.newArrayList(this.resourceCategoryRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public ResourceCategory save(ResourceCategory resourceCategory) {
		return this.resourceCategoryRepo.save(resourceCategory);
	}

	@Override
	public void delete(ResourceCategory resourceCategory) {
		this.resourceCategoryRepo.delete(resourceCategory);
	}

}
