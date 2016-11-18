package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 26/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.ComponentBase;
import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.repository.base.ComponentBaseRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("componentBaseService")
public class ComponentBaseServiceImpl implements ComponentBaseService {

	@Autowired
	private ComponentBaseRepository componentBaseRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ComponentBase> findAll() {
		return Lists.newArrayList(this.componentBaseRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public CourseBaseVariableKey findByVariableKey(String key) {
		return this.componentBaseRepo.findByVariableKey(key);
	}

	@Override
	@Transactional(readOnly=false)
	public ComponentBase save(ComponentBase componentBase) {
		return this.componentBaseRepo.save(componentBase);
	}

}
