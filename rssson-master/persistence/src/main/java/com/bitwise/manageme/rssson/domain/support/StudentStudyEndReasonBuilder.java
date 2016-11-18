package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;

@Component
public class StudentStudyEndReasonBuilder extends EntityBuilder<StudentStudyEndReason> {

	@Override
	void initProduct() {
		this.product = new StudentStudyEndReason();
	}

	public StudentStudyEndReasonBuilder parentReason(StudentStudyEndReason parentReason) {
		this.product.setParentReason(parentReason);
		return this;
	}
	
	public StudentStudyEndReasonBuilder reason(String name) {
		this.product.setName(name);
		return this;
	}
	
	@Override
	StudentStudyEndReason assembleProduct() {
		return this.product;
	}

}
