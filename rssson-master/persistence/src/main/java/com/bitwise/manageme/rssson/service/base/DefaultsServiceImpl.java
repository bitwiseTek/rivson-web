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

import com.bitwise.manageme.rssson.domain.base.Defaults;
import com.bitwise.manageme.rssson.repository.base.DefaultsRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("defaultsService")
public class DefaultsServiceImpl implements DefaultsService {

	@Autowired
	private DefaultsRepository defaultsRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Defaults> findAll() {
		return Lists.newArrayList(this.defaultsRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public Defaults save(Defaults defaults) {
		return this.defaultsRepo.save(defaults);
	}

}
