package com.bitwise.manageme.rssson.service.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.repository.base.LGARepository;
import com.google.common.collect.Lists;

@Transactional
@Service("lgaService")
public class LGAServiceImpl implements LGAService {

	@Autowired
	private LGARepository lgaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<LGA> findAll() {
		return Lists.newArrayList(this.lgaRepository.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public LGA findByCode(String code) {
		return this.lgaRepository.findByCode(code);
	}

	@Override
	@Transactional(readOnly=false)
	public LGA save(LGA lga) {
		return this.lgaRepository.save(lga);
	}

}
