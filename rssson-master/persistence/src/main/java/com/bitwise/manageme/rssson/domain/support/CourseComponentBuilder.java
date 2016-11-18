package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseComponent;

@Component
public class CourseComponentBuilder extends EntityBuilder<CourseComponent> {

	@Override
	void initProduct() {
		this.product = new CourseComponent();
	}

	public CourseComponentBuilder courseBase(CourseBase courseBase) {
		this.product.setCourseBase(courseBase);
		return this;
	}
	
	public CourseComponentBuilder course(Course course) {
		this.product.setCourse(course);
		return this;
	}
	
	@Override
	CourseComponent assembleProduct() {
		return this.product;
	}

}
