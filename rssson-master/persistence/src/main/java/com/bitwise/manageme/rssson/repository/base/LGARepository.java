package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.LGA;

public interface LGARepository extends CrudRepository<LGA, Long> {

	public List<LGA> findAll();
	
	public LGA findByCode(String code);
}
