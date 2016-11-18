package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.courses.CourseState;

@Component
public class CourseStateBuilder extends EntityBuilder<CourseState> {

	@Override
	void initProduct() {
		this.product = new CourseState();
	}
	
	public CourseStateBuilder courseState(String name, Boolean archived) {
		this.product.setName(name);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	CourseState assembleProduct() {
		return this.product;
	}

}
