package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.grading.Grade;
import com.bitwise.manageme.rssson.domain.grading.GradingScale;

@Component
public class GradeBuilder extends EntityBuilder<Grade> {

	@Override
	void initProduct() {
		this.product = new Grade();
	}
	
	public GradeBuilder gradingScale(GradingScale scale) {
		this.product.setGradingScale(scale);
		return this;
	}
	
	public GradeBuilder grade(String name, String description, Boolean passingGrade, Boolean archived, String qualification, Double gPA) {
		this.product.setName(name);
		this.product.setDescription(description);
		this.product.setPassingGrade(passingGrade);
		this.product.setArchived(archived);
		this.product.setQualification(qualification);
		this.product.setGPA(gPA);
		return this;
	}

	@Override
	Grade assembleProduct() {
		return this.product;
	}

}
