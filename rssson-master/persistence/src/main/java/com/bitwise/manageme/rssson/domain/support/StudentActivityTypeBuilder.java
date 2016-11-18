package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.students.StudentActivityType;

@Component
public class StudentActivityTypeBuilder extends EntityBuilder<StudentActivityType> {

	@Override
	void initProduct() {
		this.product = new StudentActivityType();
	}
	
	public StudentActivityTypeBuilder activityType(String name, Boolean archived) {
		this.product.setName(name);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	StudentActivityType assembleProduct() {
		return this.product;
	}

}
