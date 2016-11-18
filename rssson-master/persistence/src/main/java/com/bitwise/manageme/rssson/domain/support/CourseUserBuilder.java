package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseUser;

@Component
public class CourseUserBuilder extends EntityBuilder<CourseUser> {

	@Override
	void initProduct() {
		this.product = new CourseUser();
	}

	public CourseUserBuilder course(Course course) {
		this.product.setCourse(course);
		return this;
	}
	
	@Override
	CourseUser assembleProduct() {
		return this.product;
	}

}
