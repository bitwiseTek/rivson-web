package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseUser;
import com.bitwise.manageme.rssson.domain.students.Student;

@Component
public class CourseStudentBuilder extends EntityBuilder<CourseStudent> {

	@Override
	void initProduct() {
		this.product = new CourseStudent();
	}

	public CourseStudentBuilder billingDetails(BillingDetails billingDetails) {
		this.product.setBillingDetails(billingDetails);
		return this;
	}

	public CourseStudentBuilder courseEnrolmentType(String enrolmentType) {
		this.product.setCourseEnrolmentType(enrolmentType);
		return this;
	}

	public CourseStudentBuilder courseOptionality(String optionality) {
		this.product.setCourseOptionality(optionality);
		return this;
	}

	public CourseStudentBuilder courseParticipationType(String participationType) {
		this.product.setParticipationType(participationType);
		return this;
	}

	public CourseStudentBuilder room(Room room) {
		this.product.setRoom(room);
		return this;
	}

	public CourseStudentBuilder student(Student student) {
		this.product.setStudent(student);
		return this;
	}
	
	public CourseStudentBuilder courseUser(CourseUser courseUser) {
		this.product.setCourseUser(courseUser);
		return this;
	}

	public CourseStudentBuilder courseStudentDetails(String additionalInfo, String participationType, String enrolmentType, DateTime enrolmentTime, Boolean lodging, Boolean archived) {
		this.product.setAdditionalInfo(additionalInfo);
		this.product.setParticipationType(participationType);
		this.product.setCourseEnrolmentType(enrolmentType);
		this.product.setEnrolmentTime(enrolmentTime);
		this.product.setLodging(lodging);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	CourseStudent assembleProduct() {
		return this.product;
	}

}
