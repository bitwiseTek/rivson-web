package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.GradingScale;

public interface GradingScaleRepository extends CrudRepository<GradingScale, Long> {

	public List<GradingScale> findAll();
	
	public GradingScale findByName(String name);
}
