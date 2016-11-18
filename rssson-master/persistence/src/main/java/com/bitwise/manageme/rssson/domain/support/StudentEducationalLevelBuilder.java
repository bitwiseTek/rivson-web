package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.students.StudentEducationalLevel;

@Component
public class StudentEducationalLevelBuilder extends EntityBuilder<StudentEducationalLevel> {

	@Override
	void initProduct() {
		this.product = new StudentEducationalLevel();
	}
	
	public StudentEducationalLevelBuilder educationalLevel(String name, Boolean archived) {
		this.product.setName(name);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	StudentEducationalLevel assembleProduct() {
		return this.product;
	}

}
