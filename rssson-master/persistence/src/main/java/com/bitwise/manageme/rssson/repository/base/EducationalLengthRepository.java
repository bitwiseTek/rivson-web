package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.base.EducationalLength;

public interface EducationalLengthRepository extends CrudRepository<EducationalLength, Long>{

	public List<EducationalLength> findAll();
}
