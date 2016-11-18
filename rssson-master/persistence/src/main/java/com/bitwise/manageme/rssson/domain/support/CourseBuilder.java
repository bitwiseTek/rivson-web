package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseState;
import com.bitwise.manageme.rssson.domain.courses.CourseType;

@Component
public class CourseBuilder extends EntityBuilder<Course> {

	@Override
	void initProduct() {
		this.product = new Course();
	}

	public CourseBuilder courseBase(CourseBase base) {
		this.product.setCourseBase(base);
		return this;
	}

	public CourseBuilder courseState(CourseState state) {
		this.product.setState(state);
		return this;
	}

	public CourseBuilder courseType(CourseType type) {
		this.product.setType(type);
		return this;
	}

	public CourseBuilder courseDetails(String name, Double assessingHours, Date beginDate,
			Double distanceTeachingDays, Double distanceTeachingHours, Date endDate, Date enrolmentTimeEnd,
			Double localTeachingDays, Double localTeachingHours, Double planningHours) {
		this.product.setName(name);
		this.product.setAssessingHours(assessingHours);
		this.product.setBeginDate(beginDate);
		this.product.setDistanceTeachingDays(distanceTeachingDays);
		this.product.setDistanceTeachingHours(distanceTeachingHours);
		this.product.setEndDate(endDate);
		this.product.setEnrolmentTimeEnd(enrolmentTimeEnd);
		this.product.setLocalTeachingDays(localTeachingDays);
		this.product.setLocalTeachingHours(localTeachingHours);
		this.product.setPlanningHours(planningHours);
		return this;
	}

	@Override
	Course assembleProduct() {
		return this.product;
	}

}
