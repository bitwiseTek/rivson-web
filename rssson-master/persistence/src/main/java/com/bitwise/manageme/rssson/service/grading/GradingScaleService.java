package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.GradingScale;

public interface GradingScaleService {

	public List<GradingScale> findAll();
	
	public GradingScale findById(Long id);
	
	public GradingScale findByName(String name);
	
	public GradingScale save(GradingScale scale);
	
	public void delete(GradingScale scale);

}
