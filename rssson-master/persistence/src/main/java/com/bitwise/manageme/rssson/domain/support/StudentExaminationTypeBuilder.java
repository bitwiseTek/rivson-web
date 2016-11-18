package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;

@Component
public class StudentExaminationTypeBuilder extends EntityBuilder<StudentExaminationType> {

	@Override
	void initProduct() {
		this.product = new StudentExaminationType();
	}

	public StudentExaminationTypeBuilder examinationType(String name, Boolean archived) {
		this.product.setName(name);
		this.product.setArchived(archived);
		return this;
	}
	
	@Override
	StudentExaminationType assembleProduct() {
		return this.product;
	}

}
