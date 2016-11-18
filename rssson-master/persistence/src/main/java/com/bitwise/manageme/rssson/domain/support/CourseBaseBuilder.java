package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class CourseBaseBuilder extends EntityBuilder<CourseBase> {

	@Override
	void initProduct() {
		this.product = new CourseBase();
	}

	public CourseBaseBuilder user(User user) {
		this.product.setCreator(user);
		return this;
	}
	
	public CourseBaseBuilder modifier(User lastModifier) {
		this.product.setLastModifier(lastModifier);
		return this;
	}
	
	public CourseBaseBuilder educationalLength(EducationalLength eduLength) {
		this.product.setCourseLength(eduLength);
		return this;
	}
	
	public CourseBaseBuilder educationalLengthUnit(EducationalLength eduLengthUnit) {
		this.product.setCourseLength(eduLengthUnit);
		return this;
	}
	
	public CourseBaseBuilder courseBaseDetails(String courseCode, String description, String name, DateTime created, DateTime lastModified, Long maxParticipationCount) {
		this.product.setCourseCode(courseCode);
		this.product.setDescription(description);
		this.product.setName(name);
		this.product.setCreated(created);
		this.product.setLastModified(lastModified);
		this.product.setMaxParticipationCount(maxParticipationCount);
		return this;
	}
	
	public CourseBaseBuilder archived(Boolean archived) {
		this.product.setArchived(archived);
		return this;
	}
	
	@Override
	CourseBase assembleProduct() {
		return this.product;
	}

}
