package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentActivityType;
import com.bitwise.manageme.rssson.domain.students.StudentEducationalLevel;
import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;
import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class StudentBuilder extends EntityBuilder<Student> {

	@Override
	void initProduct() {
		this.product = new Student();
	}

	public StudentBuilder studentActivityType(StudentActivityType activityType) {
		this.product.setActivityType(activityType);
		return this;
	}

	public StudentBuilder studentEducationalLevel(StudentEducationalLevel educationalLevel) {
		this.product.setEducationalLevel(educationalLevel);
		return this;
	}

	public StudentBuilder studentExaminationType(StudentExaminationType examinationType) {
		this.product.setExaminationType(examinationType);
		return this;
	}

	public StudentBuilder studentStudyEndReason(StudentStudyEndReason endReason) {
		this.product.setStudyEndReason(endReason);
		return this;
	}

	public StudentBuilder studyProgramme(StudyProgramme programme) {
		this.product.setStudyProgramme(programme);
		return this;
	}
	
	public StudentBuilder user(User user) {
		this.product.setUser(user);
		return this;
	}
	
	public StudentBuilder state(String state) {
		this.product.setStateOfOrigin(state);
		return this;
	}
	
	public StudentBuilder lga(LGA lga) {
		this.product.setLga(lga);
		return this;
	}

	public StudentBuilder studentDetails(String studentId, String additionalInfo, String nationality, Boolean lodging, String nickname,
			Double previousStudies, DateTime studyStartDate, DateTime studyEndDate, String studyEndText, Date studyTimeEnd) {
		this.product.setStudentId(studentId);
		this.product.setAdditionalInfo(additionalInfo);
		this.product.setNationality(nationality);
		this.product.setLodging(lodging);
		this.product.setNickname(nickname);
		this.product.setPreviousStudies(previousStudies);
		this.product.setStudyStartDate(studyStartDate);
		this.product.setStudyEndDate(studyEndDate);
		this.product.setStudyEndText(studyEndText);
		this.product.setStudyTimeEnd(studyTimeEnd);
		return this;
	}

	@Override
	Student assembleProduct() {
		return this.product;
	}

}
