package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.courses.CourseType;

@Component
public class CourseTypeBuilder extends EntityBuilder<CourseType> {

	@Override
	void initProduct() {
		this.product = new CourseType();
	}
	
	public CourseTypeBuilder type(String name, Boolean archived) {
		this.product.setName(name);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	CourseType assembleProduct() {
		return this.product;
	}

}
